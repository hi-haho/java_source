package lambda;

@FunctionalInterface
interface MyInter { // 함수형 인터페이스
	void aaa();
}

@FunctionalInterface
interface MyInterArg {
	void bbb(int a, int b);
}

@FunctionalInterface
interface MyInterArgReturn {
	int ccc(int a, int b);
}

public class MyLambda2 {

	public static void main(String[] args) {
		// 1. 인자가 없는 추상메서드 처리 : 전통적인 방법
		MyInter inter = new MyInter() {

			@Override
			public void aaa() {
				System.out.println("익명 클래스의 aaa 메소드 오버라이딩");

			}
		};
		inter.aaa();

		// 람다식으로 표현 1
		MyInter inter2 = () -> System.out.println("일명 클래스 aaa 메서드 오버라이딩 : 람다");
		inter2.aaa();

		// 람다식으로 표현 2
		MyInter inter3 = () -> {
			int imsi = 10;
			System.out.println("람다식으로");
			System.out.println("복수의 명령문 처리");
			System.out.println("imsi : " + imsi);
		};
		inter3.aaa();

		System.out.println("====== 인자 O ======");
		// 2. 인자가 있는 추상메서드 처리
		MyInterArg interArg = new MyInterArg() {

			@Override
			public void bbb(int a, int b) {
				System.out.println("두 수의 합은" + (a + b));
			}
		};
		interArg.bbb(3, 4);

		// 람다식으로 표현2 : arg가 1개일 경우 (a) -> 또는 a ->로 적음
		MyInterArg interArg2 = (a, b) -> System.out.println("람다로 두 수의 합은" + (a + b));
		interArg2.bbb(3, 4);

		System.out.println("----------------");
		// 3. 인자가 있고 반환값도 있는 추상메서드 처리
		MyInterArgReturn argReturn = new MyInterArgReturn() {

			@Override
			public int ccc(int a, int b) {
				System.out.println("ccc 처리");
				return a + b;
			}
		};
		int result = argReturn.ccc(5, 6);
		System.out.println("두 수를 더한 결과 : " + result);

		// 람다식으로 표현 3
		MyInterArgReturn argReturn2 = (m, n) -> (m + n);

		MyInterArgReturn argReturn3 = (m, n) -> {
			System.out.println("람다 수행 ");
			return m + n;
		};
		int result2 = argReturn3.ccc(5, 6);
		System.out.println("두 수를 더한 결과2 : " + result2);
		
	}

}
