package pack3;

public class Ex19Temporary extends Ex19Employee {
	private int ilsu; //일수
	private int ildang; //일당	
	
	public Ex19Temporary(String irum, int nai, int ilsu, int ildang) {
		super(irum,nai);
		this.ilsu = ilsu;
		this.ildang = ildang;
	} //파라미터가 있는 생성자로 초기화
	
	@Override
	public double pay() {
		return ilsu * ildang;
	}
	@Override
	public void print() {
		display();
		System.out.println(", 월급: "+pay()+"원");
	}
}
