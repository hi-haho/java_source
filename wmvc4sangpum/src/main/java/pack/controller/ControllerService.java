package pack.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class ControllerService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//방법 1 : parameter 사용
		//String command = request.getParameter("command");
		
		//방법 2 : 파일명을 요청으로 사용
		String ss = request.getRequestURI();
		//ss : /wmvc4sangpum/sang.do 
		int idx = ss.lastIndexOf('/');
		StringTokenizer st = new StringTokenizer(ss.substring(idx + 1),".");
		ss = st.nextToken(); // 배열 이동 // ss : sang
		//System.out.println("ss : " + ss);
		
		String command = ss;
		CommandInter inter = null;	// 클라이언트 요청 처리를 인터페이스 사용
		String viewName = "/WEB-INF/views/";
		
		try {
			if(command.equals("sang")) {
				inter = new SangpumImpl();
				viewName += inter.showDate(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("jikwon")){
			
			}else {
				viewName = "error.html"; //WEB-INF(forwarding)에 들어있을 필요 없다.(해당 파일은 server side일 필요없다.)
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.out.println("service err : " + e);
		}
		
	}
}
