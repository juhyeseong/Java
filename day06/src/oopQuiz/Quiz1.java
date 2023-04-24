package oopQuiz;

// 같은 페키지 안에서는 같은 class 이름을 사용할 수 없다
class Student2 {
	// 학생의 이름과
	String name;
	// 국어, 영어, 수학 성적
	int kor, eng, mat;
	
	// 합계점수와 평균점수를 저장하기 위한 필드를 작성합니다
	int sum;
	double avg;
	
	// 이름과 합계, 평균을 출력하는  메서드를 작성합니다
	void show() {
		System.out.printf("이름 : %s, 합계 : %d, 평균 : %.2f\n", name, sum, avg);
	}
	
	// 학생 객체를 생성하기 위한 생성자를 작성합니다
	// 단, 학생 객체는 이름과 세 과목의 점수를 반드시 입력해야만 생성할 수 있으며
	// 합계와 평균은 전달받지 않고, 생성자에게 계산하여 필드의 값을 채워야 합니다
	Student2(String name, int kor, int eng, int mat) {
		// 멤버필드와 지역변수의 이름이 겹칠 때
		// 그냥 쓰면 지역변수(가까운 것부터 참조하기 때문)
		// this.을 붙이면 멤버필드(this는 객체 자신을 가리키기 때문)
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		// 지역변수 안에 멤버필드의 변수와 이름이 겹치는게 없기 때문에
		// this를 빼고 변수 이름을 적어도 멤버필드의 변수이름을 알아서 찾아간다
		sum = kor + eng + mat;	// 멤버필드임을 강조하고 싶다면, this를 붙여도 된다
		avg= sum / 3.0;
	}
}

public class Quiz1 {
	public static void main(String[] args) {
		// 서로 다른 두 학생 객체를 만들어서 성적을 출력하세요
		Student2 st1 = new Student2("홍길동", 87, 74, 98);
		Student2 st2 = new Student2("이지은", 88, 97, 65); 
		
		st1.show();
		st2.show();
	}
}
