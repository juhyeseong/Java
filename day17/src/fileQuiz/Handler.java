package fileQuiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Handler {

	private ArrayList<PhoneBook> list = new ArrayList<>();
	private File f;
	private static int sequence = 1000;
	
	public Handler() {					// Handler의 객체를 생성하면
		f = new File("phonebook.dat");	// 파일을 지정하고
		if(f.exists()) {				// 만약 파일이 이미 만들어져 있다면 (저장된 내용이 있다면)
			list = load();				// 파일을 불러와서 리스트에 올려둔다
			
			sequence = list.stream().mapToInt(x -> x.getIndex()).max().getAsInt();
		}
	}
	
	@SuppressWarnings("unchecked")	// 경고를 억제한다 (타입이 확인되지 않은 다운캐스팅에 대한 경고)
	private ArrayList<PhoneBook> load() {
		ArrayList<PhoneBook> tmp = new ArrayList<PhoneBook>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			tmp = (ArrayList<PhoneBook>) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			try { ois.close(); } catch(Exception e) {}
		}
		return tmp;
	}

	public void save() {
		// 멤버 필드 list 를 f 파일에 저장하는 내용
		// main에서 프로그램 종료를 실행하면, 저장 후 종료하도록 설정해야 한다
	}
	
	public void insert(PhoneBook ob) {
		ob.setIndex(++sequence);
		list.add(ob);
	}
	public void delete(/*매개변수 타입 자유 (권장값은 int index)*/) {
		
	}
	public ArrayList<PhoneBook> select() {
		return list;
	}
	public void sort() {
		// 리스트를 이름으로 정렬하는 코드
		list.sort(null);
	}
	
}
