package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex02_Server {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket so = null;
		Scanner sc = null;
		String msg = null;
		
		try {
			ss = new ServerSocket(7777);
			System.out.println("[Server] 접속 대기중...");
			so = ss.accept();	// Listen
			System.out.println("[Server] " + so.getInetAddress() + "에서 접속함");
			sc = new Scanner(so.getInputStream());
			
			while(true) {
				msg = sc.nextLine();
				System.out.println(msg);
				if("종료".equals(msg)) {
					break;
				}
			} System.out.println("[Server] 상대측에서 종료했습니다");
		} catch (NoSuchElementException e) {
			System.out.println("[Server] 상대측에서 종료했습니다");
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try { if (sc != null) sc.close(); } catch (Exception e) {}
			try { if (so != null) so.close(); } catch (Exception e) {}
			try { if (ss != null) ss.close(); } catch (Exception e) {}
		}
		
	}
}
