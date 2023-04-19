package quiz;

public class MakeCalendar {
	public static void main(String[] args) {
		// 2023년 3월의 달력을 이중 for문으로 표현하세요
		// 단, 요일은 [일, 월, 화, 수, 목, 금, 토] 의 순서로 출력해야 하고
		// 3월은 1일부터 31일까지 있습니다
		// 범위에 포함되지 않는 칸은 빈칸으로 두어야 합니다
		// 3월 1일은 수요일입니다
		
		System.out.printf("\t%6s\n\n", "3월");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		
		int num = -2;
		
		for(int i = 0; i < 5; i++) {	// 5줄
			for(int j = 0; j < 7; j++) {	// 7칸
				boolean flag = (1 <= num) && (num <= 31); 
				if(flag) {
					System.out.printf("%3d ", num);	// 만약 1 ~ 31 사이라면 출력	
				}
				else {
					System.out.print("    ");	// 아니면 빈칸만 출력
				}
				num += 1;	// 35번동안 num이 1씩 증가한다
			}
			System.out.println();
		}
		
		
	}
}
