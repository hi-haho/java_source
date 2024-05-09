package lambda;
// lambda Expression : 이름이 없는 익명 함수(메서드)

// 람다 표현식은 함수형 인터페이스의 구현으로만 가용할 수 있다.
// 1개의 추상메서드를 가져야 하며 람다 표현식은 해당 메서드의 구현으로 동작한다.


//가독성을 위해 어노테이션 가능
@FunctionalInterface
//Invalid '@FunctionalInterface' annotation; HelloInter is not a functional interface > 추상메서드가 2개인 경우
interface HelloInter {// lambda Expression을 사용할 인터페이스 (즉, 추상메서드는 1개여야한다._java에서만)
	//함수형 인터페이스라고 부른다.
	int calcData(int a, int b);

//	int calcData2(int a, int b);
}

public class MyLambda1 implements HelloInter {

//	public MyLambda1() {
//		
//	}

	@Override
	public int calcData(int a, int b) {
		// 인터페이스의 추상 메서드를 오버라이딩 : 전통적인 방법
		return a + b;
	}

//	@Override
//	public int calcData2(int a, int b) {
//		return 0;
//	}

	public static void main(String[] args) {
		MyLambda1 my = new MyLambda1();
		System.out.println(my.calcData(3, 4)); // 전통적인 방법

		System.out.println();
		// 인터페이스 변수 = 람다식
		// 람다 표현식의 일반적인 구문 : (parameter ,,,) -> { body }
		HelloInter inter = (x, y) -> x + y;
		//추상메서드가 1개이상인 경우, The target type of this expression must be a functional interface
		System.out.println(inter.calcData(4, 5));
		
		HelloInter inter2 = (x, y) -> x * y;
		System.out.println(inter2.calcData(4, 5));
	}

}
