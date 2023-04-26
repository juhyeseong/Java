package makeVendingMachine;

// 하나의 상품을 나타내는 클래스 (단일 품목)

public class Product {

	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return String.format("%s\t: %,d원", name, price);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
