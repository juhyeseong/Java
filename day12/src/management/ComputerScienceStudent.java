package management;

public class ComputerScienceStudent extends Student {
	private int algorithm;
	private int dataStruct;

	public ComputerScienceStudent(String name, int kor, int algorithm, int dataStruct) {
		super(name, kor);
		this.algorithm = algorithm;
		this.dataStruct = dataStruct;
//		total = kor + eng + mat;
		setTotal(kor + algorithm + dataStruct);
		setAvg(getTotal() / 3.0);
	}

	public int getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}
	public int getDataStruct() {
		return dataStruct;
	}
	public void setDataStruct(int dataStruct) {
		this.dataStruct = dataStruct;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s : %.2f", "컴퓨터공학", getName(), getAvg());
	}
	
}
