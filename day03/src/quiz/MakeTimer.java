package quiz;

import java.util.Scanner;

public class MakeTimer {
	public static void main(String[] args) throws Exception {
		// 사용자에게 타이머 시간을 분단위로 입력받아서
		// 분:초 형식으로 타이머를 출력하면서 0까지 출력하고 나면 종료를 출력하는 코드를 작성하세요
		// 분과 초는 2자리의 정수로 출력하되, 자릿수가 부족하면 0으로 채워줘야 합니다
		
		// 입력 (분) : 2
		// 출력 
		// 02 : 00
		// 01 : 59
		// 01 : 58
		// ...
		// 00 : 01
		// 00 : 00
		// 종료
		
		Scanner sc = new Scanner(System.in);
		double min;
		int second;
		
		System.out.print("타이머 분 입력 : ");
		min = Double.parseDouble(sc.nextLine());	// 분을 입력받아서
			
		second = (int)(min * 60);	// 초를 계산한다
		
		for(int i = second; i != -1; i--) {
			System.out.printf("%02d : %02d\n", i / 60, i % 60);
			Thread.sleep(1000);
		}
		System.out.println("종료");
		sc.close();
		
	}
}











