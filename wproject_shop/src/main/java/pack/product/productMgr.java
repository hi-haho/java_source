package pack.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class productMgr {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DataSource ds;

	public productMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("db 연결 실패 : " + e.getMessage());
		}
	}
	
	public ArrayList<productDTO> getProductAll(){
		ArrayList<productDTO> list = new ArrayList<productDTO>();
		try {
			conn = ds.getConnection();
			String sql="select * from shop_product order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				productDTO dto = new productDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setSdate(rs.getString("sdate"));
				dto.setStock(rs.getString("stock"));
				dto.setImage(rs.getString("image"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getProductAll err : " + e);
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
	
	public boolean insertProduct(HttpServletRequest request) {
		boolean b = false;
		//System.out.println(request);
		try {
			//업로드할 이미지 경로(절대 경로)
			String uploadDir = "C:/work/jsou/wproject_shop/src/main/webapp/upload";
			int sizeLimit = 5*1024*1024; //5M
			MultipartRequest multi = new MultipartRequest(request, uploadDir, sizeLimit, "UTF-8",new DefaultFileRenamePolicy());
			//System.out.println(multi.getParameter("name"));
			conn = ds.getConnection();
			String sql = "insert into shop_product(name,price,detail,sdate,stock,image) value(?,?,?,now(),?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("name"));
			pstmt.setString(2, multi.getParameter("price"));
			pstmt.setString(3, multi.getParameter("detail"));
			pstmt.setString(4, multi.getParameter("stock"));
			if(multi.getFilesystemName("image") == null) {
				//상품 등록시 이미지를 선택하지 않은 경우,
				pstmt.setString(5, multi.getParameter("ready.gif"));
			}
			pstmt.setString(5, multi.getFilesystemName("image"));
			if(pstmt.executeUpdate()>0) b = true;
			
		} catch (Exception e) {
			System.out.println("insertProduct err : " + e);
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
	//상품 상세보기
	public productDTO getProduct(String no) {
		productDTO dto = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from shop_product where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new productDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setSdate(rs.getString("sdate"));
				dto.setStock(rs.getString("stock"));
				dto.setImage(rs.getString("image"));
			}
			
		}  catch (Exception e) {
			System.out.println("getProduct err : " + e);
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
}
