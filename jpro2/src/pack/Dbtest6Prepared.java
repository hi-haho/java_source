package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PreparedStatement : 선처리 방식이 가능, sql문에 입력자료 적용시 ? 연산자 가능(시큐어코딩 가이드에 맞출 수 있다.)
public class Dbtest6Prepared {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Dbtest6Prepared() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

			String sql = "";
			
			//자료 추가
			/*
			sql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "10");
			pstmt.setString(2, "신상품");
			pstmt.setInt(3, 12);
			pstmt.setString(4, "5000");
			
			int re = pstmt.executeUpdate();
			
			System.out.println("insert 반환 : "+re); //정상이면 1
			*/
			
			//자료 수정
			/*
			sql = "update sangdata set sang=?,su=? where code=?"; //
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "아메리카노");
			pstmt.setInt(2, 33);
			pstmt.setInt(3,10);
			
			int re = pstmt.executeUpdate();
			System.out.println("Update 반환 : "+re); //정상이면 1
			*/
			
			//자료 삭제
			sql="delete from sangdata where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,10);
			if (pstmt.executeUpdate() >=1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			// 전체 자료 읽기
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 그냥 사용만 하면 된다.

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" 
								+ rs.getString(2) + "\t" 
								+ rs.getString(3) + "\t"
								+ rs.getString(4) + "\t");
			}
			
			System.out.println();
			//부분 자료 읽기
			String no = "2"; //외부에서 받았다는 가정
//			sql = "select * from sangdata where code="+no;//sql imjection 공격 대상이 된다.
			//secure coding guideline에 맞춰 코딩
			sql = "select * from sangdata where code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			//첫번째 ?에 매핑된다. sql코드(code=?)의 타입과 상관없다. 변수 no의 타입과 상관있다(.setString())
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("code") + "\t" 
						+ rs.getString("sang") + "\t" 
						+ rs.getString("su") + "\t"
						+ rs.getString("dan") + "\t");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Dbtest6Prepared();
	}

}
