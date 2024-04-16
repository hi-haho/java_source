package pack1;
//**(저장하면)컴파일하면 bin파일(.class)이 생기는데 보조기억장치에 저장된다.

//멤버 필드와 생성자와 메서드를 가지고 있다.
public class Ex3Programmer {
	public String nickName; // 초기값은 null
	private int age; // 초기값 0
	String spec = "Java";

//	public String motto = "자바에 미쳐 버리자";
	// 기타 제한자
	public static String motto = "자바에 미쳐 버리자"; //멤버 변수
	public final String campName = "에이콘 아카데미"; //final은 상수(리터럴), 수정 불가

	public Ex3Programmer() {// 생성자는 객체를 만들거야(다른 메소드 사용을 줄여)
//		설마 이게 코드의 의존성(결합도)을 줄인다?!
//		이 생성자에 초기화되지 않은 것들은 멤버변수를 그대로 가져다 사용한다.
		System.out.println("난 생성자/ 역할은 객체 생성시 초기화를 담당해");
		System.out.println("초기화 없을 때는 생략 가능해(없어도 되는건 아니야!!!!)");
		age = 22;
//		displayData();
		
		//public String campName = "에이콘 아카데미"; 관련
//		campName ="도토리";
		System.out.println("캠프 이름: "+campName);
		
	}

	public void displayData() {// 늘 항상 지역에서 먼저 찾음 >없으면>멤버 필도로 찾음
		System.out.println("별명이 " + nickName + " : 나이는 " + age + "살, 고유기술은 " + spec);

//		다른 메소드 호출 가능
		System.out.println("보유기술 재 확인: " + showSpec());
	}

	private String showSpec() { // 하나만 return할 수 있다.(여러개를 전달하고 싶으면 배열을 사용해)
		String msg = "프로그래밍 언어: " + spec;
		return msg + "(커피 아님)";
	}

//	private age에 대한 getter/setter를 만들자
	public void setAge(int age) {
		this.age = age;
		// 지역 변수와 멤버 필드와 구분 this
	}

	public int getAge() {
		return age;
	}

	public static void goodMethod() { //static 메소드 /static은 일반 인스턴스를 호출할 수 없다.
		System.out.println("스테틱 메소드임을 널리 아리노라");
		System.out.println(motto);
	}
	
	public void nicemethod() {
		System.out.println(age); //일반 메소드는 일반 멤버 호출 가능
		System.out.println(motto); //일반 메소드는 static 멤버 변수를 부를 수 있음.
		
	}

}
