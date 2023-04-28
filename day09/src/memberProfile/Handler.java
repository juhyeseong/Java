package memberProfile;

import java.util.ArrayList;

public class Handler {
	ArrayList<Member> arr = new ArrayList<Member>();
	
	public int join(Member member) {
		int row = 0;
		
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getUserId().equals(member.getUserId())) {
				return row;
			}
		}	
		
		row += arr.add(member) ? 1 : 0;
		
		return row;
	}
	
	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = arr;
		
		return list;
	}
	
	public Member selectOne(String userId) {
		Member member = null;
		
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getUserId().equals(userId)) {
				member = arr.get(i);
			}
		}
		
		return member;
	}
	
	public int delete(String userId) {
		boolean flag = arr.removeIf(s -> s.getUserId().equals(userId));
		
		return flag ? 1 : 0;
	}

}
