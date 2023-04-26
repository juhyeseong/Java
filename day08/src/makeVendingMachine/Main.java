package makeVendingMachine;

import java.util.Scanner;

// 자판기 객체 및 상품 객체를 생성하여
// 코드를 진행하는 클래스
// 사용자 입력에 따라서 출력을 진행한다

public class Main {
	public static void main(String[] args) {
		
		Machine machine = new Machine();
		Scanner sc = new Scanner(System.in);
		int money, select;
		
		while(true) {
			System.out.print("금액을 입력하세요 : ");
			money = Integer.parseInt(sc.nextLine());	// 금액을 입력받아서
			
			boolean ready = machine.inputMoney(money);	// 돈을 자판기에 전달하고
			if(ready) {	// 넣은 돈이 상품을 뽑을만큼 충분하다면
				break;	// 돈을 더이상 입력받지 않고 중단한 이후
			}
		}
		
		while(machine.isEnoughMoney()) {
			
			machine.show();	// 구매할 상품의 목록을 출력한다
			
			System.out.print("음료를 선택하세요 : ");
			select = Integer.parseInt(sc.nextLine());
			
			Product drink = machine.getProduct(select);
			if(drink == null) {
				System.out.println("상품이 없거나 금액이 충분하지 않습니다");
			}
			else {
				System.out.println(drink.getName() + " 하나 나왔습니다\n");
			}
		}
		
		int change = machine.getChange();
		System.out.printf("거스름돈 : %,d원\n", change );
		
		sc.close();
	}
}
