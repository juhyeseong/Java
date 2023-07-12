package messenger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class Server {
	private static String getLocalServerIp() {
		try	{
		    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)  {
		        NetworkInterface intf = en.nextElement();
		        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)  {
		            InetAddress ia = enumIpAddr.nextElement();
		            if (!ia.isLoopbackAddress() && !ia.isLinkLocalAddress() && ia.isSiteLocalAddress()) {
		            	return ia.getHostAddress();
		            }
		        }
		    }
		}
		catch (SocketException ex) {}
		return null;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String localIp = getLocalServerIp();
		ServerSocket ss;
		Socket so;
		int port = 7777;
		Session session;
		
		try {
			ss = new ServerSocket(port);
			System.out.printf("서버 아이피는 [%s] 입니다\n", localIp);
			
			Session.list.add(new Session());
			
			File f = new File("ServerData.dat");
			
			if(f.exists()) {
				try {
		            // 파일 경로와 이름
		            String filePath = "ServerData.dat";
		            
		            // 파일을 바이트 스트림으로 읽어들임
		            FileInputStream fis = new FileInputStream(filePath);
		            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		            
		            // BufferedReader로 문자열을 읽어들임
		            BufferedReader br = new BufferedReader(isr);
		            String line;
		            while ((line = br.readLine()) != null) {
		                System.out.println(line);
		            }
		            
		            br.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
			
			while(true) {
				System.out.println("접속 대기중...");
				so = ss.accept();
				session = new Session(so);
				Thread th = new Thread(session);
				
				th.start();
				
				System.out.println("현재 접속 인원 : " + Session.list.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
