package quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		// 놀이기구 이용 시간에 따른 이용 요금을 계산하려고 한다
		// 기본 요금은 3000원 이며, 10분마다 500원의 추가요금이 발생한다
		// 요금표는 다음과 같다
		// 0 ~ 30 : 3000	0
		// 31 ~ 40 : 3500	1
		// 41 ~ 50 : 4000	2
		// 51 ~ 60 : 4500	3
		//...
		
		// 반복문 사용 없이, if를 이용하여 시간을 분 단위로 입력받고, 요금을 계산하여 출력하세요
		
		Scanner sc = new Scanner(System.in);
		int totalTime, price;
		
		System.out.print("이용 시간 입력 : ");
		totalTime = Integer.parseInt(sc.nextLine());
		
		if(totalTime <= 30) {
			price = 3000;
		}
		else {
			price = 3000 + (((totalTime - 21) / 10) * 500); 
		}
		
		System.out.printf("이용시간 : %d분, 요금 : %d원", totalTime, price);
		
		
		
		
	}
}
