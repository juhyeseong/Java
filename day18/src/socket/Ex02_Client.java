package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket so = null;
		PrintWriter pw = null;
		String msg;
		
		try {
			so = new Socket("192.168.153.1", 7777);
			pw = new PrintWriter(so.getOutputStream());
	
			while(true) {
				System.out.print("서버에게 보낼 메시지 입력 : ");
				msg = sc.nextLine();
				pw.println("[Client] " + msg);
				pw.flush();
				
				if("종료".equals(msg)) {
					break;
				}
			}
			System.out.println("종료하셨습니다");
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try { if(sc != null) sc.close(); } catch(Exception e) {}
			try { if(so != null) so.close(); } catch(Exception e) {} }
	}
}
