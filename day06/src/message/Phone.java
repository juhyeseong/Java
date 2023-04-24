package message;

public class Phone {
	String pnum;
	Message content;
	
	Phone(String pnum) {
		this.pnum = pnum;
	}
	
	// 보내는 사람의 입장에서 서술한 메서드
	// target은 메시지를 받을 사람, content는 메시지의 내용
	void sendMessage(Phone target, String content) {
		target.recieveMessage(this, content);
	}
	
	// 받는 사람의 입장에서 서술한 메서드
	// sender는 나에게 메시지를 보낸 사람
	// content는 메시지의 내용
	void recieveMessage(Phone sender, String content) {
		System.out.printf("[%s 의 화면]\n", this.pnum);
		System.out.printf("%s : %s\n", sender.pnum , content);
	}
}
