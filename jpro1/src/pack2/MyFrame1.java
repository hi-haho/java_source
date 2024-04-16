package pack2;

import java.awt.Frame;

//java가 지원하는 Frame 클래스로 창띄우기 : 포함관계
public class MyFrame1 {
	private String title = "포함관계";
	private Frame frame;
	
	public MyFrame1() { //생성자에 너무 많은 코드를 쓰면 좋지 않다. 기능은 따로 빼자
		frame = new Frame(title); //객체를 만들었다.
	}
	
	private void display() {
		frame.setSize(500, 300);
		frame.setLocation(200, 150);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {//객체 변수가 반드시 있어야하는 것은 아니다.
		new MyFrame1().display(); //메서드도 .으로 참조가 가능하다.
		
//		MyFrame1 frame1 = new MyFrame1(); 1번 방법
//		frame1.display();
	}

}
