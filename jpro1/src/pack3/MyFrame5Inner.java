package pack3;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter; //추상페이지이다.(일반 메서드를 오버라이딩하고 스스로 추상이 됨 : abapter)
import java.awt.event.WindowEvent;

public class MyFrame5Inner extends Frame {
	private Wevent wevent;
	int x,y; //mouseClicked에서 발생한 x,y 좌표를 기억
	private String[] names = {"정재형","이원재","지명기","김성하","김서연"};
	
	public MyFrame5Inner() {
		setTitle("내부클래스");
		setSize(300,250);
		setLocation(300, 200);
		setVisible(true);
		
//		wevent = new Wevent();
//		addWindowListener(wevent); //Frame 클래스가 가지고 있는 것이다.
		addWindowListener(new Wevent());
		addMouseListener(new Mevent());
	}
	
	class Wevent extends WindowAdapter{ //MyFrame5Inner 클래스 안에서만 사용됨 //내부 클래스는 extends가능
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	class Mevent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) { //좌표찍기
//			setTitle("클릭");
//			int x = e.getX();
//			int y = e.getY();
			
			x = e.getX(); //전역 변수에 값을 치환
			y = e.getY();
			setTitle("x : "+x +", y: "+y);
			
//			paint(getGraphics()); // 아래 g.drawString("홍길동", 100, 100);가 명시적 호출을 한 것. //리플레시가 안된다.
			repaint(); // getGraphics()객체를 가짐 : paint()를 호출
		}
	}
	
	@Override
	public void paint(Graphics g) {
		//Graphics : Frame이 제공하는 그림그리기 객체
//		g.drawString("홍길동", 100, 100); //자동 호출
		
		g.setFont(new Font("굴림", Font.BOLD, (int)(Math.random()*50 +8)));
		int n = (int)(Math.random()*5);
		g.drawString(names[n], x, y);
//		g.drawString("홍길동", x, y);
		
	}
	
	public static void main(String[] args) {
		new MyFrame5Inner();
	}
}
