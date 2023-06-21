package makeTV;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 숫자 키패드를 기준으로 메뉴를 구성
		// 2 : 채널 내림
		// 8 : 채널 올림
		// 4 : 볼륨 내림
		// 6 : 볼륨 올림
		// 7 : 전원
		// 9 : 음소거
		// 0 : 프로그램 종료
		
		TV tv = new TV();
		Scanner sc = new Scanner(System.in);
		int menu;
		
		do {
			System.out.print("TV 버튼 입력 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			if(menu == 8) tv.channelUp();
			if(menu == 2) tv.channelDown();
			if(menu == 6) tv.volumeUp();
			if(menu == 4) tv.volumeDown();
			if(menu == 7) tv.onoff();
			if(menu == 9) tv.mute();
			
		} while (menu != 0);
		
		sc.close();
	}
}
