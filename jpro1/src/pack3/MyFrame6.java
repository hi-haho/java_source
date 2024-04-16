package pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame6 extends Frame {
	
	public MyFrame6(String msg) {
		super(msg);
		
		setSize(300,250);
		setLocation(300, 200);
		setVisible(true);
		
		//anonymous를 사용하기 위해 new를 한것임. 추상은 원래 인스턴스가 되지 않는다.
		addWindowListener(new WindowAdapter() {  //java가 이벤트 처리할때 많이 사용(안드로이드 할때)
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			setBackground(Color.BLUE);
			}
		});
	}
	public static void main(String[] args) {
		// 내부 무명클래스
		
		new MyFrame6("내부 무명 클래스");

	}

}
