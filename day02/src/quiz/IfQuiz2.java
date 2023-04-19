package quiz;

import java.util.Random;
import java.util.Scanner;

public class IfQuiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int ea = ran.nextInt(15) + 1;
		int eb = ran.nextInt(15) + 1;
		int ec = ran.nextInt(15) + 1;
		int current, min;
		String eName;
		
		System.out.printf("ea : %d, eb : %d, ec : %d\n", ea, eb, ec);
		
		// 상황 : ea : 1, eb : 8, ec : 3
		// 입력 : 7
		// 출력 : eb 엘리베이터가 이동합니다
		
		System.out.print("현재 층 입력 : ");
		current = Integer.parseInt(sc.nextLine());
		ea = current - ea;
		if(ea < 0) { ea = -ea; }
		eb = current - eb;
		if(eb < 0) { eb = -eb; }
		ec = current - ec;
		if(ec < 0) { ec = -ec; }
		min = ea;
		eName = "ea";
		
		if(min > eb) {
			min = eb;
			eName = "eb";
		}
		if (min > ec) {
			eName = "ec";
		}
		
		System.out.println(eName + "엘리베이터가 이동합니다");
		
		sc.close();
	}
}
