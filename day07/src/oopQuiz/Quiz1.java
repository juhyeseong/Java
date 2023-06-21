package oopQuiz;

class Human {
	// 이름을 저장할 필드가 필요하다 (객체마다 다른 값이므로, non-static)
	private String name;
	
	// 생성자에서 이름을 전달받아서 필드에 저장해야 한다
	public Human(String name) {
		this.name = name;
		// 객체를 생성할 때 마다, all의 값을 1 증가시킨다
		all++;
	}
	
	// private 필드 name의 getter를 작성한다
	public String getName() {
		return name;
	}
	
	// 생성된 객체의 개수를 공유할 수 있는 필드가 필요하다 (클래스에 소속시키기 위해 static)
	private static int all = 0;
	
	// static 필드의 getter가 필요하다
	public static int getAll() {
		return all;
	}
}
public class Quiz1 {
	public static void main(String[] args) {
		// 다음 메인함수 코드가 실행될 수 있도록 클래스를 구성하세요
		// 객체가 생성될 때마다, 전체 인원수가 1씩 증가하는 코드
		// 객체 인원수는 직접 대입할 수 없고, getter를 통해서 받아올 수 있도록 구성하세요
		
		System.out.println(Human.getAll()); 	// 전체 Human 객체의 개수가 출력되도록 해주세요 (0)
		Human ob1 = new Human("김용민");
		Human ob2 = new Human("한승록");
		
		System.out.println(Human.getAll()); 	// 전체 Human 객체의 개수가 출력되도록 해주세요 (2)
		
		Human ob3 = new Human("유정현");
		
		System.out.println(Human.getAll()); 	// 전체 Human 객체의 개수가 출력되도록 해주세요 (3)
		
		// ob1, ob2, ob3 에서 전체 인원수에 접근하여 출력해보세요
		System.out.println("ob1.getAll() : " + ob1.getAll());
		System.out.println("ob2.getAll() : " + ob2.getAll());
		System.out.println("ob3.getAll() : " + ob3.getAll());
	}
}
