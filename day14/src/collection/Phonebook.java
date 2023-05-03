package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
	// 클래스 대신 HashMap 을 이용하여 개별 데이터를 저장하고
	// 여러 HashMap 을 list에 저장하여 관리하는 프로그램
	// 필요한 기능은 추가/전체목록/삭제
	
	static ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu, result;
		String name, pnum;
		
		LOOP : while(true) {
			System.out.println("1. 추가");
			System.out.println("2. 목록");
			System.out.println("3. 삭제");
			System.out.println("0. 종료");
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				System.out.print("이름 입력 : ");
				name = sc.nextLine();
				
				System.out.print("전화번호 입력 : ");
				pnum = sc.nextLine();
				
				// name과 pnum을 이용하여 데이터를 생성하고, 생성된 데이터를 리스트에 추가한다
				result = add(makeData(name, pnum));
				System.out.println(result == 1 ? "추가 성공" : "추가 실패");
				break;
				
			case 2:
				list.forEach(o -> System.out.println(toString(o)));
				break;
				
			case 3:
				System.out.print("삭제할 정보의 이름 입력 : ");
				name = sc.nextLine();
				
				result = delete(name);
				System.out.println(result == 1 ? "삭제 성공" : "삭제 실패");
				break;
				
			case 1234:
				add(makeData("이지은", "010-1234-1234"));
				add(makeData("홍진호", "010-2222-2222"));
				add(makeData("남도일", "010-4444-4444"));
				break;
				
			case 0:
				break LOOP;
			}
		}
		sc.close();
	}
	
	static int add(HashMap<String, String> data) {	// 리스트에 추가
		boolean flag = list.add(data);
		return flag ? 1 : 0;
	}
	static HashMap<String, String> makeData(String name, String pnum) { // 생성자 역할
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("pnum", pnum);
		return data;
	}
	static int delete(String name) {	// 이름이 같은 데이터를 리스트에서 삭제
		boolean flag = list.removeIf(o -> o.get("name").equals(name));
		return flag ? 1 : 0;
	}
	static String toString(HashMap<String, String> data) {	// 객체.toString() 대신
		return String.format("%s : %s", data.get("name"), data.get("pnum"));
	}
	
	// main함수에서 곧바로 list가 참조가능하기 때문에 전체 목록은 별도의 함수로 구현하지 않음
	
	
	
	
	
	
	
	
}
