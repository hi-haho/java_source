package pack7GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Swing
public class Ex45Swing extends JFrame implements ActionListener {

	JLabel lblShow;
	int count = 0;

	public Ex45Swing() {
		// TODO Auto-generated constructor stub
		setTitle("스윙 연습");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // 여백

		JButton button = new JButton("클릭(c)");
		//(c) Mnemonic > swing에만 있는 키이다.
		button.setMnemonic(KeyEvent.VK_C);
		button.addActionListener(this);
		panel.add(button);

		lblShow = new JLabel("버튼 클릭수 : ");
		panel.add(lblShow);

		add(panel, BorderLayout.CENTER);
//		add("Center", panel); // 위와 결과 동일

		setBounds(200, 200, 300, 300);
		setVisible(true);

//		addWindowListener(....); //윈도우 종료 코드, 아래도 동일한 기능
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 클릭 시 처리
		count += 1;
		lblShow.setText("버튼 클릭수 : " + count);

	}

	public static void main(String[] args) {
		new Ex45Swing();
	}
}
