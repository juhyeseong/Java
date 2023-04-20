package quiz;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		// 두 정수를 입력받아서, 첫 번째 정수와 두 번째 정수의 크기를 비교하여
		// 크다, 같다, 작다로 구분하여 출력하세요
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		
		System.out.print("첫 번째 정수 입력 : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두 번째 정수 입력 : ");
		num2 = Integer.parseInt(sc.nextLine());
		
		if(num1 > num2) {
			System.out.printf("%d(은)는 %d보다 크다", num1, num2);
		}
		else if (num1 == num2) {
			System.out.print("두 수는 서로 같다");
		}
		else {
			System.out.printf("%d(은)는 %d보다 작다", num1, num2);
		}
		
		sc.close();
	}
}
