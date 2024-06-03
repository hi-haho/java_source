package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletBang")
public class ServletBang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void init(ServletConfig config) throws ServletException {
		try {
		Class.forName("org.mariadb.jdbc.Driver");
		String url="jdbc:mariadb://localhost:3306/test";
		conn = DriverManager.getConnection(url,"root","123");
		
		String sql = "insert into guest (name,subject,content) values(?,?,?)"; //선처리방식
		pstmt = conn.prepareStatement(sql);
		
		}catch (Exception e) {
			System.out.println("init err : " + e.getStackTrace());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		try {
			//수신된 자료로 insert 처리 (자료 검증 생략)
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
//			/Timer t = new Timer(true);
			//t.schedule(), null);
			//response.sendRedirect("minibang.html");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>"+name+"님</b> 정상적으로 등록되었습니다.");
			out.println("<br><a href=\"minibang.html\"> 새 글 입력</a>");
			out.println("<br><a href=\"ServletBangList\"> 글 내용 보기</a>");
			out.println("</body></html>");
			out.close();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
		
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
