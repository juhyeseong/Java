package memberProfile;

public class Member {
	private String userId, userPw, name;

	public Member(String userId, String userPw, String name) {
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
	}


	public String getUserId() {
		return userId;
	}
	

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String getUserPw() {
		return userPw;
	}
	

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	
}
