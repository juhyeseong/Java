package object;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 {
	static int getDistanceFromObject(Class clazz) {
		int count = 0;
		while(true) {
			System.out.println(clazz.getName());
			if(clazz.equals(Object.class)) {
				break;
			}
			clazz = clazz.getSuperclass();
			count++;
		}
		System.out.println();
		return count;
	}
	
	public static void main(String[] args) {
		int t1 = getDistanceFromObject(Scanner.class);
		int t2 = getDistanceFromObject(Integer.class);
		int t3 = getDistanceFromObject(Number.class);
		int t4 = getDistanceFromObject(ArrayList.class);
		
		System.out.println("Scanner는 Object와의 거리가 " + t1);
		System.out.println("Integer는 Object와의 거리가 " + t2);
		System.out.println("Number는 Object와의 거리가 " + t3);
		System.out.println("ArrayList는 Object와의 거리가 " + t4);
	}
}
