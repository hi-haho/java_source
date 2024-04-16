package pack3;
//Adater란 이름이 붙은 클래스(보통)는 인터페이스를 구현해 추상을 일반 메서드로 작성한다.
//그리고 자신은 추상클래스가 된다.
abstract public class Ex23FlyerAdater implements Ex23Flyer{
	//일반 메서드이기때문에 자식은 꼭 오버라이드를 하지 않아도된다.
	@Override
	public void fly() {}
	
	@Override
	public boolean isAnimal() {return false;}
	
	@Override
	public void happy() {}
	
}
