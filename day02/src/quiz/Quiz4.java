package quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		// 생년월일 6자리를 정수로 입력받아서, 년, 월, 일로 구분하고
		// 현재 연도를 이용하여 나이를 계산하세요
		// 그런 다음, 출생년도는 4자리로 만들어서 연월일과 현재 나이를 추력해주세요
		// 나이가 20이상이면 성인, 아니면 미성년자로 만들어서 함께 출력합니다
		
		// 입력 : 930516
		// 출력 : 1993년 5월 16일 출생, 31세, 성인입니다
		
		// 입력 : 110203
		// 출력 : 2011년 2월 3일 출생, 13세, 미성년자입니다
		
		Scanner sc = new Scanner(System.in);
		int birth, year, mon, day, age;
		
		System.out.print("생년월일 6자리 입력 : ");
		birth = Integer.parseInt(sc.nextLine());
/*		
		year = birth / 10000;
		if(year > 23) {
			year += 1900;
		}
		else {
			year += 2000;
		}
		mon = (birth / 100) % 100;
		day= birth % 100;
		age = 2023 - year + 1;
*/		
		// 숫자를 떼어내는 연산은 뒷자리부터 해주는 것이 좋다
		day = birth % 100;	// 뒤에서 2자리 떼어내서
		birth /= 100;		// 뒤에 2자리는 별도로 저장
		
		mon = birth % 100;
		
		year = birth / 100;
		if(year > 23) {
			year += 1900;
		}
		else {
			year += 2000;
		}
		age = 2023 - year + 1;
		
		System.out.printf("%d년 %d월 %d일 출생, %d세, %s\n", year, mon, day, age, age >= 20 ? "성인입니다" : "미성년자입니다");
		
		sc.close();
	}
}
