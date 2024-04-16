package pack1;

//method overload : 한개의 클래스의 이름이 같은 메소드를 여러개 선언
//성립조건 : 매개변수의 갯수, 타입, 순서가 다르면 된다. 반환형과는 관계 없다.
public class Ex5AnimalOverload {
	private int leg = 4;
	private int age;
	private String name;
	public final static int MOUTH = 1; // final 멤버 필드는 대문자로 적자

	public Ex5AnimalOverload() { // 생성자에서 초기화를 시키면 한번밖에 못바꾼다.(여러번 바꾸고 싶으면 get/set쓰기)
		// 파라미터가 없는 생성자'만' 사용할 거면 생략가능 >하지만 그냥 적어두면 속 편하다.
		this(10); //생성자가 다른 생성자를 호출하는 것(메서드야,행위인거지)
		System.out.println("nullnull한 생성자");
		
		//메소드명(); //생성자가 메소드를 호출
	}

	public Ex5AnimalOverload(int leg) { // 생성자 오버로딩, 자동차 생산될때 옵션을 추가해줘야해!!
		this.leg = leg;
	}

	public Ex5AnimalOverload(String name) { // 생성자 오버로딩
		this.name = name;
	}

	public Ex5AnimalOverload(String name, int age, int leg) { // 생성자 오버로딩
		this.name = name;
		this.age = age;
		this.leg = leg;
	}

	////////////////////////////////////////
	public void display() {
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}

//	1번 (setter 써도 된다. 근데 자동화가 아닌경우 다른 이름으로 사용 가능)
//	public void print(int age) {
//		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
//	}

	public void display(int age) { // 매개변수(파라미터)의 개수가 다름 > method overload임
		// java가 매개변수 갯수로 알아본다.
		this.age = age; // 지역변수 age를 멤버 필드 age에 복사시킨것
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
		// 이 age는 지역 변수 age이다.
		// this.age에 넣는것/ 안에 age는 매개변수 5일것이다.

	}

	public void display(String name) {
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}

	public void display(String name, int age) {
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}

	public void display(int age, String name) { // 순서가 다르면 다른 메소드
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
//	public void display(int leg) { // 위에 같은 타입, 수가 있기때문에 성립되지 않음
//		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
//	}

//	public String display(String name) { //반환형과는 상관없는 이야기다. 그냥 매개변수 타입, 순서, 개수만 확인
//		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
//	}

}
