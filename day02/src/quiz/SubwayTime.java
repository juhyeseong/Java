package quiz;

import java.util.Scanner;

public class SubwayTime {
	public static void main(String[] args) {
		// 지하철 한 구간 당 약 3분의 시간이 소요된다고 가정한다
		// 이동한 지하철 구간 수를 입력받아서
		// 걸린 시간을 출력하세요
		// 단, 시간이 60분을 초과하면, 시간과 분으로 나누어서 출력하고
		// 60분 이하이면, 분으로만 출력하세요
		// 문자열의 형식을 지정하기 위해서, String.format(format,args...)함수를 사용
		
		Scanner sc = new Scanner(System.in);
		int station, hour, min;
		String time;
		
		System.out.print("이동한 지하철 구간 수 입력 : ");
		station = Integer.parseInt(sc.nextLine());
		if(station < 0) {
			station = -station;
		}
		min = station * 3;
		
		if(min > 60) {
			hour = min / 60;
			min %= 60;
			time = String.format("%d시간 %d분", hour, min);
		}
		else {
			time = String.format("%d분", min);
		}
		
		System.out.printf("이동한 구간 수 : %d, 걸린 시간 : %s", station, time);
		
		sc.close();
	}
}
