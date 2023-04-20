package quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		// 세 정수를 입력받아서, 그 중 가장 큰 수를 화면에 출력하세요
		
		// 변수 선언
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3, max_num;
		
		// 입력
		System.out.printf("첫 번재 정수 입력 : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.printf("두 번재 정수 입력 : ");
		num2 = Integer.parseInt(sc.nextLine());
		System.out.printf("세 번재 정수 입력 : ");
		num3 = Integer.parseInt(sc.nextLine());
		max_num = num1;
		
		// 연산
		if(max_num < num2) {
			if(num2 > num3) {
				max_num = num2;
			}
			else {
				max_num = num3;
			}
		}
		
		// if 밑에 else나 else if를 달면 if가 참일 경우 다음 식이 실행이 되지 않으므로
		// 다음 식을 무조건 실행하고 싶으면 if 밑에 또 if를 달아준다
		
		// 출력
		System.out.printf("가장 큰 값은 %d입니다", max_num);
		
		// 마무리
		sc.close();
	}
}
