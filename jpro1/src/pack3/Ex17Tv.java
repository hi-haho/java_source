package pack3;
//부모 메서드가 가진 추상메서드를 정의하라고 강제하는 것임
//The type Ex17Tv must implement the inherited abstract method 
//Ex17Jepum.volumeControl()
public class Ex17Tv extends Ex17Jepum {

	public Ex17Tv() {
		System.out.println("Tv 생성자");
	}
	
	@Override //왼쪽 파란 삼각형 추상메서드 오버라이딩
	public void volumeControl() {
		// 부모 추상클래스가 가지는 메서드를 반드시 정의 (오버라이딩 강요당함)
		System.out.println("Tv 소리 변경");
	}
	
	@Override //왼쪽 초록 삼각형 일반메서드 오버라이딩
	public void volumeShow() { //오버라이딩 권유
		System.out.println("소리 크기는 적당히 : 부모메서드 대신 새로운 내용으로 대체");
	}
}
