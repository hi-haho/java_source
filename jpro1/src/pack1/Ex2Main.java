package pack1;

public class Ex2Main {

	public static void main(String[] args) {
		//getter, setter 연습
		System.out.println("프로그램을 실행하다가 ~~");
		
		//Ex2Car 객체를 만들기
		System.out.println();
		Ex2Car tom = new Ex2Car();
//		tom.showData();
//		tom.abcd(20);
//		tom.showData();
		System.out.println();
		
		System.out.println("-=-=-=-=-=-=-");

		System.out.println("이름은 "+tom.irum);
		tom.irum = "미스터 톰";
		System.out.println("이름은 "+tom.irum);
		
		System.out.println("\n~~~~getter / setter~~~~");
//		tom.abcd(80);
//		tom.abcd(80,111); //비밀번호를 줄 수 있음
//		tom.abcd(40, 123); //예를 들어 비밀번호에 의해 수정 결정
		tom.setSpeed(80); //speed에만 집중
		tom.showData();

		System.out.println("속도는 "+tom.getSpeed());
		int result = tom.getSpeed();
		System.out.println("속도는 "+ result);
	}

}
