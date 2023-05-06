package fileQuiz;

public class PhoneBook {	// 직렬화 가능하도록
	// 이름과 전화번호를 멤버필드
	// 필드를 전달받는 생성자
	// getter/setter
	// toString()
	
	private int index;
	private String name;
	private String pnum;

	public PhoneBook(int index, String name, String pnum) {
		this.index = index;
		this.name = name;
		this.pnum = pnum;
	}
	
	@Override
	public String toString() {
		return String.format("%d) %s : %s", index, name, pnum); 
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
}
