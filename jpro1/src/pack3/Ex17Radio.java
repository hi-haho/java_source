package pack3;
//부모 메서드가 가진 추상메서드를 정의하라고 강제하는 것임
//The type Ex17Radio must implement the inherited abstract method 
//Ex17Jepum.volumeControl()
public class Ex17Radio extends Ex17Jepum {

	public Ex17Radio() {
		System.out.println("라디오 생성자");
	}
	
	@Override //왼쪽 파란 삼각형 추상메서드
	public void volumeControl() {
		// 부모 추상클래스가 가지는 메서드를 반드시 정의
		System.out.println("라디오 소리 조정");
	}
}
