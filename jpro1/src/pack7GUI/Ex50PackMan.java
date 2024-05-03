package pack7GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

// 키보드 이벤트 연습
public class Ex50PackMan extends JFrame implements KeyListener {
	Image image;
	int x = 100, y = 100;
	int selImage = 1;

	public Ex50PackMan() {
		super("상하좌우 화살표를 사용하세요");

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack2.jpg"));

		setLayout(null); // 배치관리자 없음
		setResizable(false); // 창크기 조절 (못한다)

		setBounds(200, 200, 300, 300);
		setBackground(Color.WHITE);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this);

		x = getWidth() / 2; // 프레임의 너비의 반
		y = getHeight() / 2; // 프레임의 높이의 절반
	}

	@Override
	public void paint(Graphics g) { // 그림은 여기서 그려지고 있다. 그림만 그려지는 곳
		// Frame에 뭔가를 그려주는 메소드로 자동 호출
		switch (selImage) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\pack8.jpg");
			break;
		}

		g.clearRect(0, 0, getWidth(), getHeight());// 그림 전체를 선택 후 clear된다. 잔상이 삭제된다.
		g.drawImage(image, x - image.getWidth(this) / 2, y - image.getHeight(this) / 2, this); // 여기서 this는 감시자임 ? 
																								// 좌표값이 좀 어렵네 (가운데 위치)
	}

	@Override
	public void keyPressed(KeyEvent e) { // 이벤트 처리가 발생하는 곳
		// 키보드를 누를때
		int key = e.getKeyCode();
//		System.out.println("key : " + key);

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {// 오른쪽 화살표
			// System.out.println("go");
			selImage = (selImage == 1) ? 2 : 1; // 이미지 변경
//			x = x + 10; //없어짐
			x = (x < getWidth()) ? x += 10 : -image.getWidth(this);
			System.out.println();
		}
		
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {// 왼쪽 화살표
			selImage = selImage != 3 ? 3 : 4; // 이미지 변경
//			x = x - 10;
			x = (0 > -x) ? x -= 10 : getWidth(); // 안나온다.. 오른쪽에서
			
		}
		
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {// 아래쪽 화살표
			selImage = selImage != 5 ? 5 : 6; // 이미지 변경
			y = (y < getHeight()) ? y += 10 : -image.getHeight(this);
		}
		
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {// 위쪽 화살표
			selImage = selImage == 7 ? 8 : 7; // 이미지 변경
			y = (0 > -y) ? y -= 10 : getHeight();
		}

		repaint(); // paint()를 호출한다.
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new Ex50PackMan();
	}

}
