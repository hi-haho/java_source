package pack;

public class Test3 {
	public static void main(String[] args) {
		// 관계, 논리 연산자
		int a = 5;

		System.out.println("==관계연산자==");
		System.out.println(a > 3);
		boolean bo = a > 3;
		System.out.println(bo);
		System.out.println(a >= 3);
		System.out.println(a <= 3);
		System.out.println(a == 3);
		System.out.println(a != 3);

		System.out.println("===논리 연산자===");
		int b = 10;
		System.out.println(a > 3);
		System.out.println(b > 3);
		System.out.println(a > 3 && b > 3); // and
		System.out.println(a > 3 && b <= 3); // 둘 다 참일 경우 참

		System.out.println(a > 3 || b > 3); // or
		System.out.println(a > 3 && b <= 3); // 하나만 참일경우 참

		System.out.println(a < 3 || b <= 1 + 1 * 1);
		boolean bb = a < 3 || b <= 1 + 1 * 1;
		System.out.println(bb);
//		연산자 우선순위 : ()소괄호 > 산술 (*,/ > +,-) > 관계 > 논리 > 치환
		System.out.println("\n====shift 연산 =====");

		int ii = 8, ij = 0;
		// int ii = 8, ij;
		System.out.println("ii: " + Integer.toBinaryString(ii));
		ij = ii << 1; // << 좌측으로 1bit 이동, 남는 가장 우측은 0으로 채움
		ij = ii >> 2; // >> 우측으로 1bit 이동
		System.out.println("ii: " + ii + "  ij: " + ij);
//		The local variable ij may not have been initialized
//		지역 변수 ij 초기화 필요

		int sbs = 3;
		int mbc = (sbs > 5) ? 100 : 10 + 20 * 2;
		System.out.println(mbc);

		System.out.println();
		int x, y, z;
		x = y = z = 5;
		System.out.println(x + " " + y + " " + z);

		System.out.println("= 논리 연산자 주의할 점 =");

		/*
		 * aa();
		 * 
		 * System.out.println(aa());
		 * 
		 * boolean imsi = aa(); System.out.println(imsi);
		 */
//		boolean a1 = false, b1 = true, c1;
		boolean a1 = true, b1 = false, c1;
		c1 = a1 || b1; // or
		System.out.println(c1);
		c1 = a1 && b1; // and
		System.out.println(c1);
		
		System.out.println();
		boolean b2, b3;
		b1 = aa();
		System.out.println(b1);
		System.out.println(bb());
		System.out.println("~~~~~~~");
//		b2 = aa() || bb(); //예상 true
		//||(or 연산) aa()가 참이기에 bb()를 실행하지 않는다.

//		b2 = bb() || aa();
//		bb()가 false이기에 aa() 처리가 된다.
		
		b2 = aa() | bb(); // or 연산이지만 모든 메소드를 수행함.
		System.out.println(b2);
		
		System.out.println();
		b3 = aa() && bb(); //모두 참이기에 bb()를 실행함
		b3 = bb() && aa(); //bb()가 false이기에 aa()실행안함
		b3 = aa() & bb(); //모두 실행함
		System.out.println(b3);
		
		System.out.println("프로그램 종료");

	}

	public static boolean aa() { // 클래스 안에 있으면 메소드
		System.out.println("aa 출력");
		return true;
	}
	
	public static boolean bb() { // 클래스 안에 있으면 메소드
		System.out.println("bb 출력");
		return false;
	}
}
