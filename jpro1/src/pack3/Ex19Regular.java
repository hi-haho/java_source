package pack3;

public class Ex19Regular extends Ex19Employee{
	private int salary;
	
	public Ex19Regular(String irum, int nai, int salary) {//생성자
		super(irum,nai); //이름과 나이 변수를 들고 현재 클래스에 부모 클래스의 생성자를 호출합니다.
		this.salary = salary;//지역변수 salary을 전역변수 salary에게 치환합니다.
	}
	
	@Override
	public double pay() {
		return salary;
	}
	@Override
	public void print() {
		display();
		System.out.println(", 급여: "+pay()+"원");
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
