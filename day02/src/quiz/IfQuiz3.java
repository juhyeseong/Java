package quiz;

import java.util.Scanner;

public class IfQuiz3 {
	public static void main(String[] args) {
		String id = "itbank";
		String pw = "it";
		
		Scanner sc = new Scanner(System.in);
		
		String userid, userpw, msg = "";
		
		
		// userid와 userpw에 문자열을 입력받아
		// 1) 아이디 불일치
		// 2) 아이디는 일치하지만, 패스워드 불일치
		// 3) 아이디와 패스워드 모두 일치하여 로그인 성공
		
		// 3개의 결과를 화면에 출력할 수 있는 코드를 작성하세요
		
		System.out.print("아이디 입력 : ");
		userid = sc.nextLine();
		System.out.print("패스워드 입력 : ");
		userpw = sc.nextLine();
		
		// a.equals(b)에서 입력이 들어가는 변수는 되도록이면 b자리에 넣어주는 것이 좋다
		// 입력값이 널이 될수도 있기 때문에 널포인터exception이 발생할 수 있음
		if(!id.equals(userid)) {
			msg = "로그인 실패 (아이디를 찾을 수 없습니다)";
		}
		if(id.equals(userid) && !pw.equals(userpw)) {
			msg = "로그인 실패 (패스워드가 틀렸습니다)";
		}
		if(id.equals(userid) && pw.equals(userpw)) {
			msg = "로그인 성공";
		}
		
		System.out.println(msg);
		
		sc.close();
	}
}
