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

/**
 * Servlet implementation class ServletBangList
 */
@WebServlet("/ServletBangList")
public class ServletBangList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			String sql = "select * from guest order by code desc"; //선처리방식
			pstmt = conn.prepareStatement(sql);
		}catch (Exception e) {
			System.out.println("init err : " + e.getStackTrace());
		}
	}
	//내부적 스레드 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>* 방명록 글 목록*</h2>");
		out.println("<table border='1' width='80%'>");
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				out.println("<tr style='background-color:cyan;'>");
				out.println("<td>번호  : " + rs.getString("code") + "</td>");
				out.println("<td>작성자  : " + rs.getString("name") + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td colspan='2'>제목  : " + rs.getString("subject") + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td colspan='2' height='100' style='word-break:break-all; vertical-align:top;'>내용  : " + rs.getString("content") + "</td>");
				out.println("</tr>");
			}
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
		out.println("</table>");
		out.println("<dev style='text-align: center;'>");
		out.println("<br><a href='minibang.html'>글쓰기</a>");
		out.println("</dev>");
		out.println("</body></html>");
		out.close();
	}

	public void destroy() {
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
