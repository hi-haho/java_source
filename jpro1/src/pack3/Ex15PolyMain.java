package pack3;

public class Ex15PolyMain {

	public static void main(String[] args) {
		Ex15PolyCar car1 = new Ex15PolyCar();
		Ex15PolyBus bus1 = new Ex15PolyBus();
		Ex15PolyTaxi taxi1 = new Ex15PolyTaxi();
		
		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());
		
		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());
		
		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());
		
		System.out.println("\n--객체 주소 치환--");
		Ex15PolyCar car2 = new Ex15PolyBus(); //생성자의 주소를 car2로 넘긴거란 말이지? //왜인지 알겠다.(너는 자동형변환이 된거야)
//		두개의 타입을 다가지고 있음,
//		System.out.println(car2 instanceof Ex15PolyCar); //true
//		System.out.println(car2 instanceof Ex15PolyBus); //true
		car2.displaySpeed(); //***오버라이딩 된 메소드는 호출 가능
		System.out.println(car2.getSpeed());
//		car2.show(); //The method show() is undefined for the type Ex15PolyCar
//		**불간섭의 원칙: 오버라이딩 된 것만 사용할 수 있다.**
//		자식 고유의 것이기떄문에 부모가 간섭할 수 없다. 자바 마음에 들어어~!
		System.out.println("\n\n====car3 < taxi1====");
		Ex15PolyCar car3 = taxi1; //promotion
		System.out.println("주소 확인: "+car3+" ~~ "+ taxi1);
		System.out.println(car3.getSpeed());
		
		
		System.out.println("\n===========");
//		Ex15PolyBus bus2 = new Ex15PolyCar(); //Type mismatch: cannot convert from Ex15PolyCar to Ex15PolyBus
		Ex15PolyBus bus3 = (Ex15PolyBus)car2;
//		car2는 Ex15PolyCar(부모 클래스)의 타입과 더 가깝다.
//		완전한 부모타입은 아니긴해(왜냐면 자식클래스의 주소를 가지고 있기때문이지.)
//		자식클래스는 작은 그릇이잖아? 그니깐 casting을 하면되는거지.
		
		//왜 명시적으로 써야하느냐? 큰거에서 작은 곳으로 옮기면 분명 데이터의 손실이 생길 수가 있겠지?
		// 그러니 책임져라! 이런거지
		
//		자바 장점 : 예의가 바름! 인간관계같다
		bus3.show();
		
		System.out.println();
//		Ex15PolyTaxi taxi2 = new Ex15PolyCar(); //
		Ex15PolyTaxi taxi2 = (Ex15PolyTaxi)car3; // casting 성립(taxi의 피가 흐르고 있긴 함 그래서 캐스팅 가능)
		taxi2.displaySpeed();
		
//		Ex15PolyTaxi taxi3 = (Ex15PolyTaxi)car1;
		// 컴파일(문법) 오류는 아니야. 런타임에러야!
		// java.lang.ClassCastException
		// car1은 taxi의 피가 전혀 흐르지 않음
		System.out.println("^^^^^^^^^^^^");
		Ex15PolyCar myCar;
		myCar = bus1;
		myCar.displaySpeed();
		
		myCar = taxi1;
		myCar.displaySpeed();
		
		System.out.println();
		Ex15PolyCar p[] = new Ex15PolyCar[3]; //배열
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		
		for (Ex15PolyCar poly : p) {
			poly.displaySpeed();
		}
		
		
	}

}
