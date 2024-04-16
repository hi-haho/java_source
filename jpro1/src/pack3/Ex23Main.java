package pack3;

public class Ex23Main {

	public static void main(String[] args) {
		// 어뎁터
		System.out.println("속도 : "+Ex23Flyer.FAST);
		
		Ex23Bird bird = new Ex23Bird();
		bird.fly();
		
		Ex23Airplane airplane = new Ex23Airplane();
		airplane.fly();
		
		System.out.println("~~~~~~~~~~~~");
		Ex23FlyerUtill.show(bird);
		System.out.println();
		Ex23FlyerUtill.show(airplane); //주소를 치환하고 있다.
		
		System.out.println("----------");
		Ex230Ball ball = new Ex230Ball();
		ball.fly();
	}

}
