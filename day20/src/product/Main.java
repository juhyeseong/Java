package product;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// ctrl + shift + f : 코드 줄 자동 정렬

// 전체목록	(고유번호 순으로 출력이 기본값, 정렬되면 다른 순서로 출력)
// 검색		(이름으로 검색, 포함된다면 모두 출력)
// 추가		(상품등록)
// 삭제		(등록된 상품 코드 제거)
// 수정		(상품수량 및 가격 수정)
// 정렬		(날짜순 정렬, 고유번호 순 정렬, 수량 기준 정렬)
// 종료

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProductDAO dao = new ProductDAO();
		ProductDTO tmp = null;
		ArrayList<ProductDTO> list;
		int menu, row, idx;
		String keyword, key, value;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("상품번호", "idx");
		map.put("상품이름", "name");
		map.put("상품가격", "price");
		map.put("유통기한", "expiryDate");
		map.put("상품설명", "memo");
		String order = map.get("상품번호");
		boolean desc = false;

		while (true) {
			System.out.println("1. 전체 목록");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 정렬");
			System.out.println("0. 종료");
			System.out.print("선택 >>>> ");

			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {

			case 1: // 전체 목록
				list = dao.selectAll(order, desc);	// 정렬 부분 때문에 order, desc 인자 받아야함
				list.forEach(dto -> System.out.println(dto));
				break;

			case 2: // 검색
				System.out.print("검색어를 입력하세요 : ");
				keyword = sc.nextLine();

				// select * from product where name like '%keyword%'
				list = dao.select(keyword);
				list.forEach(dto -> System.out.println(dto));

				break;

			case 3: // 상품 추가
//				dao.insert(idx, name, price, expiryDate, memo);
				System.out.println("신규 상품을 생성합니다");
				tmp = useBean(sc); // tmp = ProductDTO
				row = dao.insert(tmp);
				System.out.println(row != 0 ? "추가 성공" : "추가 실패");
				break;

			// 상품을 추가 성공하고 종료를 해도, 데이터베이스에서 저장되는것을 확인 할 수 있다.
			case 4: // 수정
				System.out.println("기존 상품을 수정합니다");
				tmp = useBean(sc);
				row = dao.update(tmp);
				System.out.println(row != 0 ? "수정 성공" : "수정 실패");
				break;

			case 5: // 삭제
				System.out.print("삭제할 상품번호 입력 : ");
				idx = Integer.parseInt(sc.nextLine());

				row = dao.delete(idx);
				System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");

				break;

			case 6: // 정렬
				System.out.println(new ArrayList<>(map.keySet()));
				System.out.print("정렬 기준 선택 : ");
				key = sc.nextLine();
				value = map.get(key);
				if(value != null) {
					order = value;
				}
				System.out.print("내림차순? ");
				desc = Boolean.parseBoolean(sc.nextLine());

				break;
			case 0:
				sc.close();
				return;
			}
		} // end of while

	} // end of main

	// 추가에서도 활용하고, 수정에서도 활용한다 (코드의 재활용, 함수)
	static ProductDTO useBean(Scanner sc) {
		ProductDTO dto = new ProductDTO();

		System.out.print("상품 번호 : ");
		dto.setIdx(Integer.parseInt(sc.nextLine()));

		System.out.print("상품 이름 : ");
		dto.setName(sc.nextLine());

		System.out.print("상품 가격 : ");
		dto.setPrice(Integer.parseInt(sc.nextLine()));

		try {
			// HTML에서는 <input type="date" value="2023-04-11">
			System.out.print("유통기한 (yyyy-MM-dd) : ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String inputDate = sc.nextLine(); // 문자열로 입력받는다
			java.util.Date date = sdf.parse(inputDate); // 문자열에서 서식에 맞는 java.util.Date로 변환
			dto.setExpiryDate(new Date(date.getTime())); // java.util.Date의 long을 추출하여 sql.Date로 변환

		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.print("상품 설명 : ");
		dto.setMemo(sc.nextLine());

		return dto;
	}
}
