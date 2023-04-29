package summaryAbstract4;

public class Main {
	// 다음 메인함수의 내용이 잘 작동하도록 클래스를 구성하세요
	// Human을 상속받는 클래스 Friend 를 작성하세요
	// Animal을 전달받는 give와 Human을 전달받는 give로 오버로딩하세요
	
	public static void main(String[] args) {
		
		Human man = new Human("원빈");
		Cat cat = new Cat("나옹이");
		Dog dog = new Dog("바둑이");
		Friend f = new Friend("이정재");
		
		man.give(cat);	// 원빈이 나옹이에게 츄르를 준다
		man.give(dog);	// 원빈이 바둑이에게 육포를 준다
		man.give(f); 	// 원빈이 이정재에게 치즈를 준다
	}
}
