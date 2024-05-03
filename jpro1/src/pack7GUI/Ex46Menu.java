package pack7GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ex46Menu extends JFrame implements ActionListener {
	
	JButton btnR, btnG,btnB;
	JTextArea textArea = new JTextArea("", 10, 5); //키보드로 여러 행 입력
	JMenuBar mBar;
	JMenuItem mnuMes, mnuOk, mnuInput;
	public Ex46Menu() {
		setTitle("연습");
		
		addLayout(); //버튼 관련
		addMenuLayout(); //메뉴 관련
		
		setBounds(200, 200, 400, 300);
		setVisible(true);

//		addWindowListener(....); //윈도우 종료 코드, 아래도 동일한 기능
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addLayout() {
		btnR = new JButton("빨강");
		btnG = new JButton("초록");
		btnB = new JButton("파랑");
		btnR.addActionListener(this);
		btnG.addActionListener(this);
		btnB.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(btnB);
		panel.add(btnG);
		panel.add(btnR);
		
		add("South",panel); //frame은 BorderLayout임
		add("Center", textArea);
	}
	private void addMenuLayout() {
		mBar = new JMenuBar();
		
		JMenu menu = new JMenu("대화상자");
		mnuMes = new JMenuItem("메시지 창");
		mnuOk = new JMenuItem("확인 창");
		mnuInput = new JMenuItem("입력창");
		menu.add(mnuMes); //메뉴에 메뉴 아이템 등록
		menu.add(mnuOk);
		menu.add(mnuInput);
				
		JMenu menu2 = new JMenu("나는 메뉴");
		mBar.add(menu); //메뉴바에 메뉴를 등록
		mBar.add(menu2);
		
		setJMenuBar(mBar); //JFrame에 메뉴바를 등록
		
		//메뉴에 리스너 장착 (actionPerformed 메서드로 이동)
		mnuMes.addActionListener(this);
		mnuOk.addActionListener(this);
		mnuInput.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
		if(e.getSource() == btnR) {
			textArea.setBackground(Color.RED);
		}else if(e.getSource() == btnG) {
			textArea.setBackground(new Color(0,255,0));
		}else if(e.getSource() == btnB) {
			textArea.setBackground(new Color(0,0,255));
		}else if(e.getSource() == mnuMes) {
			//내장 다이어로그 박스 호출
			JOptionPane.showMessageDialog(this, "메시지","알림",JOptionPane.INFORMATION_MESSAGE);
			//창이 닫을때까지 작업 진행을 하지않는다.
			//Modal dialogbox는 실행을 멈추고 창을 보여준다. 창을 닫으면 처리 진행.
			System.out.println("계속");
		}else if(e.getSource() == mnuOk) {
			int result= JOptionPane.showConfirmDialog(this, "버튼을 고르시오","골라",JOptionPane.YES_NO_CANCEL_OPTION);
			
			System.out.println(result); //예 0 / 아니요 1 / 취소2
			//if ...
			switch(result) {
//			case 0 : ...
			case JOptionPane.YES_OPTION:
				textArea.append("예 선택\n");
				break;
			case JOptionPane.NO_OPTION:
				textArea.append("노 선택\n");
				break;
			case JOptionPane.CANCEL_OPTION:
				textArea.append("취소 선택\n");
				break;
			}
			
		}else if(e.getSource() == mnuInput) {
//			textArea.setBackground(new Color(0,0,255));
			//JOptionPane.showInputDialog는 modal이다. 닫힐때까지 실행을 안함.
			String str = JOptionPane.showInputDialog(this,"자료입력");
			textArea.append(str+"\n");
			
		}
	}
	
	public static void main(String[] args) {
		// 메뉴 작성, 메시지 박스
		new Ex46Menu();
	}
}
