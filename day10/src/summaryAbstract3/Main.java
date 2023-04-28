package summaryAbstract3;

public class Main {
	// 다음 메인함수의 내용이 잘 작동하도록 클래스를 구성하세요
	// give메서드에서 Animal타입의 객체를 전달받았을때
	// 만약 그 객체가 Cat의 인스턴스라면 츄르를 주게 하고,
	// 만약 그 객체가 Dog의 인스턴스라면 육포를 주게 변경하세요
	// (instanceof)
	
	public static void main(String[] args) {
		
		Human man = new Human("원빈");
		Cat cat = new Cat("나옹이");
		Dog dog = new Dog("바둑이");
		
		man.give(cat);	// 원빈이 나옹이에게 먹이를 준다
		man.give(dog);	// 원빈이 바둑이에게 먹이를 준다
	}
}
