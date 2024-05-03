package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest4 {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public DbTest4() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			stmt = conn.createStatement();
			
			boolean b = false;
			
			//.execute() : .executeQuery() + .executeUpdate() 하나로 합친 것
			
			/*update*/
			b = stmt.execute("update sangdata set sang = '마우스' where code =4");
			System.out.println("update b: "+b); //update b: false
			int result = stmt.getUpdateCount(); //반환값 받기
			System.out.println("result : "+ result); //result : 1 > 반환값이 있다.
			if (result >=1) {
				System.out.println("작업성공");
			} else {
				System.out.println("작업실패");
			}
			
			/*select*/
			b = stmt.execute("select * from sangdata"); //반환값은 t/f이다.
			System.out.println("select b : " + b); //select b : true > select인지 구분한다. true값을 받으면 .getResultSet() 사용
			rs = stmt.getResultSet();
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t"+rs.getString(2) + "\t"+rs.getString(3) + "\t"+rs.getString(4) + "\t");
			}
			
		} catch(Exception e) {
			System.out.println("로딩 실패: "+e);
			return;
		}
	}
	public static void main(String[] args) {
		new DbTest4();

	}

}
