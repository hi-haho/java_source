package pack3;

public class Ex12Me extends Ex12Father {
	final int score = 90;
	
	public Ex12Me() {
//		super();
		System.out.println("내 생성자");
//		score= 80; //에러 The final field Ex12Me.score cannot be assigned
		//멤버 필드에 final하면 값 수정 불가
	}
	
	public void biking() {
		System.out.println("자전거로 전국일주~~");
	}
	
//	public String getHouse() { //부모에서 final해서 오버라이딩 불가
//		return "집:";
//		Multiple markers at this line
//		- overrides pack3.Ex12Father.getHouse
//		- Cannot override the final method from Ex12Father
//	}
}
