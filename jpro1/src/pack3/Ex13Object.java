package pack3;

public class Ex13Object extends Object{

	
	@Override
	public String toString() {
		// 부모의 본래 기능을 자식이 원하는 명령으로 재정의하는 것
		return "자바여 영원하라";
	}
	
	public static void main(String[] args) {
		// 최상위 수퍼 클래스 Object
		//모든 클래스는 자동으로 Object을 상속받는다. - 자바에서 진리
		Ex13Object obj = new Ex13Object();
		System.out.println(obj);
		System.out.println(obj.toString());
		System.out.println(obj.hashCode());
	}

}
