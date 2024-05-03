package pack7GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

// JDialog :맞춤형 대화 상자 작성, 커스터마이징이 가능하다.(frame 아니다.다이얼로그이다.)   https://movefast.tistory.com/69
//Frame에서 자식창으로 호출 가능
public class Ex49MemoAbout extends JDialog implements ActionListener { //메모장에 종속되는 창이다.
	
	public Ex49MemoAbout(JFrame frame) {
		//부모 프레임을 알려줘야한다.
		super(frame);
//		super(frame,"메모장이란",true); //Modal이다. false이면 Modaless이다. 
		
		setTitle("메모장이란");
		setModal(true); // true Modal
//		setModal(false); // false Modal, Modalsee
		
		initLayoutAbout();
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(350, 350, 200, 200);
		setVisible(true);
		
	}
	
	private void initLayoutAbout() {
		JLabel lblMes = new JLabel("미니 메모장 ver 0.9");
		JButton btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		add("Center", lblMes);
		add("South", btnConfirm);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); //JDialog 담기
		
	}
}
