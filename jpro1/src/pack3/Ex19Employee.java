package pack3;

abstract public class Ex19Employee {
	private String irum;
	private int nai;
	
	public Ex19Employee(String irum, int nai) { //생성자
		this.irum = irum;
		this.nai = nai;
	}
	
	
	abstract public double pay(); // 추상
	abstract public void print(); // 추상
	
	public void display() {
		System.out.print("이름: "+irum+" , 나이: "+nai);
	}
	
}
