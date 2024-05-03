package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest3Gogek extends JFrame implements ActionListener {

	JButton btnA = new JButton("전체");
	JButton btnB = new JButton("남자");
	JButton btnC = new JButton("여자");
	JTextArea txtResult = new JTextArea(); // select 결과가 찍히는 부분

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DbTest3Gogek() {
		setTitle("고객 자료");

		layInit();
		accDb();

		setBounds(200, 500, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {
		JPanel jPanel = new JPanel();
		jPanel.add(btnA);
		jPanel.add(btnB);
		jPanel.add(btnC);

		txtResult.setEditable(false); // read only
		JScrollPane pane = new JScrollPane(txtResult); // 스크롤바

		add("Center", pane);
		add("North", jPanel);

		btnA.addActionListener(this);
		btnB.addActionListener(this);
		btnC.addActionListener(this);
	}

	private void accDb() {
		// 드라이버 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDB err : " + e);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {// 버튼 이벤트를 클릭하면 수행
		// DB 연결은 필요시 접속하고 작업이 끝나면 반드시 연결을 해제한다.
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

			stmt = conn.createStatement();

			String sql = "select gogek_no, gogek_name, gogek_jumin from gogek";

			if (e.getSource() == btnA) {

			} else if (e.getSource() == btnB) {
				sql += " where gogek_jumin like '%-1%'";
//				sql += " where substr(gogek_jumin,8,1)=1";
			} else if (e.getSource() == btnC) {
				sql += " where gogek_jumin like '%-2%'";
			}
			txtResult.setText(null); // text 박스 리셋

			rs = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");
			
			while (rs.next()) {
				String imsi = rs.getString("gogek_no") + "\t"
							+ rs.getString("gogek_name") + "\t"
							+ rs.getString("gogek_jumin") + "\n";
				txtResult.append(imsi);
				count++;
			}
			
			txtResult.append("인원수 : " + count);

		} catch (Exception e2) {
			System.out.println("actionperformed err : " + e2);
		} finally {
			try {
				if (rs != null)
					rs.close(); // Unhandled exception type SQLException
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	public static void main(String[] args) {
		new DbTest3Gogek();
	}

}
