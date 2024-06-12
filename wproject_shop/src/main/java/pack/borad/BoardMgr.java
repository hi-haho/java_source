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
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DataSource ds;
	// 페이징
	private int rectot; // 전체 레코드(행) 수
	private int plist = 5; // 페이지 당 출력 행 수
	private int pageSu; // 전체 페이지 수

	public BoardMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("db 연결 실패 : " + e.getMessage());
		}
	}

	// 전체 자료 읽기
	// public ArrayList<BoardDTO> getDataAll(int page){
	public ArrayList<BoardDTO> getDataAll(int page, String stype, String sword) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		// String sql = "select * from board order by gnum desc, onum asc";
		String sql = "select * from board ";
		// + " order by gnum desc, onum asc";
		try {
			conn = ds.getConnection();
			if (sword == null) { // 검색이 없는 경우
				sql += "order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
			} else { // 검색이 있는 경우
				sql += "where " + stype + " like ? ";
				sql += "order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + sword + "%");
			}
			rs = pstmt.executeQuery();

			// paging
			for (int i = 0; i < (page - 1) * plist; i++) {
				rs.next(); // 레코드 포인터 이동0,4
			}

			int k = 0;
			while (rs.next() && k < plist) {
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
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}

	// ---------게시판 목록 ---------------
	public int currentMaxNum() { // board 테이블의 최대 번호 반남
		String sql = "select max(num) from board";
		int num = 0;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
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
			pstmt.setInt(9, 0); //readcnt : 값(0)을 반드시 줘야한다
			pstmt.setInt(10, bean.getGnum());
			pstmt.setInt(11, 0);
			pstmt.setInt(12, 0);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}

	// ------paging---------
	// 전체 레코드 수 구하기
	public void totalList() {
		String sql = "select count(*) from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			rectot = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	// 전체 페이지 수 반환
	public int getPageSu() {
		pageSu = rectot / plist;
		if (rectot % plist > 0)
			pageSu++;
		return pageSu;
	}
	
	
	//조회수 증가
	public void updateReadcnt(String num) {
		String sql = "update board set readcnt = readcnt + 1 where num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	//해당 번호에 맞는 정보를 가지고 오는것 (상세보기)
	public BoardDTO getData(String num) {
		String sql = "select * from board where num=?";
		BoardDTO dto = null;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			//rs.next(); //가능하지만 이렇게 사용하면 url을 타고 들어오면 해당 값이 없어도 보여지된다.
			if(rs.next()) { //상세페이지에 보여줄 내욜
				dto = new BoardDTO();
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setMail(rs.getString("mail"));
				dto.setTitle(rs.getString("title"));
				dto.setCont(rs.getString("cont"));
				dto.setBip(rs.getString("bip"));
				dto.setBdate(rs.getString("bdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
	//댓글
	public BoardDTO getReplyData(String num) {
		String sql = "select * from board where num=?";
		BoardDTO dto = null;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //원글에 대한 내용
				dto = new BoardDTO();
				dto.setTitle(rs.getString("title"));
				dto.setGnum(rs.getInt("gnum"));
				dto.setOnum(rs.getInt("onum"));
				dto.setNested(rs.getInt("nested"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
	//댓글용 : onum 갱신
	public void updateOnum(int gnum , int onum) {
	// 같은 그룹의 레코드는 모두 잡업에 참여 - 같은 그룹의 onum 값 갱신
	// 댓글의 onum은 이미 db에 있는 onum보다 크거나 같은 값을 변경한다.
		String sql = "update board set onum=onum+1 where onum >= ? and gnum=?";
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, onum);
			pstmt.setInt(2, gnum);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	//댓글 저장
	public void replySave(BoardFormbean bean) {
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
			pstmt.setInt(9, 0); //readcnt : 값(0)을 반드시 줘야한다
			pstmt.setInt(10, bean.getGnum());
			pstmt.setInt(11, bean.getOnum());
			pstmt.setInt(12, bean.getNested());
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
	
	//수정 글 : 비밀번호 확인(비교)
	//num으로 DB 접근, pass로 수정 가능 유무 
	public boolean checkPass(int num , String user_pass) {
		boolean b = false;
		
		String sql = "select pass from board where num =?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(user_pass.equals(rs.getString("pass"))) {
					b=true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
	}
	
	public void saveEdit(BoardFormbean bean) {
		
		String sql = "update board set name=?, mail=?, title=?,cont=? where num=? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getMail());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getCont());
			pstmt.setInt(5, bean.getNum());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	//삭제완료
	public void delData(String num) {
		String sql="delete from board where num= ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

















