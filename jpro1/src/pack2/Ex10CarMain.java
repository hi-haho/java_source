package pack2;

public class Ex10CarMain {

	public static void main(String[] args) {
		// 클래스의 포함관계 연습 : 여러개의 클래스에서 기능이 필요할때 별도의 클래스로 빼는 방법 중 하나인 포함관계이다.
		Ex10PohamCar tom = new Ex10PohamCar("미스터 톰");
		tom.playCarTurnHandle(30);
		System.out.println(tom.ownerName +"의 회전량은 "+tom.turnMessageShow+" "+tom.handle.quantity);
		//tom현재의 객체변수 안의 관련된 클래스 handle 객체 변수라는거야
		
		tom.playCarTurnHandle(-20);
		System.out.println(tom.ownerName +"의 회전량은 "+tom.turnMessageShow+" "+tom.handle.quantity);
		System.out.println("~~~~~~~~~~");
		Ex10PohamCar james = new Ex10PohamCar("제임스 삼촌");
		james.playCarTurnHandle(0);
		System.out.println(james.ownerName +"의 회전량은 "+james.turnMessageShow+" "+james.handle.quantity);
		
	}

}
