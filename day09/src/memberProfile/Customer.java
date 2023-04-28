package memberProfile;

public class Customer extends Member {
	private String address;

	public Customer(String userId, String userPw, String name, String address) {
		super(userId, userPw, name);
		this.address = address;
	}
	
	@Override
	public String toString() {
		return String.format("[구매자정보]\nID : %s\nPW : *****\n이름 : %s\n배송주소 : %s\n", getUserId(), getName(), getAddress());
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
