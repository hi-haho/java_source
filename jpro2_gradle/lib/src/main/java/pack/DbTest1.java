package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//mariaDB(원격DB 서버) 연동 프로그래밍 //생성자가 복잡하면 안좋다.
public class DbTest1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	//Initially the cursor is positioned before the first row.
	//The next method moves thecursor to the next row, 
	//and because it returns falsewhen there are no more rows in the ResultSet object,
	//it can be used in a while loop to iterate throughthe result set. 
	
	public DbTest1() {
		// 1. Driver file loading 
		try {
			//Unhandled exception type ClassNotFoundException >예외처리
			Class.forName("org.mariadb.jdbc.Driver");
			//mysql
//			Class.forName("com.mysql.jdbc.Driver");
			//oracle
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		} catch (Exception e) {
			System.out.println("로딩 실패: "+e);
			return;
		}
		
		// 2. DB server와 연결
		try {
			//String url="jdbc:mariadb://localhost:port번호/DB명";
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123"); //url, db user명, 비밀번호
		} catch (Exception e) {
			System.out.println("연결 실패: "+e.getMessage());
		}
		
		//3. 연결된 db server에 sql 실행
		try {
			//sangdata 테이블 자료 읽기
			stmt = conn.createStatement(); //connection 객체 생성
			
//			rs = stmt.executeQuery("select * from sangdata");
			rs = stmt.executeQuery("select code,sang,su,dan from sangdata");
//			System.out.println(rs.next());
//			rs.next(); // cursor(레코드 포인터) 이동 (처음에는 데이터 상단에 존재한다.)
//			System.out.println(rs.getString("sang")); // 칼럼명
			while(rs.next()){
				String code = rs.getString("code"); //수량
				String sangName = rs.getString("sang"); // 단가
				int su = rs.getInt("su"); //수량
				int dan = rs.getInt("dan"); //단가
				System.out.println(code + " " + sangName + " "+su +" " + dan );

			}
			
//			System.out.println("======별칭을 만들면 별칭으로 적어야한다. 칼럼은 순서가 있기에 숫자로 표현할 수 있다.======");
//			//Unknown label 'code'. Possible value [상품명, dan, 코드, su, sangdata.dan, sangdata.코드, sangdata.su, sangdata.상품명]
//			rs.close(); //자원반납, 
//			rs = stmt.executeQuery("select code as 코드,sang as 상품명, su, dan from sangdata");
//			while(rs.next()){
//				String code = rs.getString("code"); //수량
//				String sangName = rs.getString("sang"); // 단가
//				int su = rs.getInt("su"); //수량
//				int dan = rs.getInt("dan"); //단가
//				System.out.println(code + " " + sangName + " "+su +" " + dan );
//			}
//			System.out.println("==================");
			
//			String sql = "select count(*) as cou from sangdata;";
			String sql = "select count(*) from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
//			System.out.println("건수: "+rs.getString("cou"));
//			System.out.println("건수: "+rs.getString("count(*)"));
			System.out.println("건수: "+rs.getString(1)); //칼럼은 자동으로 숫자를 갖는다.
			
		} catch (Exception e) {
			System.out.println("처리 실패: "+e.getMessage());
		} finally{
			try {
				if (rs != null) rs.close(); //Unhandled exception type SQLException
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
//		System.out.println("go");
	}
	
	public static void main(String[] args) {
		new DbTest1();

	}

}
