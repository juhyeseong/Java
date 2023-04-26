package makeVendingMachine;

// 여러 상품을 보관하고 기능이 포함된 클래스
// 여러 상품을 저장하기 위한 배열(상품 트레이)이 포함됨

public class Machine {
	
	private Product[] tray1 = new Product[5];
	private Product[] tray2 = new Product[5];
	private Product[] tray3 = new Product[5];
	private Product[] tray4 = new Product[5];
	private int money;
	
	private Product[][] arr = { tray1, tray2, tray3, tray4 };
	
	// 생성자에서 미리 상품들을 준비한다
	public Machine() {
		for(int i = 0; i < tray1.length; i++) {
			tray1[i] = new Product("콜라", 800);
		}
		for(int i = 0; i < tray2.length; i++) {
			tray2[i] = new Product("사이다", 700);
		}
		for(int i = 0; i < tray3.length; i++) {
			tray3[i] = new Product("게토레이", 900);
		}
		for(int i = 0; i < tray4.length; i++) {
			tray4[i] = new Product("비타500", 500);
		}
	}
	
	// 준비된 상품중에서 최소 가격을 구하는 함수(내부용)
	private int getMinimunPrice() {
		int minimumPrice = 99999999;
		for(int i = 0; i < arr.length; i++) {	// tray1, tray2, tray3, tray4
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != null && arr[i][j].getPrice() < minimumPrice) {
					minimumPrice = arr[i][j].getPrice();
				}
			}
		}
		return minimumPrice;
	}
	
	// 돈을 입력받는 함수 (충분한지 반환한다)
	public boolean inputMoney(int money) {
		this.money += money;
		int minimumPrice = getMinimunPrice();
		return this.money >= minimumPrice;
	}
	
	// 칸의 개수 말고 실제 상품의 개수를 세어주는 함수
	private int countOfTray(Product[] tray) {
		int count = 0;
		for(int i = 0; i < tray.length; i++) {
			if(tray[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	// 상품 내역과 가격, 수량을 출력하는 함수
	void show() {
		System.out.println();
		System.out.printf("받은 돈 : %,d원\n", money);
		System.out.printf("%s (%d개)\n", tray1[0].toString(), countOfTray(tray1));
		System.out.printf("%s (%d개)\n", tray2[0].toString(), countOfTray(tray2));
		System.out.printf("%s (%d개)\n", tray3[0].toString(), countOfTray(tray3));
		System.out.printf("%s (%d개)\n", tray4[0].toString(), countOfTray(tray4));
		System.out.println();
	}

	// 특정 상품 하나를 반환하는 함수
	public Product getProduct(int select) {
		select -= 1;
		Product product = null;
		for(int i = arr[select].length - 1; i != 0; i--) {
			// 조건1 : 상품이 있어야 한다
			// 조건2 : 상품의 가격이 넣은 돈보다 작거나 같아야 한다
			boolean flag1 = arr[select][i] != null;				
			boolean flag2 = flag1 && arr[select][i].getPrice() <= money;	
			if(flag2) {
				product = arr[select][i];		// 상품을 담고
				arr[select][i] = null;			// 원래 있던 자리는 빈칸이 되고
				money -= product.getPrice();	// 넣은 돈에서 상품 금액만큼 차감한다
				break;
			}
		}
		return product;
	}
	
	// 돈이 충분한지 판별하여 반환하는 함수
	public boolean isEnoughMoney() {
		return getMinimunPrice() <= money;
	}

	// 거스름돈을 반환하는 함수
	public int getChange() {
		int change = this.money;
		this.money = 0;
		return change;
	}

}
