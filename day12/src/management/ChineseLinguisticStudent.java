package management;

public class ChineseLinguisticStudent extends Student {
	private int translation;

	public ChineseLinguisticStudent(String name, int kor, int translation) {
		super(name, kor);
		this.translation = translation;
		setTotal(kor + translation);
		setAvg(getTotal() / 2.0);
	}

	public int getTranslation() {
		return translation;
	}
	public void setTranslation(int translation) {
		this.translation = translation;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s : %.2f", "중어중문", getName(), getAvg());
	}
	
}
