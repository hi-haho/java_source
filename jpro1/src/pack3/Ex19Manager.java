package pack3;

public class Ex19Manager extends Ex19Regular {

	private double incentive; // 관리수당

	public Ex19Manager(String irum, int nai, int salary) {
		super(irum, nai, salary);
		if (salary >= 250) {
			incentive = salary *0.6;
		}else if(250 > salary && salary >= 200) {
			incentive = salary *0.5;
		}else {
			incentive = salary *0.4;
		}
	}

	@Override
	public void print() {
		display();
		System.out.println("수령액: "+(pay()+incentive)+"원");
	}

}
