package pack3;

public class Ex25Person {
	public Ex25Saram getSaram() {
//		return new Ex25Saram(); //객체 생성한거네
		
		return new Ex25Saram()
		{ //내부 무명 클래스(안에 메서드를 가지고 있음)
			public String getIr() { //Ex25Saram 클래스의 메서드를 오버라이딩한것
				return "홍길동";
			}
		};
	}
}
