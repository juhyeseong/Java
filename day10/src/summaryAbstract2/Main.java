package summaryAbstract2;

public class Main {
	// 다음 메인함수의 내용이 잘 작동하도록 클래스를 구성하세요
	// Cat과 Dog의 공통속성을 묶어서 처리할 슈퍼클래스 Animal을 작성하세요
	// 필요하다면, 생성자를 수정하여 상속관계에 맞게 작동하도록 수정하세요
	// Human에서는 나누어져있는 give메서드를 하나로 통일하세요
	public static void main(String[] args) {
		
		Human man = new Human("원빈");
		Cat cat = new Cat("나옹이");
		Dog dog = new Dog("바둑이");
		
		man.give(cat);	// 원빈이 나옹이에게 먹이를 준다
		man.give(dog);	// 원빈이 바둑이에게 먹이를 준다
	}
}
