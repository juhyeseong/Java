package quiz;
import java.util.Scanner;

public class MakeRuler {
	public static void main(String[] args) {
		
		// ㅂ 한자 에서 선택
		String s1 = "┌────┬────┬────┬────┬────┬────┐";
		String s2 = "│││││││││││││││││││││││││││││││";
		
		// ㅁ 한자
		String arrow = "↑";
		
		// 정수를 입력받아서 입력받은 위치를 화살표가 가리키도록 코드를 작성해주세요
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("정수 입력 : ");
		num = Integer.parseInt(sc.nextLine());
		
		System.out.println(s1);
		System.out.println(s2);
		for(int i = 0; i < num; i++) {
			System.out.print(" ");
		}
		System.out.println(arrow);
		
		sc.close();
		
		
	}
}
