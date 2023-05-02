package object;

class A /* extends Object */ {
	
}
class B extends A {
	
}

public class Ex01 {
	public static void main(String[] args) {
		// Object 클래스는 자바의 모든 클래스의 최상위 슈퍼 클래스이다
		// 자바의 모든 객체는 Object클래스의 특성을 상속받게 되어 있다
		// 다중 상속은 불가능하므로, 슈퍼클래스가 있다면 Object를 상속받지 않으나
		// 그 슈퍼클래스가 Object를 상속받게 된다
		
		B ob = new B();
		System.out.println(ob.getClass());
		System.out.println(ob.getClass().getSimpleName());
		System.out.println(ob.toString());
		System.out.println(ob.equals(null));
	}
}
