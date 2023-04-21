package phonebookProgram;

import java.util.Scanner;

public class Main {
	
	// 데이터를 저장할 배열은 어느 함수에서나 접근할 수 있도록 static으로 작성한다
	static Contact[] arr = new Contact[100];
	
	// 프로그램을 시작하면 가장 먼저 실행되는 메인 함수
	public static void main(String[] args) {
		
		int sequence = 100;					// 고유번호 부여에 사용할 변수 (항상 1씩 증가한다)
		Scanner sc = new Scanner(System.in);
		String name, pnum;
		int result, menu, idx;
		Contact tmp;
		String form = "%d) %s : %s\n";
		
		do {
			System.out.println("1. 전화번호 추가");
			System.out.println("2. 전화번호 목록");
			System.out.println("3. 전화번호 수정");
			System.out.println("4. 전화번호 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			
			case 1:		// 추가
				
				System.out.print("이름 입력 : ");
				name = sc.nextLine();
				
				System.out.print("전화번호 입력 : ");
				pnum = sc.nextLine();
				
				tmp = new Contact();
				tmp.idx = sequence++;
				tmp.name = name;
				tmp.pnum = pnum;
				
				result = insert(tmp);
				System.out.println(result == 1 ? "추가 성공" : "추가 실패");
				break;
				
			case 2:		// 목록
				
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {
						System.out.printf(form, arr[i].idx, arr[i].name, arr[i].pnum);
					}
				}
				break;
				
			case 3:		// 수정 (idx로 찾기)
				System.out.print("수정할 데이터의 번호를 입력 : ");
				idx = Integer.parseInt(sc.nextLine());
				
				System.out.print("이름 입력 : ");
				name = sc.nextLine();
				
				System.out.print("전화번호 입력 : ");
				pnum = sc.nextLine();
				
				tmp = new Contact();
//				tmp.idx = sequence++;	// 고유번호까지 변경하려면 이렇게	
				tmp.idx = idx;			// 고유번호는 유지하려면 이렇게 (신규생성이 아니므로 이쪽으로)	
				tmp.name = name;
				tmp.pnum = pnum;
				
				result = update(idx, tmp);
				System.out.println(result == 1 ? "수정 성공" : "수정 실패");
				
				break;
				
			case 4:		// 삭제
				System.out.print("삭제할 정보의 번호를 입력 : ");
				idx = Integer.parseInt(sc.nextLine());
				
				result = delete(idx);
				System.out.println(result == 1 ? "삭제 성공" : "삭제 실패");
				break;
			
			case 0:
				break;
				
			default:
				System.out.println("메뉴를 확인하시고 다시 입력해주세요");
				break;
			}
			System.out.println("\n");
			
		} while(menu != 0);
		
		System.out.println("프로그램을 종료합니다");
		sc.close();
	}
	
	// 데이터를 추가할 때 사용하는 함수
	static int insert(Contact ob) {	// 빈칸을 찾아서, ob를 저장한다
		int row = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = ob;
				row = 1;
				break;
			}
		}
		return row;
	}
	
	// 특정 데이터를 수정할 때 사용하는 함수
	static int update(int idx, Contact ob) {			// idx번 데이터를 찾아서 ob로 교체한다
		int row = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].idx == idx) {	// 빈칸이 아니면서, idx가 일치한다면
				arr[i] = ob;	// 새로운 객체로 덮어씌우고
				row = 1;		// 결과 값 준비
				break;			// 반복 탈출
			}
		}
		return row;
	}
	
	// 특정 데이터를 삭제할 때 사용하는 함수
	static int delete(int idx) {						// idx번 데이터를 찾아서 삭제한다 (빈칸으로 만든다)
		int row = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].idx == idx) {
				arr[i] = null;
				row = 1;
				break;
			}
		}
		return row;
	}
	
}
