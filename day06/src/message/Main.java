package message;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Phone p1 = new Phone("010-1234-1234");
		Phone p2 = new Phone("010-2222-2222");
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("메시지를 보낼 대상의 전화번호 입력 : ");
//		String targetNumber = sc.nextLine();
		
		System.out.print("보낼 메시지 입력 : ");
		String content = sc.nextLine();
		
		Message message = new Message(content);
		
		p1.sendMessage(p2, message.content);
		// p1이 p2에게 메시지를 보내면
		// p2에서 메시지를 받을 때, 보낸사람의 번호와 받은 메시지의 내용을 출력해야 합니다.
		System.out.println();
		
		p2.sendMessage(p1, "잘 받았다");
		
		sc.close();
	}
}
