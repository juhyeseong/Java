package messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable {
	private Scanner sc;
	private Socket so;
	private PrintWriter pw;
	private String nick;
	
	public Sender(Scanner sc, Socket so, String nick) {
		try {
			this.sc = sc;
			this.so = so;
			this.nick = nick;
			pw = new PrintWriter(so.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
			String msg;
			pw.println(nick + "님이 접속하셨습니다 ~ ");
			pw.flush();
			while(true) {
				System.out.println("메시지 입력 : ");
				msg = "%s) ";
				msg = String.format(msg, nick);
				msg += sc.nextLine();	
				String sEquals = "%s) exit";
				sEquals = String.format(sEquals, nick);
				if(msg.equals(sEquals)) {
					break;
				}
				pw.println(msg);
				pw.flush();
			}
		try { so.close(); } catch(IOException e) {}
	}
}
