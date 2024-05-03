

package pack7GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ExCal extends JFrame implements ActionListener {
	JTextField txtIn1, txtIn2;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdoP, rdoM, rdoG, rdoN;
	JButton btnRe, btnReset, btnCl;
	JLabel lblResult;
	int close;

	public ExCal() {
		super("미니 계산기");

		layoutInit();

		setBounds(200, 200, 400, 300);
		setVisible(true);

		// super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 무명 클래스여서 this를 지정해줘야한다.
				close = JOptionPane.showConfirmDialog(ExCal.this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);

				switch (close) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					break;
				}
			}
		});
	}

	private void layoutInit() {
		setLayout(new GridLayout(5, 1));

		// 1행
		JLabel lbl1 = new JLabel("숫자1 : ");
		txtIn1 = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtIn1);
		add(panel1);

		// 2행
		JLabel lbl2 = new JLabel("숫자2 : ");
		txtIn2 = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txtIn2);
		add(panel2);

		// 3행 rdoP,rdoM,rdoG,rdoN
		rdoP = new JRadioButton("+", true);
		rdoM = new JRadioButton("-", false);
		rdoG = new JRadioButton("*", false);
		rdoN = new JRadioButton("/", false);
		buttonGroup.add(rdoP);
		buttonGroup.add(rdoM);
		buttonGroup.add(rdoG);
		buttonGroup.add(rdoN);

		JPanel panel3 = new JPanel();
		panel3.add(rdoP);
		panel3.add(rdoM);
		panel3.add(rdoG);
		panel3.add(rdoN);

		add(panel3);

		// 4행
		lblResult = new JLabel("결과: ", JLabel.CENTER);
		add(lblResult);

		txtIn1.requestFocus();

		// 5행 btnRe,btnReset,btnCl ** 버튼 관련
		btnLayout();

	}

	private void btnLayout() {
		btnRe = new JButton("계산");
		btnReset = new JButton("초기화");
		btnCl = new JButton("종료");
		btnRe.addActionListener(this);
		btnReset.addActionListener(this);
		btnCl.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(btnRe);
		panel.add(btnReset);
		panel.add(btnCl);
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// rdoP,rdoM,rdoG,rdoN txtIn1, txtIn2
		// 버튼 누르면 계산 진행 btnRe,btnReset,btnCl
		double result;

		if (e.getSource() == btnRe) { // 계산을 누르면
			// 오류검사 txtIn1, txtIn2
			if (txtIn1.getText().equals("")) { // 숫자1 없는 경우s
				lblResult.setText("숫자 입력!");
				txtIn1.requestFocus();
				return;
			}
			if (txtIn2.getText().equals("")) { // 숫자2 없는 경우
				lblResult.setText("숫자 입력!");
				txtIn2.requestFocus();
				return;
			}
			// 숫자타입 여부 확인 (나중에 보완)
			double su1 = 0;
			double su2 = 0;
			try {
				su1 = Double.parseDouble(txtIn1.getText());
				su2 = Double.parseDouble(txtIn2.getText());
			} catch (Exception e2) {
				lblResult.setText("숫자만 가능");
				txtIn1.requestFocus();
				txtIn2.requestFocus();
				return;
			}
			// 계산
			if (rdoP.isSelected()) {
				result = su1 + su2;
			} else if (rdoM.isSelected()) {
				result = su1 - su2;
			} else if (rdoG.isSelected()) {
				result = su1 * su2;
			} else {
				if (su1 == 0) {
					lblResult.setText("0 입력 불가");
					txtIn1.setText("");
					txtIn1.requestFocus();
					return;
				} else if (su2 == 0) {
					lblResult.setText("0 입력 불가");
					txtIn1.setText("");
					txtIn2.requestFocus();
					return;
				} else {
					result = su1 / su2;
				}
			}
			String message = "결과: " + result;

			lblResult.setText(message);

		} else if (e.getSource() == btnReset) {
			txtIn1.setText("");
			txtIn2.setText("");
			rdoM.setSelected(true);
			rdoM.setSelected(false);
			rdoG.setSelected(false);
			rdoN.setSelected(false);
			lblResult.setText("결과: ");

		} else if (e.getSource() == btnCl) {
			close = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);

			switch (close) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}

	}

	public static void main(String[] args) {
		new ExCal();
	}
}
