package pack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbTest2CRUD {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	Properties prop = new Properties();
	
	
	public DbTest2CRUD() { // secure coding의 하나로 연결정보 별도 저장 후 읽기
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\dbtest2.properties"));
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("passwd"));
			
			stmt = conn.createStatement();
			
			String sql = "";
			/*\\\\\\\CRUD\\\\\\\\\\*/
			
			////////////C : 자료 추가/////////////
			/* auto commit이 기본이다.*/
			//sql = "insert into sangdata values(5,'새우깡',55,3000)";
			//stmt.executeUpdate(sql); // insert, update, delete
			
			/*auto commit 수동으로 전환하는 작업 : Transaction 처리가 필요 - DB감지 안하고 log로 들어가 있다.*/
//			conn.setAutoCommit(false); //이제 commit이나 rollback을 필요로한다.
//			sql = "insert into sangdata values(6,'감자깡',7,3000)";
//			stmt.executeUpdate(sql); // 트렌젝션 시작
//			sql = "insert into sangdata values(7,'고구마깡',71,2000)";
//			stmt.executeUpdate(sql);
////			conn.rollback();  //트렌젝션 종료(그동안의 입력은 취소가된다.)
//			conn.commit(); // 원본에 적용
//			
//			/*auto commit으로 전환*/
//			conn.setAutoCommit(true);
			
			
			
			///////// R : 모든 자료 읽기 ////////
			sql = "select * from sangdata order by code desc";
			rs = stmt.executeQuery(sql); //select
			int cou = 0;
			while(rs.next()) {
				System.out.println(rs.getString("code") + " "+rs.getString("sang")+" "+rs.getString("su")+" "+rs.getString("dan"));
				cou++;
			}
			System.out.println("건수: "+ cou);
			
			///////부분 자료읽기 (하나의 자료는 if)///////
			System.out.println("---------------------");
			sql = "select * from sangdata where code=7";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getString("code") + " "+rs.getString("sang")+" "+rs.getString("su")+" "+rs.getString("dan"));
			}else {
				System.out.println("해당 자료는 없습니다.");
			}
			
			
			
			//////////U : 자료 수정////////////
//			sql="update sangdata set sang='데일리콤부차',su=12,dan=8000 where code=5";
//			stmt.executeUpdate(sql);
			
			
			///////D : 자료 삭제/////////
			System.out.println("\n------자료삭제------");
			sql="delete from sangdata where code >= 5";
//			stmt.executeUpdate(sql);
			//insert(return 0(실패) or 1(성공)), update, deletd(반환값 복수 가능)는 수행 후 처리 수 만큼 행의 갯수를 반환한다.
			int result = stmt.executeUpdate(sql); //결과를 알려주기 위해서는 반환값을 받을 수 있다.
			System.out.println("result: "+ result);
			if(result ==0) System.out.println("삭제실패");
			
		} catch (Exception e) {
			System.out.println("err : "+e);
		}finally {
			try {
				if(rs != null) rs.close(); //GC가 언젠간 해제해주지만 지정해주면 GC가 바로 진행해준다
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest2CRUD();

	}

}
