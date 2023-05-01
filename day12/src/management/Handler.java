package management;

import java.util.ArrayList;

public class Handler {
	// 학생을 저장할 수 있는 구조 (ArrayList<Student>)
	private ArrayList<Student> list = new ArrayList<Student>();
	
	// 학생의 CRUD를 처리하는 기능
	public int insert(Student st) {	// 학생을 전달받아서
		int row = 0;				// 리스트에 추가하고
		row += list.add(st) ? 1 : 0;
		return row;					// 1을 반환
	}
	
	public ArrayList<Student> select() {
		ArrayList<Student> list = this.list;	// 리스트에 모든 학생 정보를 담아서
		return list;							// 반환
	}
	
	public int delete(String name) {	// 학생 이름을 전달받아서
		int row = 0;					// 이름이 일치하는 학생하나를 제거하고
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getName().equals(name)) {
//				row = 1;
//				list.remove(i);
//				break;
//			}
//		}
		// 만약 리스트의 각 학생의 이름이 name과 같다면 지운다
		boolean flag = list.removeIf(st -> st.getName().equals(name));
		return flag ? 1 : 0;						// 1을 반환
	}
}





