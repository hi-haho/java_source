package pack3;

public interface Ex21Resuume { //이력서 표준 양식
	String SIZE = "A4"; //public final static (인터페이스 안의 멤버변수는 final static 이여야한다.)
	
	void setIrum(String irum);
	void setPhone(String phone);
	void printData();
	
	//인터페이스는 final 변수와 추상메서드로 구성되는 것이 일반적입니다. 하지만 default와 static 키워드를 사용하면 일반 메서드를 쓸 수 있습니다. 
	//자바 1.8 이후에 가능 (원래는 인터페이스 안에 일반 메서드 불가)
	default void display(boolean b) {
		if (b) {
			System.out.println("참");
		}else {
			System.out.println("거짓");
		}
	}
	
	//
	static void play() {
		System.out.println("play 메서드");
	}
	
}
