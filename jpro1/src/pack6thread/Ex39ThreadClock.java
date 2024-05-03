package pack6thread;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ex39ThreadClock extends Frame implements ActionListener, Runnable {
	Label lblMessage;
	boolean bExit = false;
	Thread thread;

	public Ex39ThreadClock() {
		lblMessage = new Label("show time", Label.CENTER); // Indicates that the label should be right justified. 가운데 정렬
		super.add("Center", lblMessage); // 위아래 가운데

		Button btnClick = new Button("click");
		super.add("South", btnClick);
		btnClick.addActionListener(this); // this(현재클래스)

		setTitle("스레드 시계");
		setBounds(200, 200, 300, 300); // void java.awt.Window.setBounds(int x, int y, int width, int height)
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				bExit = true; //run()의 무한루핑을 탈출하기 위해
				System.exit(0);
			}
		});

		thread = new Thread(this); //run을 가지고 있는 Runnable을 구현한 클래스 == 나
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 버튼을 클릭하면 수행될 메서드
//		System.out.println("노우,,");
//		showData();
		//만약 사용자 정의 스레드가 이미 있다면 start()를 호출하지 않음
		if (thread.isAlive()) return;
		thread.start(); //1회만 호출된다.
	}

	@Override
	public void run() { //
		// 쓰레드는 무조건 run임
		while (true) {
//			if(bExit == true) {
			if (bExit) {
				break;
				
			}showData();
			try {
				Thread.sleep(1000); // 1초동안 비활성화
			} catch (Exception e) {
				System.out.println("run" + e);
			}
		}

	}

	private void showData() {
		LocalDate data = LocalDate.now(); // singleton 패턴
		int y = data.getYear();
		int m = data.getMonthValue();
		int d = data.getDayOfMonth();

		LocalTime t = LocalTime.now();
		int h = t.getHour();
		int mi = t.getMinute();
		int s = t.getSecond();

		String ss = y + "-" + m + "-" + d + "  " + h + ":" + mi + ":" + s;

		lblMessage.setText(ss);
		lblMessage.setFont(new Font("Times new Roman", Font.BOLD, 20));
	}

	public static void main(String[] args) {
		// Thread를 이용한 현재 날짜 및 시간 표시

		new Ex39ThreadClock();

	}

}
