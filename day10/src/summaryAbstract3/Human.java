package summaryAbstract3;

public class Human {
	String name;
	
	Human(String name) {
		this.name = name;
	}
	
//	void give(Animal ob) {
//		System.out.printf("%s이 %s에게 먹이를 준다\n", name, ob.name);
//	}
	void give(Animal ob) {
		String feed = "먹이";
		if(ob instanceof Cat) {
			feed = "츄르";
		}
		else if(ob instanceof Dog) {
			feed = "육포";
		}
//		switch(ob.getClass().getSimpleName()) {
//		case "Dog":
//			feed = "육포"; break;
//		case "Cat":
//			feed = "츄르"; break;
//		}
		System.out.printf("%s이 %s에게 %s를 준다\n", name, ob.name, feed);
	}
	
}
