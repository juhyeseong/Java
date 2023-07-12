package messenger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Session implements Runnable {
	private PrintWriter pw;
	private Scanner sc;
	private InetAddress inetAddress;
	private FileWriter fw;
	static ArrayList<Session> list = new ArrayList<Session>();
	
	public Session(Socket so) {
		try {
			pw = new PrintWriter(so.getOutputStream());
			sc = new Scanner(so.getInputStream());
			fw = new FileWriter("ServerData.dat", true);
			inetAddress = so.getInetAddress();
			list.add(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Session() {
		this.pw = new PrintWriter(System.out);
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public PrintWriter getPrintWriter() {
		return pw;
	}
	
	@Override
	public void run() {
		String msg;
		while(true) {
			try {
				msg = sc.nextLine();
				for(Session session : Session.list) {
					session.getPrintWriter().println(msg);
					session.getPrintWriter().flush();
				}
				msg += "\n";
				fw.write(msg);
				fw.flush();
				
				if(msg.equals("exit")) {
					break;
				}
			} catch(NoSuchElementException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		try { pw.close(); } catch(Exception e) {}
		try { fw.close(); } catch(Exception e) {}
		list.remove(this);
	}
	
	@Override
	public String toString() {
		return inetAddress.toString() + "세션";
	}
}
