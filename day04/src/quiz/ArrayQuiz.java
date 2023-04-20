package quiz;

import java.util.Arrays;

public class ArrayQuiz {
	public static void main(String[] args) {
		// 정수형 배열 arr1을 생성하고 12, 91, 52, 34, 76, 29, 82 를 넣어주세요
		int[] arr1 = { 12, 91, 52, 34, 76, 29, 82 };
		int sum = 0;
		
		// arr1의 홀수번째 index에 들어간 숫자의 합을 구하여 출력하세요
		for(int i = 0; i < arr1.length; i++) {
			if(i % 2 != 0) {
				sum += arr1[i];
			}
		}
		System.out.printf("1) 합 : %d", sum);
		
		System.out.println();
		
		// arr1의 짝수번재 index에 들어간 숫자에 10을 더하세요
		System.out.print("2) ");
		for(int i = 0; i < arr1.length; i++) {
			if(i % 2 == 0) {
				arr1[i] += 10;
			}
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		// arr1과 길이가 같은 정수형 배열 arr2를 새로 생성하세요
		int[] arr2 = new int[arr1.length];
		
		// arr1에 담긴 값들을 역순으로 arr2에 담아주세요
		int j = arr1.length;
		System.out.print("3) ");
		for(int i = 0; i < arr2.length; i++) {
			j--;
			arr2[i] = arr1[j];
			System.out.print(arr2[i] + " ");
		}
		
		System.out.println();
		
		// arr1과 arr2를 각각 한줄에 출력하세요
		System.out.print("arr1 : [");
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]);
			System.out.print(i == arr1.length - 1 ? "]\n" : ", ");
		}
		
		System.out.print("arr2 : ");
		System.out.println(Arrays.toString(arr2));
	}
}
