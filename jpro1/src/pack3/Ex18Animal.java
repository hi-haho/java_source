package pack3;
//추상 메서드 없어도 추상 클래스 될 수 있어
//부모의 추상 메서드를 모두 오버라이딩하지 않으면 자식 클래스도 abstract가 된다.
abstract public class Ex18Animal {
	abstract public String name(); //추상메서드
	abstract public String eat();
	abstract public String action();
	
	public void animalprint() { //일반 메서드
		System.out.println("동물 추상 클래스의 일반 메서드");
	}
 }
