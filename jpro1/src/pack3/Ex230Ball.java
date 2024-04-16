package pack3;

//인터페이스를 구현하고 모든 추상메서드를 오버라이드하는 지옥에서 벗어날 수 있다.
//추상을 일반 메서드로 만들어 둔 어뎁터 클래스를 상속받아 선택적으로 메서드를 작성
//이미 작성된(주는 클래스)들 때문에 사용하는 것.

//public class Ex230Ball implements Ex23FlyerAdater{ // 부모 추상을 반드시 구현해야한다.
public class Ex230Ball extends Ex23FlyerAdater{
	//하고 싶은 메서드만 오버라이딩 가능
	@Override
	public void fly() {
		System.out.println("공이 관중 속으로 날아간다.");
	}

}
