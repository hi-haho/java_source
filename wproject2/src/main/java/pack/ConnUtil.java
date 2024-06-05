package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnUtil {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ConnUtil() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("ConnUtil err : " + e);
		}
	}
	public ArrayList<SangpumDTO> getDataAll(){
		ArrayList<SangpumDTO> list = new ArrayList<SangpumDTO>();
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			pstmt = conn.prepareStatement("select * from sangdata");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SangpumDTO dto = new SangpumDTO();
				dto.setCode(rs.getString("code")); //.setCode(rs.getString(1))
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
}
