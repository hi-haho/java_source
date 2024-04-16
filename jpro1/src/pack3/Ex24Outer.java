package pack3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

//내부 클래스
// 클래스의 멤버로 멤버 필드(전역변수), 메서드, 생성자를 사용할 수 있다.
// 추가적으로 특정 클래스 내에서 클래스를 선언해서 사용할 수 있는데 이를 내부 클래스라고 한다.
// - 내부 클래스는 독립적으로 인스턴스 할 수 없다. 내부클래스를 포함한 외부 클래스에 의해 통제된다.

public class Ex24Outer {
	private int a;
	private Inner inner;

	public Ex24Outer() {
		System.out.println("Outer생성자");
		a = 10;
		inner = new Inner(); // 내부 클래스는 외부 클래스를 통해 인스턴스한다.
	}

	public void aa() {
		System.out.println("외부에 있는 aa 메서드 실행");
		bb(); // aa와 동급 메서드 호출
		inner.cc(); // cc메서드는 내부 클래스의 멤버이다.
		System.out.println("1 .outer의 a: " + a + ", Inner의 b: " + inner.b);
	}

	public void bb() {
		System.out.println("외부에 있는 bb 메서드 처리");
	}

	public class Inner { // 내부 클래스 (위 클래스에서만 사용하는 클래스야!!)
		private int b;

		public Inner() {
			System.out.println("내부 Inner 생성자");
			b = 20;
		}

		public void cc() {
			System.out.println("내부에 있는 cc 메서드 (클래스 안에 클래스)");
			bb(); //내부 클래스에서 찾다가 없으면 외부 클래스로 간다.(외부 클래스의 멤버를 자유롭게 호출 가능)
			System.out.println("2. outer의 a: " + a + ", Inner의 b: " + inner.b);
		}

		public class InnerInner {
			public InnerInner() {
				System.out.println("클래스 안에 클래스안에 클래스야! 나는 내내부 클래스인거지");
			}
		}
	}
	//내부 클래스의 수 만큼 extends를 사용할 수 있다.ㅣ
	public class Inner2 extends Frame{}
	public class Inner3 extends WindowAdapter{}
}
