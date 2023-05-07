package socket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		Socket so = new Socket("127.0.0.1", 7777);
		// 소켓 객체는 생성 시, 접속할 대상의 주소와 포트번호를 매개변수에 넣어준다
		// 포트는 0 ~ 65535의 범위를 가진다
		
		// IP주소 : 건물이름
		// 포트번호 : 객실번호
		// 주소와 포트를 지정하면 대상 컴퓨터에서 실행되는 프로세스와 연결하여 데이터를 주고 받는다
		
		// 소켓에서 지정한 대상에게 데이터를 내보내기 위한 스트림을 생성
		OutputStream os = so.getOutputStream();
		// 글자(텍스트)를 보내기 위해서 Writer형식으로 만듦
		OutputStreamWriter osw = new OutputStreamWriter(os);
		// 버퍼 단위로 출력하기 위해서 객체 생성
		BufferedWriter bw = new BufferedWriter(osw);
		
		// 키보드로 입력받기 위한 Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[Client] 연결되었습니다");
		System.out.print("서버에 전송할 메시지 입력 : ");
		String text = sc.nextLine();	// 클라이언트의 키보드로 입력받아서
		bw.write(text);					// 입력받은 대상을 bw에 넣는다
		bw.newLine();					// 한줄 바꾼다
		bw.flush();						// flush해서 버퍼 내용을 밀어서 보낸다
		
		bw.close();	
		sc.close();
		so.close();						// 사용이 끝난 스트림 및 소켓은 반드시 닫아준다
	}
}
