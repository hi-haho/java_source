package pack3;

//상속 : 하나의 클래스가 다른 클래스를 포함하는 상위 개념일 때 두 클래스 사이ㅇ
//   일반화 관계가 있다. 이런 일반화 관계를 상속관계(is a kind of)라고 한다.
//   클래스 간 부모 자식의 구조를 갖는다
//부모 클래스는 자식 클래스의 멤버(필드,메서드)를 제공하는 틀 역할을 한다.
//상속을 왜할까요? 다형성때문에!

public class Ex12GrandFa {
	private int nai=80;
	public String gabo = "상감청자";
	protected String gahun = "자바 모르면 인간도 아니다"; //protected를 사용했다? 예측) 자식이 있을 수도? (물론 없을 수도)
	
	public Ex12GrandFa() {
		System.out.println("할아버지 생성자");
	}
	public Ex12GrandFa(int nai) {
		this();
		this.nai = nai;
	}
	public String say() {
		return "할아버지 말씀: 자기주도학습! ";
	}
	public void eat() {
		System.out.println("밥은 맛있게 ...");
	}
	public int getNai() {
		return nai;
	}
	
}

//final(클래스)
//상속 불가함