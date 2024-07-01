package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GoMVC")
public class GoMVC extends HttpServlet { //controller 역할
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String result ="", viewName="/WEB-INF/";
		String name;
		
		try {
			name = request.getParameter("name");
			
		} catch (Exception e) {
			name = null;
		}
		//클라이언트의 요청을 받아 분석(판단) : 모델과 뷰를 선택하는 기능 기술
		if(name == null || name.equals("")) {
			result = "환영합니다"; // model(business logic)을 수행한 결과라 가정
			viewName += "views/view1.jsp";
		}else if(name.equals("korea")){
			result = "한국인이시군요. 환영합니다";
			viewName += "views/view2.jsp";
		}else {
			result =name+ "님 환영합니다";
			viewName += "views/view3.jsp";
		}
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
