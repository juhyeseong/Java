package thread;

public class Quiz2 {
	public static void main(String[] args) {
		// 5초 안에 정답을 입력하기
		// 1) 답을 입력하면 정답/오답 여부에 상관없이 타이머는 중단한다
		// 2) 입력값이 정답이더라도, 시간을 초과했다면 오답으로 처리한다
		
		Question q = new Question();
		QuizTimer t = new QuizTimer();
		
		q.setTimer(t);
		t.setQuestion(q);
		
		Thread th1 = new Thread(q);
		Thread th2 = new Thread(t);
		
		th2.start();
		th1.start();
		
	}
}
