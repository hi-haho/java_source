package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mj2 extends JFrame implements ActionListener {

	JButton btnA;
	JTextField txtC, txtP, txtS, txtD; // 코드,품명,수량,단가
	int code, pName, su, dan;// 코드,품명,수량,단가
	JTextArea txtResult;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql = "";

	public Mj2() {
		super("상품처리");

		layInit();
		accDb();

		setBounds(200, 500, 500, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void accDb() {
		// 드라이버 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			display();

		} catch (Exception e2) {
			System.out.println("actionperformed err : " + e2);
		} finally {
			try {
				if (rs != null)
					rs.close(); // Unhandled exception type SQLException
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		}

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnA) {// code, pName, su, dan
				//숫자인지 조사
				try {
					code = Integer.parseInt(txtC.getText());
				} catch (Exception e2) {
					System.out.println("숫자를 입력하세요");
					return;
				}
				try {
					su = Integer.parseInt(txtS.getText());
				} catch (Exception e2) {
					System.out.println("숫자를 입력하세요");
					return;
				}try {
					dan = Integer.parseInt(txtD.getText());
				} catch (Exception e2) {
					System.out.println("숫자를 입력하세요");
					return;
				}
				
				String url = "jdbc:mariadb://localhost:3306/test";
				conn = DriverManager.getConnection(url, "root", "123");
				
				/* 자료 추가 */// txtC,txtP, txtS, txtD
				sql = "insert into sangdata values(?,?,?,?)";
				//System.out.println(code + " " + txtP.getText() + " " + su + " " + dan);
				
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setInt(1,code);
				pstmt.setString(2, txtP.getText());
				pstmt.setInt(3, su); 
				pstmt.setInt(4, dan);
			
				
				int re = pstmt.executeUpdate();
				if (re == 1) {
					System.out.println("자료를 정상적으로 추가했습니다.");
				} else {
					System.out.println("자료 추가에 실패했습니다.");
				}
				
//				System.out.println("여ㅣ까지 정상");
				
				display(); //전체데이터
				
			}
		} catch (Exception e2) {
			System.out.println("actionPerformed err : "+e);
		}

	}
	
	private void display() {
		try {
			/* 전체 테이터 */
			sql = "select code, sang, su, dan, su*dan 금액 from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			txtResult.setText("코드\t상품명\t수량\t단가\t금액");
			int count = 0;
			
			while (rs.next()) {
//			int p = Integer.parseInt(rs.getString("dan")) + Integer.parseInt(rs.getString("su"));
				txtResult.append("\n");
				String imsi = rs.getString("code") + "\t" 
						+ rs.getString("sang") + "\t" 
						+ rs.getString("su") + "\t"
						+ rs.getString("dan") + "\t"
						+ rs.getString("금액") + "\t";
				txtResult.append(imsi);
				count++;
			}
			
			txtResult.append("\n\n인원수 : " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void layInit() { // JTextField txtC,txtP,txtS,txtD;

		txtC = new JTextField("", 5);
		txtP = new JTextField("", 5);
		txtS = new JTextField("", 5);
		txtD = new JTextField("", 5);

		JPanel jPanel = new JPanel();
		jPanel.add(new JLabel("코드: "));
		jPanel.add(txtC);
		jPanel.add(new JLabel("품명: "));
		jPanel.add(txtP);
		jPanel.add(new JLabel("수량: "));
		jPanel.add(txtS);
		jPanel.add(new JLabel("단가: "));
		jPanel.add(txtD);

		btnA = new JButton("추가"); // 버튼 추가
		jPanel.add(btnA);
		btnA.addActionListener(this);

		add("Center", jPanel);

		txtResult = new JTextArea(); // 글 찍히는 공간
		txtResult.setBounds(200, 500, 400, 200);
		txtResult.setEditable(false);

		JScrollPane pane = new JScrollPane(txtResult); // 스크롤바

		add("Center", pane);
		add("North", jPanel);
	}

	

	public static void main(String[] args) {
		new Mj2();
	}

}

/*
 package pack;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest07 extends JFrame implements ActionListener {
	JTextField code = new JTextField("", 5);
	JTextField name = new JTextField("", 10);
	JTextField cnt = new JTextField("", 5);
	JTextField price = new JTextField("", 5);
	JButton plus = new JButton("추가");
	JTextArea result = new JTextArea();
	String sql = "";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DbTest07() {
		super("상품추가 연습문제");

		accDb();
		layInit();

		setBounds(200, 200, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {

		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("코드 : "));
		panel1.add(code);
		panel1.add(new JLabel("품명 : "));
		panel1.add(name);
		panel1.add(new JLabel("수량 : "));
		panel1.add(cnt);
		panel1.add(new JLabel("단가 : "));
		panel1.add(price);
		panel1.add(plus);
		add("North", panel1);

		
		result.setEditable(false);
		JScrollPane pane = new JScrollPane(result);
		add(pane);

		plus.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String co = code.getText();
			String na = name.getText();
			String cn = cnt.getText();
			String pr = price.getText();

			sql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, co);
			pstmt.setString(2, na);
			pstmt.setString(3, cn);
			pstmt.setString(4, pr);
			rs = pstmt.executeQuery();


			display();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "코드가 중복되었거나 입력되지 않았습니다.");
		}
	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			processDb();
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}
		display();
		
	}

	private void processDb() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

			display();

		} catch (Exception e) {
			System.out.println("processDb error : " + e);
		}
	}

	private void display() {
		try {
			DecimalFormat df = new DecimalFormat("#,##0"); //#,### > 무효의 제료로 본다. #,##0 > 유효의 제로(0)로 본다
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int count = 0;
			result.setText("코드  \t 상품명  \t 수량  \t 단가  \t 금액  \n");
			while (rs.next()) {
				result.append(rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + 
						"\t" + rs.getString("dan") + "\t" + df.format(rs.getInt("su") * rs.getInt("dan")) + "\n");
				count++;
			}
			result.append("건수 : " + count);
		} catch (Exception e) {
			System.out.println("display() error : " + e);
		}
	}


	public static void main(String[] args) {
		new DbTest07();

	}

}

 * */
