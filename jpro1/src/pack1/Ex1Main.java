package pack1;
//대전제: 클래스 안에 메서드가 존재한다. 메서드만 존재할 수 없다. (즉, 메인 '메서드'이다.)
public class Ex1Main {// 응용 프로그램의 시작, 즉 main을 위한 클래스일 뿐.
//새로운 타입을 만드는 것임!!
	public static void main(String[] args) {
		System.out.println("이러쿵 저러쿵");
		int a =1;
		System.out.println("기본형 변수 a가 기억한 값: "+ a);
		
		System.out.println();
		//자동차 객체를 만들고 싶다.
		Ex1Car car1 = new Ex1Car(); // 만들어지는 과정이 필요하다. --인스턴스화-->인스턴스(객체)
		//타입 변수명 = new 생성자명()
		//Ex1Car : 보조기억장치에 있는 Ex1Car.class를 주기억 장치로 로딩(할당한다?)
		//car1 : 객체 변수 - 객체의 주소를 기억
		//new : 인스턴스화 키워드
		//Ex1car() : 생성자를 호출
		System.out.println("Ex1Car 타입의 생성된 객체 힙에 생성된 car1 주소: \n"+ car1);
		System.out.println("바퀴 수: "+car1.wheel);
		car1.abc(); //private이므로 찾지 못한다.
		
		
		System.out.println("\n==== 객체 하나 더 생성 ====");
		Ex1Car car2 = new Ex1Car(); //인스턴스 2개, 설계도는 똑같지만 3개의 객체가 만들어진 것.
		System.out.println("Ex1Car 타입의 생성된 객체 힙에 생성된 car1 주소: \n"+ car2);
		System.out.println("바퀴 수: "+car2.wheel);
		car2.abc();
		System.out.println();
		System.out.println(car1.getClass()); //객체 변수 타입 확인 
		System.out.println(car2.getClass());
		System.out.println(car1.getClass() == car2.getClass());
		System.out.println(car1 == car2); //주소 비교
		

		
	}

}
