package summaryAbstract5;

public class Main {
	// 다음 메인함수의 내용이 잘 작동하도록 클래스를 구성하세요
	// Human.give 메서드를 하나로 통합합니다
	// 서로 다른 클래스를 하나의 타입으로 처리하기 위해
	// 인터페이스 Companion 을 만들어서 처리합니다 (Cat, Dog, Friend)
	
	public static void main(String[] args) {
		
		Human man = new Human("원빈");
		Cat cat = new Cat("나옹이");
		Dog dog = new Dog("바둑이");
		Friend f = new Friend("이정재");
		
		man.give(cat);	// 원빈이 나옹이에게 츄르를 (던져)준다
		man.give(dog);	// 원빈이 바둑이에게 육포를 (던져)준다
		man.give(f); 	// 원빈이 이정재에게 치즈를 (건네)준다
	}
}
