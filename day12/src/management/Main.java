package management;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 사용자와 상호작용
		
		Scanner sc = new Scanner(System.in);			// 입력받기 위한 Scanner
		int menu;										// 메뉴 선택
		String name;									// 이름 (생성 및 삭제에 활용)
		int kor, algorithm, dataStruct, translation;	// 각 과목 점수
		int type, row;									// 생성 시 유형, 실행 후 결과
		Student st = null;								// 생성에 사용하는 참조변수
		Handler handler = new Handler();				// 데이터 저장 및 기능 핸들러
		ArrayList<Student> list = null;					// 목록 출력시 사용하는 리스트 참조변수
		
		do {
			System.out.println("1. 추가");
			System.out.println("2. 전체목록");
			System.out.println("3. 삭제");
			System.out.println("0. 종료");
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:	// 추가
				System.out.println("유형을 선택하세요 (1. 컴공 | 2. 중문) : ");
				type = Integer.parseInt(sc.nextLine());
				
				System.out.print("이름 입력 : ");
				name = sc.nextLine();
				
				System.out.print("국어 입력 : ");
				kor = Integer.parseInt(sc.nextLine());
				
				if(type == 1) {	// 컴공
					System.out.print("알고리즘 입력 : ");
					algorithm = Integer.parseInt(sc.nextLine());
					
					System.out.print("자료구조 입력 : ");
					dataStruct = Integer.parseInt(sc.nextLine());
					
					st = new ComputerScienceStudent(name, kor, algorithm, dataStruct);
				}
				else if(type == 2) {	// 중문과
					System.out.print("번역 점수 입력 : ");
					translation = Integer.parseInt(sc.nextLine());
					
					st = new ChineseLinguisticStudent(name, kor, translation);
				}
				
				row = handler.insert(st);
				System.out.println(row == 1 ? "추가 성공" : "추가 실패");
				
				break;
				
			case 2:	// 전체 목록
				list = handler.select();
				for(Student s : list) {
					System.out.println(s);	// s.toString()
				}
				break;
				
			case 3:	// 삭제
				System.out.print("삭제할 학생의 이름 입력 : ");
				name = sc.nextLine();
				
				row = handler.delete(name);
				System.out.println(row == 1 ? "삭제 성공" : "삭제 실패");
				break;
			}
		} while(menu != 0);
		
		sc.close();
	}
}
