package pack1; //성격이 비슷한 파일을 모아둔다.(폴더 > 패키지)

//클래스의 이름과 파일명은 같아야한다.

//접근지정자
// -public : 같은 프로젝트 내에서 유효하다. 패키지가 달라도 된다.
// -protected : 같은 프로젝트 내에서 유효하다. 패키지가 다른 경우, 자식 클래스만 유효
// -default : 같은 패키지 내에서만 유효
// -private : 현재 클래스 내에서만 유효, 다른 클래스에서는 참조 불가

public class Ex1Car { //접근제어자[접근지정자][기타제한자] 클래스 클래스명
	int wheel; //전역 변수 (멤버 필드)/ default 접근 지정자. /초기치로 0을 가지게 된다.
	private int airBag =1; //
	private int speed;  //private는 캡슐화와 연관이 있음
	public String irum;
	
	//
	public Ex1Car() { //클래스와 이름이 같고 반환값이 없다. 
		//public을 따로 적지 않아도 된다. 클래스와 이름이 같고 반환형이 없는 메소드: 생성자(constructer)
		System.out.println("생성자: 객체 생성시 초기화를 담당. 1회 호출됨");
		wheel = 4;
	}
	
	public void abc() {//접근제어자[접근지정자][기타제한자] 반환타입 메소드명(매개변수)
		System.out.println("abc 메소드 수행");
		System.out.println("에어백 수는 "+airBag);
		def();//private 멤버는 현재 클레스 내에서만 사용가능
	}
	private void def() { //같은 클래스 안에서만 보인다. 캡슐화
		System.out.println("def 메소드 수행");
	}
}
//모든 클래스는 멤버 필드, 생성자, 메서드로 구성되어 있다.
//보조 기억장치로 저장되어 있을뿐, 메모리에 할당되진 않았음.