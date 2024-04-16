package pack3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//어뎁터 클래스를 이용한 이벤트 처리 연습
public class MyFrame4Adapter extends WindowAdapter {//상속(강결합) //단점이 있어 extends는 단일 상속만 가능해 > 내부클래스 배워보자.
	//WindowAdapter 추상 클래스는 WindowListener 인터페이스를 구현한 클래스이다.
	//WindowListener의 추상 메서드가 WindowAdapter에서 일반 메서드로 오버라이드한것. (어뎁터로써 일을 했다.)
	private Frame frame;
	
	public MyFrame4Adapter() {
		frame = new Frame("Adapter 연습"); //포함(약결합)
		
		frame.setSize(300, 250);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		frame.addWindowListener(this); //windowListener가 감지하는 메서드
	}
	
	@Override
		public void windowClosing(WindowEvent e) { //(WindowListener를 상속받은 windowClosing
			System.exit(0);
		}
	
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		new MyFrame4Adapter();
	}

}
