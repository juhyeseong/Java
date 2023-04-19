package quiz;

public class QuizWhile2 {
	public static void main(String[] args) {
		// 첫날에 10원으로 시작하여, 하루가 지날때 마다 2배씩 입금 금액을 늘려나간다
		// 이런 식으로 30일동안 입금했을때, 은행에 누적된 총 금액이 얼마인지 계산하여 출력하세요
		// 10, 20, 40, 80, 160 ...
		
		// 변수 준비) 입금금액, 날짜, 계좌잔고
		int day = 1;
		long money = 10;
		long bankAccount = 0;
		
		// 날짜가 30이 될때까지
		while(day <= 30) {
			bankAccount += money;	// 계좌에 준비한 돈을 입금한다
			money *= 2;				// 다음날을 위해서 2배의 돈을 준비한다
//			System.out.printf("%d : %,d\n", day, bankAccount);
			day++;					// 하루 넘어감
		}
		System.out.printf("%,d\n", bankAccount);
	}
}
