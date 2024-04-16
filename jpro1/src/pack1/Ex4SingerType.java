package pack1;

public class Ex4SingerType { // 가수들이 가져야할 기본 멤버를 클래스로 작성
	private String name = "무명 가수"; // 이름
	private String title = "아 대한민국"; // 곡 제목

	//생성자를 통해 멤버 변수에 값 저장
	public Ex4SingerType(String name, String title) {
		//생성자를 통해 변수를 넣으면 생성마다 매개변수를 주는게 귀찮아서 게터, 세터를 사용하는건가?
		this.name = name;
		this.title = title;
	}

	// 외부에서 값을 줄거야 setter (프로그램 진행중에 값의 변경은 하지 않을거야!)
	// 외부에 값을 줄거야 getter
	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public void sing() {
		System.out.println(name + " is singing " + title + " ...");
	}
////////////////////////////Ex4SingerType 관련이 없다.////////////////////////////////////
	public static void main(String[] args) {
		// 응용 프로그램 시작용 메소드
		// Ex4SingerType 멤버는 아니다. ()
		//Ex4SingerType bts = new Ex4SingerType();
		Ex4SingerType bts = new Ex4SingerType("BTS","Dynamite");
		bts.sing();
		System.out.println("가수 이름: " +bts.getName());
		System.out.println("가수 곡: " +bts.getTitle());
		
		System.out.println("\n");
		
		Ex4SingerType blackPink = new Ex4SingerType("blackPink","How you like that");
		blackPink.sing();
		System.out.println("가수 이름: " +blackPink.getName());
		System.out.println("가수 곡: " +blackPink.getTitle());
	}
}
