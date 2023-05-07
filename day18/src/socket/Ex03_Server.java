package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class MySession implements Runnable {
	private Scanner sc;
	private Socket so;
	
	public MySession(Socket so) throws IOException {
		this.so = so;
		sc = new Scanner(so.getInputStream());
	}

	@Override
	public void run() {		// 접속한 클라이언트가 보낸 메시지를 내 컴퓨터에 출력하기
		String msg = "";
		
		while(true) {

			msg = sc.nextLine();		// 클라이언트가 보낸 메시지를 읽어서
			
			if("exit".equals(msg)) {
				break;
			}
			
			System.out.println(msg);	// 내 화면(서버)에 출력하기
		}
		sc.close();
		try { so.close(); } catch (Exception e) {}
	}
}

public class Ex03_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;
		PrintWriter pw = null;
		Socket so = null;
		Scanner sc = new Scanner(System.in);
		String msg;
		
		ss = new ServerSocket(7777);
		System.out.println("접속 대기중...");
		so = ss.accept();
		pw = new PrintWriter(so.getOutputStream());
		
		MySession session = new MySession(so);
		Thread th = new Thread(session);
		th.start();
		
		// 내가 입력한 메시지를 클라이언트에게 보내는 코드
		while(true) {
			System.out.print("보낼 메시지 입력 : ");
			msg = sc.nextLine();		// 내가 키보드로 입력한 내용을
			pw.println(msg);			// pw는 so와 연결되어 있어서
			pw.flush();					// 접속된 클라이언트에게 보내는 코드다
			
			if("exit".equals(msg)) {
				break;
			}
		}
		
		sc.close();
		pw.close();
		so.close();
		ss.close();
	}
}
