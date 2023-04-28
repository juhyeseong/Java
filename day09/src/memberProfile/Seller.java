package memberProfile;

public class Seller extends Member {
	private String storeName;

	public Seller(String userId, String userPw, String name, String storeName) {
		super(userId, userPw, name);
		this.storeName = storeName;
	}
	
	@Override
	public String toString() {
		return String.format("[판매자정보]\nID : %s\nPW : *****\n이름 : %s\n가게이름 : %s\n", getUserId(), getName(), getStoreName());
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


}
