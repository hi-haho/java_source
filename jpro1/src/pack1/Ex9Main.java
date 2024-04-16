package pack1;

public class Ex9Main {
	// 메소드 호출 시 매개변수를 통한 자료 전달(타입이 기본형,참조형)
	public static void main(String[] args) {
		Ex9Callby1 myData = new Ex9Callby1();
		Ex9Callby2 myMethod = new Ex9Callby2(); // 생성자

		System.out.println("원래 a : " + myData.a + ", b: " + myData.b);
		myMethod.ex(myData.a, myData.b); //인수로 기본형을 전달
		System.out.println("1번째 메소드 호출 후 \n원래 a : " + myData.a + ", b: " + myData.b);
		
		System.out.println("\n---------------");
		System.out.println("원래 a : " + myData.a + ", b: " + myData.b);
		myMethod.ex(myData); //myData는 Ex9Callby1의 객체 타입이다. 주소를 가지고 있음(주소 자체를 전달하고있음)
		System.out.println("2번째 메소드 호출 후 \n원래 a : " + myData.a + ", b: " + myData.b);
		
		System.out.println("\n---------------");
		//myData.c[0] 값
		//myData.c[0] 주소
		System.out.println("배열의 대표명 C의 주소: "+ myData.c);
		//////////주소를 복사해서 줬기에 같은 값임을 알려주는 것임///////////
//		int kbs[] = myData.c;
//		System.out.println("배열의 대표명 C: "+ myData.c[0]);
//		System.out.println("배열의 대표명 C: "+ kbs[0]);
		/////////////////////////////////////////////
		myMethod.ex(myData.c); //주소를 준거야
		System.out.println("3번째 배열 수행 후\n myData.c[0] : " + myData.c[0] + ", myData.c[1]: " + myData.c[1]);
		
		
	}

}
