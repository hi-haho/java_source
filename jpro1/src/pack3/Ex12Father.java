package pack3;

public class Ex12Father extends Ex12GrandFa { //extends 상속(단일 상속만 가능하다)
//	Ex12GrandFa fa = new Ex12GrandFa(); //포함관계 : 메모리에 생성자 하나 만들어주는것 //약결합
	
	public String gabo = "꽃병"; // 은닉화? 할아버지의 gabo가 숨겨진다.
	private int nai = 55;
	private int house = 1;
	
	public Ex12Father() {
//		super(); //매개변수가 없는 부모 생성자 호출 , 생략이 가능하다.즉, 없으면 부모의 기본 생성자를 (무조건)출력함.
		System.out.println("아버지 생성자");
	}
	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	
	@Override //어노테이션(메소드임/생략가능(옵션))- 정확한 기능을 할 수 있도록 도와주는 것(체크해주는 것)
	public int getNai() {  //메소드 오버라이딩 (부모의 것이 마음에 들지 않아 재정의하는 것)
		return nai;
	}

	public String say() {
		return "아버지 말씀: 에러잡는 연습을 하거라 ";
	}
	
	 final public String getHouse() {
		return "집: "+house+"채";
	}
	public void showData() {
		
		System.out.println("아버지 나이 "+nai); //지역에서 찾고나서 없으면 멤버변수를 찾을 것
		System.out.println("아버지 나이 "+this.nai); //처음부터 멤버변수를 찾아가는것
		System.out.println("아버지 나이 "+getNai()); //현제 메서드가 없으니 부모한테
		System.out.println("아버지 나이 "+this.getNai()); //자신의 멤버변수까지 없으면 부모클래스로 가서 찾음
		System.out.println();

//		System.out.println("아버지 나이"+super.nai());// private 변수라서 못불러온다.
		System.out.println("할아버지 나이"+super.getNai());//바로 부모에게 간다.
		
		System.out.println("~~~~~~~~~~~~~~~~~");
		String gabo = "물병";
		System.out.println("가보1: "+gabo); //찾는 순서 : 지역 >멤버 > 부모
		System.out.println("가보2: "+this.gabo); //찾는 순서 : 멤버 > 부모
		System.out.println("가보3: "+super.gabo);//찾는 순서 : 부모
	}
	
	
}

//메소드에 final이면 자식 클래스에서 overriding 불가
