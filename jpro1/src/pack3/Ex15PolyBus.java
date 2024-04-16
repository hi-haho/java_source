package pack3;

public class Ex15PolyBus extends Ex15PolyCar {

	private int passenger = 10;
	
	public Ex15PolyBus() {
		super();// 파라미터가 없는 부모 생성자를 실행
	}
	public void show() {
		System.out.println("버스");
	}

	@Override //Annotation, 메타데이터 : 컴파일러에게 정보를 알려주는 역할
	public void displaySpeed() {
		System.out.println("버스 승객 수는 "+ passenger);
		System.out.println("버스의 속도는 "+ speed);
	}
}
