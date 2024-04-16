package pack3;

abstract public class Ex17Jepum {
	//제뭎의 원형 클래스 : 추상클래스
	//추상메서드를 가지고 있으면 추상 클래스가 된다.
	//꼭 추상메서드가 없어도 추상 클래스가 될 수 있다. new할 수 없다.
	public int volume =0;
	
	public Ex17Jepum() {
		System.out.println("추상 클래스 생성자");
	}
	
	abstract public void volumeControl(); //body가 없는 메서드(추상)
	//자식 클래스들에게 추상 메서드는 오버라이딩(정의)하도록 강요하게 된다.
	//스스로 new할 수 없다. (오로지 부모 클래스/ final은 오로지 자식 클래스)
	//여러 추상 메서드를 가질 수 있다.
	
	public void volumeShow() {
		System.out.println("소리 크기 "+ volume);
	}
}
