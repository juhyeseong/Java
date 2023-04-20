package quiz;

public class BankGetMoney {
	public static void main(String[] args) {
		// 첫날에 10원으로 시작하여, 하루가 지날 때 마다 2배씩 입금 금액을 늘려나간다
		// 이런 식으로 30일동안 입근했을 때, 은행에 누적된 총 금액이 얼마인지 계산하여 출력하세요
		int day = 1;
		long money = 10, totalPay = 0;
		// 숫자가 너무 커질 것 같을 때는 디버깅을 꼭 해주고 값이 흘러넘친다면 long을 쓰자
		
		while(day <= 30) {
			totalPay += money;
			money *= 2;
			day++;
		}
		
		System.out.printf("누적된 총 금액 : %,d원", totalPay);
	}
}
