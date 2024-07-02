package kr.mvc.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.m2")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModelAndView modelAndView = null;
	private Controller controller = null;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			//파일명을 요청명으로 
			String ss = request.getRequestURI();
			int idx = ss.lastIndexOf('/');
			StringTokenizer st = new StringTokenizer(ss.substring(idx + 1),".");
			ss = st.nextToken();
			// System.out.println("ss : " + ss);//ss : login
			String command = ss;
			
			controller = getController(command); //객체 만들었어
			modelAndView = controller.execute(request, response); //LoginController가 실행
			
			//파일 호출 방식 
			if(modelAndView.isRedirect()) {
				response.sendRedirect(modelAndView.getViewName());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/" + modelAndView.getViewName());
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("service err : " + e.getMessage());
		}
	}
	
	public Controller getController(String command) throws Exception{
		if(command.equals("login")) {
			controller = new LoginController(); //객체 만들게~(프로모션 발생)
		}else if(command.equals("logout")) { //로그아웃
			controller = new logoutController();
		}else if(command.equals("list")) { //목록보기
			controller = new ListController();
		}else if(command.equals("insert")) { //사용자 추가
			controller = new InsertController();
		}else if(command.equals("view")) { // 상세보기
			controller = new ViewController();
		}else if(command.equals("updateform")) {
			controller = new UpdateformController(); //프로모션
		}else if(command.equals("update")) {
			controller = new UpdateController(); //프로모션
		}else if(command.equals("delete")) {
			controller = new DeleteController(); //프로모션
		}
		return controller;
	}

}
