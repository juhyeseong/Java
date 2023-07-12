package messenger;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Reciever implements Runnable {
	private Scanner server;
	
	public Reciever(Socket so) {
		try {
			server = new Scanner(so.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void run() {
		String msg;
		try {
			while(true) {
				msg = server.nextLine();
				System.out.println(msg);
				if(msg == null) {
					break;
				}
			}
		} catch(NoSuchElementException e) {
			System.out.println("프로그램 종료");
		}
	}
}

