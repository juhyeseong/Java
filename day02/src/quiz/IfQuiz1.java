package quiz;

import java.util.Scanner;

public class IfQuiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1) 정수를 입력받아서 절대값을 출력하기
		System.out.print("정수1 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		if(num1 < 0) { num1 = -num1; }
		
		System.out.println("절대값 : " + num1);
		
		System.out.println();
		
		// 2) 두 정수를 입력받아서 작은 값을 출력하기
		int num2, num3;
		
		System.out.print("정수2 입력 : ");
		num2 = Integer.parseInt(sc.nextLine());
		System.out.print("정수3 입력 : ");
		num3 = Integer.parseInt(sc.nextLine());
		
		if(num2 > num3) {
			System.out.println("작은 값 : " + num3);
		}
		else {
			System.out.println("작은 값 : " + num2);
		}
		
		System.out.println();
		
		// 3) 세 정수를 입력받아서 가장 작은 값을 출력하기
		int num4, num5, num6, min;
		
		System.out.print("정수4 입력 : ");
		num4 = Integer.parseInt(sc.nextLine());
		System.out.print("정수5 입력 : ");
		num5 = Integer.parseInt(sc.nextLine());
		System.out.print("정수6 입력 : ");
		num6 = Integer.parseInt(sc.nextLine());
		min = num4;
		
		if(min > num5) {
			min = num5;
		}
		if(min > num6) {
			min = num6;
		}
		
		System.out.println("가장 작은 값 : " + min);
		
		System.out.println();
		
		// 4) 정수의 범위가 1에서 20사이에 포함되면 true, 아니면 false 출력하기
		System.out.print("정수7 입력 : ");
		int num7 = Integer.parseInt(sc.nextLine());
		boolean range = 1 <= num7 && num7 <= 20;
		
		System.out.println("1 ~ 20 사이의 값 : " + range);
	}
}
