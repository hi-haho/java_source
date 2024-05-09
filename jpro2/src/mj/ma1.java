package mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ma1 {
	String buserName;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ma1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("부서명 : ");
		buserName = scanner.nextLine();

		buserTel(buserName);
		buserJik(buserName);
		buserInf(buserName);
	}

	private void buserTel(String buserName) {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String Sql = "select buser_name, buser_tel from buser where buser_name=?";

			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, buserName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("buser_name") + " 전화번호는 " + rs.getString("buser_tel"));
			}

		} catch (Exception e) {
			System.out.println("jikbuser err : " + e);
		}

	}

	private void buserJik(String buserName) {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String Sql = "select jikwon_no,jikwon_name,jikwon_jik,jikwon_gen "
					+ "from jikwon where buser_num = (select buser_no from buser where buser_name = ?)";

			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, buserName);
			rs = pstmt.executeQuery();

			System.out.println("사번\t이름\t직급\t성별");
			while (rs.next()) {
				System.out.println(rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t"
						+ rs.getString("jikwon_jik") + "\t" + rs.getString("jikwon_gen") + "\t");
			}

		} catch (Exception e) {
			System.out.println("buserJik err : " + e);
		}

	}

	private void buserInf(String buserName) {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String Sql = "select COUNT(*) as jikNum, jikwon_gen "
					+ "from jikwon where buser_num = "
					+ "(select buser_no from buser where buser_name = ?)"
					+ "group by jikwon_gen;";

			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, buserName);
			rs = pstmt.executeQuery();
			System.out.println("인원수는 ");
			while(rs.next()) {
				System.out.print(rs.getString("jikwon_gen")+"직원 : "+rs.getString("jikNum")+"명 " );
//				if(rs.next() == false) {
//					System.out.print(", ");
//				}
			}
			
			String payAvgSql = "select FLOOR(avg(jikwon_pay)), jikwon_gen "
					+ "from jikwon where buser_num = "
					+ "(select buser_no from buser where buser_name = ?)"
					+ "group by jikwon_gen;";
			
			pstmt = conn.prepareStatement(payAvgSql);
			pstmt.setString(1, buserName);
			rs = pstmt.executeQuery();
			System.out.println("\n연봉 평균은 ");
			while(rs.next()) {
				System.out.print(rs.getString("jikwon_gen")+"직원 : "+rs.getString("FLOOR(avg(jikwon_pay))") );
//				if(rs.next() == false) {
//				System.out.print(", ");
//			}
			}
			
			
		} catch (Exception e) {
			System.out.println("buserInf err : " + e);
		}finally {
			try {
				if (rs != null)
					rs.close(); // Unhandled exception type SQLException
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println("close err : " + e2);
			}
		}
	}
	private void condb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("addDb err : " + e);
		}
	}

	public static void main(String[] args) {
		new ma1();
	}
}
