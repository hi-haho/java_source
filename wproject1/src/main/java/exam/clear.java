package exam;

import java.io.IOException;
//import java.util.ArrayList;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/clear")
public class clear extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 삭제하기
		HttpSession session = request.getSession(false);
		if(session == null) return;
		//ArrayList<Students> jumlist = (ArrayList<Students>)session.getAttribute("list"); // "list"배열 호출
		
		//세션 삭제
		session.removeAttribute("list");
		
		//PrintWriter out = response.getWriter();
		//돌아가기
		response.sendRedirect("../wproject1/student_jum.html");
	}

}
