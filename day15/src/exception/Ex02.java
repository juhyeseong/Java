package exception;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("정수 입력 : ");
		
		try {	// 예외가 발생할 수 있는 코드를 시도한다
			num = Integer.parseInt(sc.nextLine());
			System.out.println("num : " + num);
			
			return;
			
//		} catch(NumberFormatException e) {	// 예상되는 예외가 발생하면 아래 코드를 수행한다
//			System.out.println("정수로 변환할 수 없는 값을 입력했습니다 !!");
//			System.out.println(e); 	// e.toString()
//			e.printStackTrace(); 	// 예외 발생 상황을 상세하게 추적하여 출력한다 (기본값)
			
		} finally {	// 예외 발생 여부에 상관없이 마지막에 반드시 실행한다
			System.out.println("프로그램을 종료합니다");
			sc.close();
		}
		
	}	// end of main()
}
