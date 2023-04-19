package quiz;

import java.util.Scanner;

public class QuizWhile1 {
	public static void main(String[] args) {
		// while을 활용하여 다음 문제를 풀어주세요
		
		// 1) Hello, world 를 3번만 출력하세요
		int n1 = 0;				// 반복 횟수를 체크하기 위한 변수
		while(n1 < 3) {			// 0부터 시작하여 3보다 작을 때까지 (3번 반복)
			System.out.println("Hello, world");	// 먼저 출력하고
			n1++;	// 증가는 나중에 한다
		}
		System.out.println();
		
		// 2) 1부터 20까지 한 줄에 띄어쓰기로 구분하여 출력하세요
		int n2 = 1;
		while(n2 <= 20) {
			System.out.print(n2 + " ");
			n2++;
		}
		System.out.println();
		
		// 3) A부터 Z까지 한 줄에 콤마로 구분하여 출력하세요
		// 단, 마지막에는 콤마가 없어야 합니다
		char ch = 'A';		// 65		// A부터 시작해서
		while(ch <= 'Z') {	// 90		// Z가 될때 까지 반복하면서
			System.out.print(ch);		// 글자를 출력하고
			if(ch == 'Z') {				// 만약 글자가 Z이면(마지막이면)
				System.out.print("\n");	// 줄을 바꾼다
			}
			else {						// 마지막 글자가 아니면
				System.out.print(", ");	// 콤마를 찍고 줄을 바꾸지 않는다
			}
			ch++;	// 출력이 끝나면 다음 글자를 준비하기 위해 값을 1 증가시킨다
		}
		System.out.println();
		
		// 4) 1부터 100 사이의 정수 중 홀수의 합과 짝수의 합을 각각 계산하여 출력하세요
		int oddSum = 0, evenSum = 0, n4 = 1;
		
		while(n4 <= 100) {
			if(n4 % 2 == 0) {
				evenSum += n4;
			}
			else {
				oddSum += n4;
			}
			n4++;
		}

		System.out.printf("홀수의 합 : %d, 짝수의 합 : %d\n", oddSum, evenSum);
		
		// 5) 입력받은 정수를 거꾸로 출력하세요
		// 입력 : 1234
		// 출력 : 4321
		Scanner sc = new Scanner(System.in);
		int n5, result = 0;
		
		System.out.print("5) 정수 입력 : ");
		n5 = Integer.parseInt(sc.nextLine());
//									n5			result
//		result *= 10;		//		1234		0
//		result += n5 % 10;	//		1234		4
//		n5 /= 10;			//		123			4
//
//		result *= 10;		// 		123			40
//		result += n5 % 10;	//		123			43
//		n5 /= 10;			// 		12			43
//
//		result *= 10;		//		12			430
//		result += n5 % 10;	//		12			432
//		n5 /= 10;			// 		1			432
//		
//		result *= 10;		//		1			4320
//		result += n5 % 10;	//		1			4321
//		n5 /= 10;			//		0			4321
		
		
//		while(n5 != 0) {
//			System.out.print(n5 % 10);
//			n5 /= 10;
//		}
//		System.out.println();
		
		while(n5 != 0) {
			result *= 10;		
			result += n5 % 10;	
			n5 /= 10;
		}
		System.out.println(result);
		
		sc.close();
	}
}









