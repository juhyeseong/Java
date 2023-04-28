package memberProfile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> list = new ArrayList<Member>();
		Member member = null, selectOne = null;
		Handler handler = new Handler();
		String userId, userPw, name, storeName, address, question;
		int row, type, menu;
		
		System.out.println("\n\t 쇼핑몰 회원관리 프로그램(응시자 : 주혜성)\n");
		
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 전체 목록");
			System.out.println("4. 단일 검색");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				System.out.println("\n\t 회원가입\n");
				System.out.print("회원 유형을 선택하세요 (1. 구매자 | 2. 판매자) : ");
				type = Integer.parseInt(sc.nextLine());
				
				System.out.print("ID를 입력하세요 : ");
				userId = sc.nextLine();
				
				System.out.print("PW를 입력하세요 : ");
				userPw = sc.nextLine();
				
				System.out.print("이름을 입력하세요 : ");
				name = sc.nextLine();
				
				if(type == 1) {
					System.out.print("주소를 입력하세요 : ");
					address = sc.nextLine();
					
					member = new Customer(userId, userPw, name, address);
				}
				else if(type == 2) {
					System.out.print("가게 이름을 입력하세요 : ");
					storeName = sc.nextLine();
					
					member = new Seller(userId, userPw, name, storeName);
				}
				else {
					System.out.println("\n\t회원가입 실패\n");
					break;
				}
				
				row = handler.join(member);
				
				System.out.println(row == 1 ? "\n\t회원가입이 정상적으로 처리되었습니다\n" : "\n\t회원가입 실패\n");
				break;
			case 2:
				System.out.println("\n\t 지정한 계정을 탈퇴합니다\n");
				System.out.println("\n\t ID로 회원을 검색합니다\n");
				System.out.print("검색할 ID를 입력하세요 : ");
				userId = sc.nextLine();
				
				selectOne = handler.selectOne(userId);
				
				if(selectOne == null) {
					System.out.printf("\n\t%s : 회원을 찾을 수 없습니다\n", userId);
				}
				else {
					System.out.println(selectOne);
					
					System.out.print("정말로 삭제하시겠습니까? (y / n) : ");
					question = sc.nextLine();
					
					if(question.equals("y") || question.equals("Y")) {
						row = handler.delete(selectOne.getUserId());
						
						System.out.printf(row == 1 ? "\n\t%s 계정이 탈퇴처리 되었습니다\n\n" : "\n\t탈퇴 실패\n\n", selectOne.getName());
					}
					else if(question.equals("n") || question.equals("N")) {
						System.out.println("\n\t탈퇴를 취소하셨습니다\n");
					}
					else {
						System.out.println("\n\t삭제 여부 선택 실패\n");
					}
				}
				
				break;
			case 3:
				System.out.println("\n\t 전체회원정보\n");
				list = handler.selectAll();
				
				list.forEach(s -> System.out.println(s));
				break;
			case 4:
				System.out.println("\n\t ID로 회원을 검색합니다\n");
				System.out.print("검색할 ID를 입력하세요 : ");
				userId = sc.nextLine();
				
				selectOne = handler.selectOne(userId);
				
				if(selectOne == null) {
					System.out.printf("\n\t%s : 회원을 찾을 수 없습니다\n\n", userId);
				}
				else {
					System.out.println(selectOne);
				}
				break;
			case 0:
				System.out.println("\n\t프로그램을 종료합니다\n");
				
				sc.close();
				
				return;
			default:
				System.out.println("\n\t메뉴를 확인하시고 다시 입력해주세요\n");
				break;
			}
			System.out.println("\n");
		}
	}
}
