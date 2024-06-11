package pack.borad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardMgr {
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	private DataSource ds;
	//페이징
	private int rectot; //전체 레코드(행) 수
	private int plist = 5; // 페이지 당 출력 행 수
	private int pageSu; // 전체 페이지 수
	
	public BoardMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("db 연결 실패 : " + e.getMessage());
		}
	}
	
	//전체 자료 읽기
	//public ArrayList<BoardDTO> getDataAll(int page){
	public ArrayList<BoardDTO> getDataAll(int page, String stype, String sword){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		//String sql = "select * from board order by gnum desc, onum asc";
		String sql = "select * from board ";
				//+ " order by gnum desc, onum asc";
		try {
			conn = ds.getConnection();
			if(sword == null) { //검색이 없는 경우
				sql += "order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
			}else { //검색이 있는 경우
				sql += "where " + stype + " like ? ";
				sql += "order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+sword+"%");
			}
			rs = pstmt.executeQuery();
			
			//paging
			for(int i=0;i<(page-1)*plist; i++) {
				rs.next(); //레코드 포인터 이동0,4
			}
			
			int k =0;
			while(rs.next() && k < plist) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setBdate(rs.getString("bdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setNested(rs.getInt("nested"));
				list.add(dto);
				k++;
			}
			
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e.getMessage());
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
	// ---------게시판 목록 ---------------
	public int currentMaxNum() { //board 테이블의 최대 번호 반남
		String sql = "select max(num) from board";
		int num = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) num = rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		return num;
		
		}
	}
	
	public void saveData(BoardFormbean bean) {
		String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPass());
			pstmt.setString(4, bean.getMail());
			pstmt.setString(5, bean.getTitle());
			pstmt.setString(6, bean.getCont());
			pstmt.setString(7, bean.getBip());
			pstmt.setString(8, bean.getBdate());
			pstmt.setInt(9, 0);
			pstmt.setInt(10, bean.getGnum());
			pstmt.setInt(11, bean.getOnum());
			pstmt.setInt(12, bean.getNested());
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		}
	}
	
	// ------paging---------
	//전체 레코드 수 구하기
	public void totalList() {
		String sql = "select count(*) from board";
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			rectot = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	//전체 페이지 수 반환
	public int getPageSu() {
		pageSu = rectot/plist;
		if(rectot %plist >0) pageSu++;
		return pageSu;
	}
}
