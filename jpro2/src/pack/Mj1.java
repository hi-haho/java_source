package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Mj1 {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd; //칼럼(열)이름 가져오는 메서드
	
	public Mj1() {
		// 연결
		connSql();
		
		// 정보 받기
		Scanner scanner =  new Scanner(System.in);
		System.out.print("부서 번호: ");
		String num = scanner.nextLine();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "";
			
			/// 읽어오기////
			sql = "select jikwon_no 사번, jikwon_name 이름,"
					+ "(select buser_name from buser where jikwon.buser_num = buser.buser_no) 부서,"
					+ "jikwon_jik 직급, jikwon_pay 연봉 from jikwon where buser_num="+num;
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			
			int count = rsmd.getColumnCount();
			for (int i= 1; i<=count;i++) {
				String name = rsmd.getColumnLabel(i);
				System.out.print(name+"  ");
			};
			System.out.println();
//			System.out.println("사번 이름 부서  직급  연봉 ");
			int cou =0;
			while(rs.next()) {
				System.out.println(rs.getString("사번")+"  "+ rs.getString("이름")+"  "+ rs.getString("부서")+"  "+ rs.getString("직급")+"  "+ rs.getString("연봉"));
				cou++;
			}
			System.out.println("건수 : "+ cou);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	//sql 연동 메서드..?
	private void connSql() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("로딩 실패: " + cnfe);
		}catch (Exception e) {
			System.out.println("연결 실패: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mj1();
	}

}
