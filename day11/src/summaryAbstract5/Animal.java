package summaryAbstract5;

// 공통 속성과 기능은 슈퍼클래스에

public class Animal {
	private String name;
	
	Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
