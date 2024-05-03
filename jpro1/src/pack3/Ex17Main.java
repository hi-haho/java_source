package pack3;

public class Ex17Main {

	public static void main(String[] args) {
		// 추상 클래스 연습
//		Ex17Jepum jepum = new Ex17Jepum();
//		추상 클래스는 인스턴스 불가
		Ex17Jepum jepum = null;
		
		System.out.println();
		Ex17Radio radio = new Ex17Radio();
		jepum = radio;
		jepum.volumeControl();
		
		System.out.println();
		Ex17Tv tv = new Ex17Tv();
		jepum = tv;
		jepum.volumeControl();
		
		//메소드 다형성
		System.out.println();
		polyMet(new Ex17Radio());
		System.out.println();
		polyMet(new Ex17Tv());
		
//		System.out.println();
//		Ex17Jepum jepumArr[] = {radio, tv};
//		for (Ex17Jepum j : jepumArr) {
//			j.volumeControl();
//		}

	}

	public static void polyMet(Ex17Jepum jepum) {
		System.out.println("\n메서드 다형성");
		jepum.volumeControl();
	}
}
