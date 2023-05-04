package exception;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// Exception : 코드 수정에 따라 처리할 수 있는 문제점, 예외
		// Error : 코드와 무관하게 원인을 알수 없는 문제점, 에러, 오류
		
		Scanner sc = new Scanner(System.in);
		int num;
		String input;
		
		System.out.print("정수를 입력 : ");
		input = sc.nextLine();
		
		boolean isDigit = true;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) < '0' || '9' < input.charAt(i)) {
				isDigit = false;
			}
		}
		
		if(input.contains(".")) {
			System.out.println(".을 포함하면 안됩니다");
		}
		else if(isDigit == false) {
			System.out.println("문자열이 아닌 정수만 입력해야 합니다");
		}
		else {
			num = Integer.parseInt(input);
			System.out.println("num : " + num);
		}
		sc.close();
		
		// 자바에서는 예외도 클래스로 규정하여, 예외 객체가 발생하고, 이를 처리해야 한다
		
	}
}



