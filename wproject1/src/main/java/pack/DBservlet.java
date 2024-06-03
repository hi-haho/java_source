package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mariadb.jdbc.client.result.CompleteResult;

@WebServlet("/DBservlet")
public class DBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void init(ServletConfig config) throws ServletException {
		try{
			
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			String sql = "select * from sangdata"; //선처리방식
			pstmt = conn.prepareStatement(sql);
			
			}catch (Exception e) {
				System.out.println("init err : " + e.getStackTrace());
			}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h2> 상품 자료 </h2>");
			
			
			/*
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {
					out.println(rs.getString("code") +" - "+rs.getString("sang")+" - "+ rs.getString("su")+" - "+rs.getString("dan")+"<br>");
					
				}
				} catch (Exception e) {
					// TODO: handle exception
				} */
			try(ResultSet rs = pstmt.executeQuery()) {
				//while(rs.next()) {
					
				//}
			} catch (Exception e) {
				// TODO: handle exception
			}
				out.println("</body></html>");
				out.close();
			} catch (Exception e) {
				System.out.println("service err : "+ e.getStackTrace());
			}
			
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (conn != null) {conn.close();}
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.destroy();
	}

}
