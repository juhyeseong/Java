package summaryAbstract2;

public class Human {
	String name;
	
	Human(String name) {
		this.name = name;
	}
	
//	void give(Cat cat) {
//		System.out.printf("%s이 %s에게 먹이를 준다\n", name, cat.name);
//	}
//	void give(Dog dog) {
//		System.out.printf("%s이 %s에게 먹이를 준다\n", name, dog.name);
//	}
	void give(Animal ob) {
		System.out.printf("%s이 %s에게 먹이를 준다\n", name, ob.name);
	}
}
