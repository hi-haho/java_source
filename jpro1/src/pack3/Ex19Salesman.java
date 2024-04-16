package pack3;

public class Ex19Salesman extends Ex19Regular{
	
	private int sales; //실적
	private double commission; //수수료율
	
	public Ex19Salesman(String irum, int nai, int salary, int sales, double commission) {
		super(irum, nai, salary);
		this.sales = sales; //지역변수를 멤버변수에 '치환'시킨다.
		this.commission = commission;
	}
	
	public void print() {
		display();
		System.out.println(", 수령액: "+(pay()+(sales*commission))+"원");
	}
	
}
