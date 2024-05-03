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
			
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

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
					su = Integer.parseInt(txtC.getText());
				} catch (Exception e2) {
					System.out.println("숫자를 입력하세요");
					return;
				}try {
					dan = Integer.parseInt(txtC.getText());
				} catch (Exception e2) {
					System.out.println("숫자를 입력하세요");
					return;
				}
				
				
				/* 자료 추가 */// txtC,txtP, txtS, txtD (code,sang,su,dan)
				sql = "insert into sangdata(code,sang,su,da) values(?,?,?,?)";
				System.out.println("여ㅣ까지 정상");
				pstmt = conn.prepareStatement(sql);
				System.out.println("여기까지 찍히몀ㄴ 까지 정상");
				
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
