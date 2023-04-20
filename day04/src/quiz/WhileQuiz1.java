package quiz;

import java.util.Scanner;

public class WhileQuiz1 {
	public static void main(String[] args) {
		// while을 활용하여 다음 문제를 풀어주세요
		
		// 1) Hello, world 를 3번만 출력하세요
		System.out.print("1) ");
		int limit = 0;
		
		while(limit < 3) {
			System.out.println("Hello, worl");
			limit++;
		}
		
		// 2) 1부터 20까지 한 줄에 띄어쓰기로 구분하여 출력하세요
		System.out.print("2) ");
		int result = 0;
		limit = 0;
		
		while(limit < 20) {
			result += 1;
			System.out.print(result + " ");
			limit++;
		}
		
		System.out.println();
		
		// 3) A부터 Z까지 한줄에 콤마로 구분하여 출력하세요
		// 단, 마지막에는 콤마가 없어야 합니다
		System.out.print("3) ");
		char ch = 'A';
		
		while(ch <= 'Z') {
			System.out.printf("%s%s",ch, ch == 'Z' ? "\n" : ", ");	
			ch++;
		}
		
		// 4) 1부터 100 사이의 정수 중 홀수의 합과 짝수의 합을 각각 계산하여 출력하세요
		System.out.print("4) ");
		int evenSum = 0, oddSum = 0;
		limit = 1;
		
		while(limit <= 100) {
			if(limit % 2 == 0) {
				evenSum += limit;
			}
			else {
				oddSum += limit;
			}
			limit++;
		}
		System.out.printf("짝수의 합 : %d, 홀수의 합 : %d\n", evenSum, oddSum);
		
		// 5) 입력받은 정수를 거꾸로 출력하세요
		// 입력 : 1234
		// 출력 : 4321
		System.out.print("5) ");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		result = 0;

		while(num != 0) {
			result *= 10;
			result += num % 10;
			num /= 10;
		}
		System.out.println("결과 : " + result);
		
		sc.close();
	}
}
