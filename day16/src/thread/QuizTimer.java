package thread;

public class QuizTimer implements Runnable { // 5초간의 타이머를 처리
	// 질문을 참조하여, 이미 입력이 완료되었다면 더이상 타이머를 진행하지 않는다

	private boolean over = false;
	private Question question;

	public void setQuestion(Question question) {
		this.question = question;
	}
	public boolean isOver() {
		return over;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			for (int i = 5; question.isComplete() == false && i != -1; i--) {
				System.out.println(i + "초");
				Thread.sleep(1000);
			}
			over = true;
		} catch (InterruptedException e) {}
	}
}
