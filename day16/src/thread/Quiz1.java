package thread;

import java.util.ArrayList;
import java.util.Scanner;

class Timer implements Runnable {
	
	private int second = 10;
	private boolean over;
	
	@Override			// Override 는 메서드 형식을 변경할 수 없어서, throws를 사용할 수 없다
	public void run() {	
		for(int i = second; i != -1; i--) {
			System.err.printf("[%02d : %02d]\n", i / 60, i % 60);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
		over = true;
	}
	
	public boolean isOver() {
		return over;
	}
}


public class Quiz1 {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		// 실행 후 10초간 타이머를 진행하면서, 10초동안 입력받은 문자열을 모두 list에 저장합니다
		// 개수에는 제한이 없습니다
		// 10초가 끝나면, list에 담아둔 문자열을 차례대로 출력하면 됩니다
		// 시간을 체크하면서, 입력도 받아야 한다
		Timer timer = new Timer();
		Thread th1 = new Thread(timer);
		th1.start();
		
//		while(timer.isOver() == false) {	// 타이머가 끝나지 않았다면 반복을 수행한다
//			System.out.print("문자열 입력 : ");		
//			list.add(sc.nextLine());			// 문자열을 입력받아서, 리스트에 추가한다
//		}
		
		while(th1.isAlive()) {	// 스레드가 여전히 실행중이라면 아래 내용을 수행한다
			System.out.print("문자열 입력 : ");
			list.add(sc.nextLine());
		}
		
		list.forEach(str -> System.out.println(str));
		sc.close();
	}
}
