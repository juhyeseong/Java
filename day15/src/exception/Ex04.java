package exception;

import java.util.Scanner;

class Timer {
	private double minute;
	
	public Timer(double minute) {
		this.minute = minute;
	}
	
	public void start() throws Exception { 	// 발생하는 예외를 caller에게 전가시킨다
		
		for(int i = (int)(minute * 60); i != -1; i--) {
			System.out.printf("[%02d : %02d]\n", i / 60, i % 60);
			Thread.sleep(1000); 	// 스레드를 제어하는 과정에서 예외가 발생할 수 있다
		}
	}
}

public class Ex04 {
	public static void main(String[] args) {
		// throws : 현재 함수(callee)에서 발생한 예외를 caller에게 전가시킨다
		Scanner sc = new Scanner(System.in);
		double minute;
		
		System.out.print("타이머 시간 입력 (분) : ");
		minute = Double.parseDouble(sc.nextLine());
		
		Timer ob = new Timer(minute);
		try {
			ob.start();
		} catch(Exception e) {
			e.printStackTrace();
			// print : 출력, stack : 쌓이는 구조(함수스택), trace : 경로, 추적
		}
		sc.close();
		
		// 프로그램의 규모가 커지고, 호출하는 함수의 개수와 스택이 커지면
		// 일일이 처리하는 것보다, throws를 통해서 예외를 한곳에 집중시켜서 처리하는 것이
		// 효율적이다
		
		// 프로그램마다 다른 상황을 가지는데, 규정된 예외만 처리할 수 있다면 유연성이 떨어진다
		// 따라서, 내가 직접 예외 상황을 규정하고 객체를 생성하여 던지는 throw가 필요하다
	}
}
