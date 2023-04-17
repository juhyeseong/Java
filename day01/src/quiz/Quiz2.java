package quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		/*
		 * 세 과목의 점수를 정수형태로 입력받고, 이름은 문자열로 입력받으세요
		 * 그런 다음, 점수의 합계와 평균을 구합니다
		 * 이때, 평균은 실수형태로 소수점 둘째자리까지 출력할 수 있도록 준비하세요
		 * 
		 * 모든 준비가 끝나면 이름과 합계와 평균만 출력합니다
		 * 
		 * 추가내용) boolean 타입의 변수를 선언하여, 평균이 60점 이상인지 아닌지 판별하여
		 * 결과를 출력하세요
		 * 합격여부 : true
		 */
		
		// 디버깅 시작 : F11
		// 중단점 설정 : Ctrl + shift + b
		// 다음 코드 실행 : F5(Step into), F6(Step over)
		
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat, total;
		double avg;
		String name;
		boolean pass;
		
		System.out.print("이름 입력 : ");
		name = sc.nextLine();
		System.out.print("국어 성적 입력 : ");
		kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 성적 입력 : ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 성적 입력 : ");
		mat = Integer.parseInt(sc.nextLine());
		
		total = kor + eng + mat;
		avg = total / 3.0;
		pass = avg >= 60;
		
		System.out.printf("%s의 성적의 총 합 : %d, 평균 : %.2f, 합격여부 : %s", name, total, avg, pass);
		
		sc.close();
	}
}
