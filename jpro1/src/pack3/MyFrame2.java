package pack3;
//공통 되는 것을 묶어 놓는것! 자원의 재활용
import java.awt.Frame;

public class MyFrame2 extends Frame{

	public MyFrame2() {
		super("상속 사용");
	}
	
	void display() {
		setSize(500,300); //현재 클래스setSize를 정의하지 않았으면 필요없다.
		//super.setSize(500,300);
		setLocation(200,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// 상속으로 Frame 띄우기
//		MyFrame2 frame = new MyFrame2();
//		frame.display();
		new MyFrame2().display();
		
	}

}
