package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnPooling {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DataSource ds;
	
	public ConnPooling() {
		//jndi (meta-inf파일에 설정)
		//JNDI Java Naming and Directory Interface.
		//이름지정 및 디렉토리 서비스에서 제공하는 데이터 및 객체를 참조(lookup)하기 위한 자바 API이다. 
		//일반적으로 자바 애플리케이션을 외부 디렉터리 서비스(DB server,LDAP server..)에 연결할 때 쓰인다.
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria"); //META-INF/context.xml에 정의한 db가져온다.
			//pool에서 connection 객체를 읽는다.(알아서 객체의 수를 조정한다. aphach tomcat이 해준다.)
			
			
		} catch (Exception e) {
			System.out.println("db 연결 실패 : " + e);
		}
	}
	public ArrayList<SangpumDTO> getdataAll(){
		ArrayList<SangpumDTO> list = new ArrayList<SangpumDTO>();
		try {
			conn = ds.getConnection();
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SangpumDTO dto = new SangpumDTO();
				dto.setCode(rs.getString(1));
				dto.setSang (rs.getString(2));
				dto.setSu(rs.getString(3));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("db 연결 실패 : " + e);
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
	
	public boolean insertData(SangpumBean bean) {
		boolean b = false;
		
		try {
			conn = ds.getConnection();
			
			//마지막 상품 코드
			String sql = "select max(code) as max from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //select : Query();
			//rs.next();
			//System.out.println(rs.next());
			//int nextCode = rs.getInt(1); // 쿼리문의 첫번째 필드를 integer 형으로 받겠다는 의미
			//System.out.println(nextCode); //5
			int maxCode =0;
			if(rs.next()) {
				maxCode = rs.getInt("max");
			}
			
			//추가 작업 (insert)
			String sql1 = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, maxCode+1);
			pstmt.setString(2, bean.getSang());
			pstmt.setString(3, bean.getSu());
			pstmt.setString(4, bean.getDan());
			int result = pstmt.executeUpdate();
			
			if(result == 1) b = true;
			
		} catch (Exception e) {
			System.out.println("insertData err" + e);
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
}
