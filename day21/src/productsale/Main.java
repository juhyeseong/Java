package productsale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductSalesDAO dao = new ProductSalesDAO();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		int menu;
		
		while(true) {
			System.out.println("1. 전체 품목별 매출 합계");
			System.out.println("2. 등록 상품별 매출 합계");
			System.out.println("3. 미등록 상품 매출 합계");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				list = dao.allResult();
				
				list.forEach(s -> System.out.println(s));
				break;
			case 2:
				list = dao.registeredResult();
				
				list.forEach(s -> System.out.println(s));
				break;
			case 3:
				list = dao.unRegisteredResult();
				
				list.forEach(s -> System.out.println(s));
				break;
			case 0:
				System.out.println("프로그램을 종료합니다 ~ ");
				
				sc.close();
				
				return;
			default:
				System.out.println("메뉴를 확인하시고 다시 입력해주세요 ~ ");
				break;
			}
		}
	}
}
