package object;

class Kid /*extends Object*/{
	String name;
	int age;
	
	public Kid(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("%s : %s살", name, age);
	}
}

public class Ex04 {
	public static void main(String[] args) {
		Kid ob1 = new Kid("짱구", 5);
		Kid ob2 = new Kid("유리", 6);
		
		System.out.println(ob1);
		System.out.println(ob2);
	}
}
