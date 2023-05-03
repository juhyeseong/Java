package collection;

import java.util.ArrayList;
import java.util.Scanner;

class Product implements Comparable<Product> {
	// 상품의 이름, 가격, 별점 3개의 항목으로 필드, 생성자를 구성하세요
	String name;
	Integer price;
	Double rating;
	public Product(String name, Integer price, Double rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	
	// 객체를 출력하면 이름, 가격, 별점이 한줄에 출력되도록 toString()을 오버라이딩 하세요
	@Override
	public String toString() {
		return String.format("%s : %,d (%.1f)", name, price, rating);
	}
	
	// 상품과 다른 상품을 비교하여 정수를 반환하는 함수를 오버라이딩하세요
	@Override
	public int compareTo(Product o) {
		return this.name.compareTo(o.name);
	}
}

public class Quiz1 {
	public static void main(String[] args) {
		// 5개의 샘플 데이터를 작성하세요
		// 5개의 상품을 ArrayList에 담으세요
		// Scanner와 while, switch ~ case 를 이용하여 목록출력하는 코드를 작성합니다
		// 번호에 따라 이름/가격/별점이 각각 오름차순/내림차순으로 정렬하여 출력해야 합니다
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product("에어팟 프로", 249000, 4.5));
		list.add(new Product("갤럭시 S21 울트라", 1299000, 4.8));
		list.add(new Product("아이폰 13 프로 맥스", 1799000, 4.6));
		list.add(new Product("LG 그램 16", 1990000, 4.4));
		list.add(new Product("마이크로소프트 서피스 프로 8", 1599000, 4.7));
		
		Scanner sc = new Scanner(System.in);
		int menu;
		
		LOOP : do {
			System.out.println("1. 이름 오름차순");
			System.out.println("2. 이름 내림차순");
			System.out.println("3. 가격 오름차순");
			System.out.println("4. 가격 내림차순");
			System.out.println("5. 별점 오름차순");
			System.out.println("6. 별점 내림차순");
			System.out.println("0. 종료");
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				// Comparable 에 의한 compare 함수에 의해 정렬
				list.sort(null);	
				break;
			case 2:
				// Comparator 객체의 기준에 따른 정렬
				list.sort((a, b) -> b.name.compareTo(a.name)); 
				break;
			case 3:
				list.sort((a, b) -> a.price.compareTo(b.price));
				break;
			case 4:
				list.sort((a, b) -> b.price > a.price ? 1 : -1);
				break;
			case 5:
				list.sort((a, b) -> a.rating.compareTo(b.rating));
				break;
			case 6:
				list.sort((a, b) -> b.rating > a.rating ? 1 : -1);
				break;		// switch에 대한 break
			case 0:
				break LOOP;	// LOOP (do ~ while) 에 대한 break
			}
			list.forEach(p -> System.out.println(p));
			System.out.println();
			
		} while(menu != 0);
		sc.close();
	
		
	}
}
