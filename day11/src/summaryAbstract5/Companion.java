package summaryAbstract5;

// 인터페이스의 필드는 static final 이므로
// 모든 객체가 공통으로 사용할 수 있는 불변의 값에 대해서만 사용한다

// 그 외에 객체마다 다른 값을 전달해야 한다면 메서드로 구현해야 한다

public interface Companion {
//	String name = "이정재";
	
	String getName();
}
