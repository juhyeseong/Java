package object;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		// 어떤 객체의 슈퍼클래스를 찾아올라가는 방법
		Scanner sc = new Scanner(System.in);
		
		String scannerClassName = sc.getClass().getName();
		String superName = sc.getClass().getSuperclass().getName();
		
		System.out.println("scanner : " + scannerClassName);
		System.out.println("scanner의 슈퍼클래스 이름 : " + superName);
		
		sc.close();
		
		// 다른 클래스의 슈퍼클래스 정보를 찾아보자
		Integer num = new Integer(150);
		System.out.println();
		System.out.println("Integer");
		System.out.println(num.getClass().getName());
		
		System.out.println("Integer의 슈퍼클래스는 " + num.getClass().getSuperclass().getName());
		
		System.out.println("Integer의 슈퍼의 슈퍼클래스는 " + Integer.class.getSuperclass().getSuperclass().getName());
	}
}

