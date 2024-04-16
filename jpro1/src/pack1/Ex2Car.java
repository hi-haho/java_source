package pack1;

public class Ex2Car {
	private int speed;
	public String irum;
	private double weight;

	public Ex2Car() {
		irum = "홍길동";
		speed = 10;
	}

	public void showData() {
		System.out.println("이름은 " + irum + ", 속도는 " + speed);
	}
	
//	public void abcd(int s) { // private 멤버값을 외부에서 접근하기 위한 메소드
//		speed = s;
//	}

//	public void abcd(int s, int password) { // private 멤버값을 외부에서 접근하기 위한 메소드
//		if (password == 123) {
//			speed = s;
//		}
//	}
	
	public void setSpeed(int s) { // setter (method) 자동화가 된다./ speed를 세팅할거야! 메소드 
		speed = s; //지역변수에 speed를 찾는데, 없다! java가 멤버변수를 찾아간다.
		//그리고 멤버 변수에 초기화를 시킨다.
		return; //생략 가능
	}
	
	public int getSpeed() { //speed를 다시 돌려 줄거야
		return speed; //setter로 초기화된 멤버변수 speed가 getter을 통해서 main으로 나간다.
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight; //지역변수와 멤버변수를 구분하기위해 this를 사용한다.
		//weight = weight; //가독성을 위해 인수와 멤버변수의 변수명을 똑같이 하는데
		//자바는 이런 경우 지역 변수를 먼저 찾아낸다. 즉, 자기에게 자기가 넣어지는 것.
		//그럼 멤버변수에 할당되는 것이 아니다. 내부(지역)변수와 멤버 필드를 구분하기위해 this를 사용한다.
	}
	
	public static void main(String[] args) {
		
		Ex2Car ex = new Ex2Car();
		
		System.out.println(ex.speed);
	}
	
	

}
