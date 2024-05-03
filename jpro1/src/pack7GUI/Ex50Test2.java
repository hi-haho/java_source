package pack7GUI;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex50Test2 extends JFrame implements ActionListener {
	JTextField txtName, txtK, txtE, txtM; // 이름, 국어, 수학, 영어
	JLabel total, avg, eva, imgg; // 총점, 평균, 평가
	JButton btnOk, btnRe;
	String message2 ; // 평가

	Image img1, img2;
	ImageIcon img;

	public Ex50Test2() {
		super("성적 출력");

		layoutInit();

		setBounds(200, 200, 400, 700);
		setVisible(true);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void layoutInit() {
		setLayout(new GridLayout(5, 1)); // 그리드 5행 1열

		// 1행 이름
		JLabel lbl1 = new JLabel("이름 : ");
		txtName = new JTextField("", 10);

		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtName);
		add(panel1); // Frame에 등록

		// 2행 txtK, txtE, txtM
		JLabel lbl2_1 = new JLabel("국어 : ");
		txtK = new JTextField("", 5);
		JLabel lbl2_2 = new JLabel("영어 : ");
		txtE = new JTextField("", 5);
		JLabel lbl2_3 = new JLabel("수학 : ");
		txtM = new JTextField("", 5);

		JPanel panel2 = new JPanel();
		panel2.add(lbl2_1);
		panel2.add(txtK);
		panel2.add(lbl2_2);
		panel2.add(txtE);
		panel2.add(lbl2_3);
		panel2.add(txtM);

		add(panel2);

		// 3행 total, avg, eva; //총점, 평균, 평가
		total = new JLabel("총점: ", JLabel.LEFT);
		avg = new JLabel("평균: ", JLabel.CENTER);
		eva = new JLabel("평가: ", JLabel.RIGHT);

		JPanel panel3 = new JPanel();
		panel3.add(total);
		panel3.add(avg);
		panel3.add(eva);

		add(panel3);

		// 4행
		btnLayout();

		// 5행

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		switch (message2) {
		case "A":
		case "B":
			img = new ImageIcon("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\172600.jpg");
			break;
		case "C":
		case "D":
		case "F":
			img = new ImageIcon("C:\\work\\jsou\\jpro1\\src\\pack7GUI\\172713.jpg");
			break;
		}

	}

	// btnOk,btnRe
	private void btnLayout() {
		btnOk = new JButton("확인");
		btnRe = new JButton("초기화");

		btnOk.addActionListener(this);
		btnRe.addActionListener(this);

		JPanel btnpanel = new JPanel();
		btnpanel.add(btnOk);
		btnpanel.add(btnRe);
		add(btnpanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 누르면 이벤트 발생 btnOk

		if (e.getSource() == btnOk) {
			// 유효성 검사 : txtK, txtE, txtM; 국어 영어 숫자 입력값
			if (txtK.getText().equals("")) {
				txtK.requestFocus();
				return;
			} else if (txtE.getText().equals("")) {
				txtE.requestFocus();
				return;
			} else if (txtM.getText().equals("")) {
				txtM.requestFocus();
				return;
			}

			// 유효성 검사 txtK, txtE, txtM; 국어 영어 숫자
			double suK ;
			double suE ;
			double suM ;

			try {
				suK = Double.parseDouble(txtK.getText());
				suE = Double.parseDouble(txtE.getText());
				suM = Double.parseDouble(txtM.getText());
			} catch (Exception e2) {

				txtK.requestFocus();
				txtE.requestFocus();
				txtM.requestFocus();
				return;
			}
			
			// 0과 100사이
			if (0 > suK || suK > 100) {
				txtK.setText("");
			} else if (0 > suE || suE > 100) {
				txtE.setText("");
			}else if (0 > suM || suM > 100) {
				txtM.setText("");
			}

			// 계산 total, avg, eva;
			// 총점, 평균, 평가
			double result = suK + suE + suM;
			String message = "총점: " + result;
			total.setText(message);
			
			double avG = result/3.;
			String message1 = "평균: " + avG;
			avg.setText(message1);

			if (avG >= 90) {
				message2 = "A";

			} else if (89 >= avG && avG >= 80) {
				message2 = "B";

			} else if (79 >= avG && avG >= 70) {
				message2 = "C";
			} else if (69 >= avG && avG >= 60) {
				message2 = "D";
			} else {
				message2 = "F";
			}
			eva.setText("평가:  " + message2);

		} else if (e.getSource() == btnRe) {
			// 버튼 누르면 이벤트 발생 btnRe "초기화" total, avg, eva //총점, 평균, 평가
			txtName.setText("");
			txtK.setText("");
			txtE.setText("");
			txtM.setText("");
			total.setText("총점: ");
			avg.setText("평균: ");
			eva.setText("평가: ");
			imgg.setIcon(null);

		}

	}

	public static void main(String[] args) {
		new Ex50Test2();
	}

}
