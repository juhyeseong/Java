package exception;

import java.util.Scanner;

class ScoreOutOfBoundsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int score;
	
	public ScoreOutOfBoundsException(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %d : 점수가 범위를 벗어났습니다 (0 ~ 100)", 
				this.getClass().getName(), score);
	}
}

public class Ex03 {
	public static void main(String[] args) {
		// 예외 클래스 만들기 : java.lang.Exception 을 상속받는다
		Scanner sc = new Scanner(System.in);
		int score;
		
		try {
			System.out.print("점수 입력 (0 ~ 100) : ");
			score = Integer.parseInt(sc.nextLine());
			
			if(score < 0 || 100 < score) {
				ScoreOutOfBoundsException e = new ScoreOutOfBoundsException(score);
				throw e; 	// 예외 객체를 생성하여 catch가 받을 수 있도록 던진다
			}
			System.out.println("점수 : " + score);
			
		} catch(ScoreOutOfBoundsException e) {	// try에서 예외 객체를 전달받아야만 한다
			System.err.println(e);
			e.printStackTrace();
			
		} finally {
			sc.close();
		}
		
//		if(score < 0 || 100 < score) {	// 점수가 벗어난 상황을 예외로 처리하기
//			System.out.println("점수가 범위를 벗어났습니다");
//		}
//		else {
//			System.out.println("점수 : " + score);
//		}
		
		
		
		sc.close();
	}
}
