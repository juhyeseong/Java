package thread;

import java.util.Scanner;
import java.util.Random;

public class Question implements Runnable {	// 입력받아서 정답인지 확인
										// 타이머를 참조하여, 타이머가 끝났으면 무조건 오답처리
	private int input;
	private final int answer;
	private Scanner sc;
	private boolean complete = false;
	private Random ran;
	private int n1, n2;
	private QuizTimer timer;
	
	public Question() {
		ran = new Random();
		n1 = ran.nextInt(10) + 1;
		n2 = ran.nextInt(10) + 1;
		answer = n1 + n2;
	}
	
	public boolean isComplete() {
		return complete;
	}
	public void setTimer(QuizTimer timer) {
		this.timer = timer;
	}
	
	@Override
	public void run() {
		sc = new Scanner(System.in);
		System.out.println("다음 수식의 정답을 맞춰주세요");
		System.out.printf("%d + %d = ?\n", n1, n2);
		System.out.print("정답 입력 : ");
		input = Integer.parseInt(sc.nextLine());
		complete = true;
		
		if(timer.isOver()) {
			System.out.println("오답 (시간 초과)");
		}
		else if(input != answer) {
			System.out.println("오답 ㅋㅋㅋㅋㅋㅋㅋㅋ");
		}
		else {
			System.out.println("정답~");
		}
		sc.close();
	}
}