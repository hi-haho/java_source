package pack3;

public class Ex15PolyTaxi extends Ex15PolyCar{
	private int passenger = 2;
	
	public Ex15PolyTaxi() {
		System.out.println("난 택시라고 해!");
	}
	
	@Override //어노테이션, 메타데이터/컴파일러에게 알려준다.
	public void displaySpeed() {
		System.out.println("택시 승객은 "+passenger+"명");
	}
}
