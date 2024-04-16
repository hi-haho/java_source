package pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//인터페이스를 이용한 이벤트 처리 연습
public class MyFrame3 extends Frame implements WindowListener,MouseListener {

	public MyFrame3() {
		// super("인터페이스 사용"); //생성자를 통해서 값을 전달할 것.
		setTitle("인터페이스 사용"); // setter를 이용한 것 (super. 을 사용하면 바로 부모에게)

		display();
		
		addWindowListener(this); //내가 WindowListener타입의 객체임!
		//이벤트를 발생시킬거야, 귀를 기울여
		//전혀 모른때, addWindowListener()를 사용해야한다는 것을 어찌 알지? 방법을 찾아가는 방법
		addMouseListener(this);
	}

	void display() {
		setSize(500, 300);
		setLocation(200, 150);
		setVisible(true);
	}

	///// WindowListener가 가진 추상 메소드 오버라이딩///이벤트 핸들러 메소드///////////
	/////////////////////윈도우 오버라이딩////////////////////////
	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");

	}

	@Override
	public void windowClosing(WindowEvent e) {
//		System.out.println("windowClosing 종료");
		setTitle("안녕, 종료는 아직 .. ");
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");

	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");

	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");

	}
	///////////////////마우스 오버라이딩////////////////////////

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("클릭 성공 후 점심 먹기");
//		setBackground(new Color(255,0,0));
//		System.out.println((int)(Math.random()*255));
		int r = (int)(Math.random()*255);
		int g = (int)(Math.random()*255);
		int b = (int)(Math.random()*255);
		setBackground(new Color(r,g,b));
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		new MyFrame3();
	}

}
