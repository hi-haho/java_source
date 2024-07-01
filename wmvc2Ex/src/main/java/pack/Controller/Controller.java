package pack.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.model.GogoModel;
import pack.model.Model;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String viewName="/WEB-INF/views";
	private GogoModel gogoModel;
	private Model model;
	
	public void init(ServletConfig config) throws ServletException {
		gogoModel = new GogoModel();
		model = new Model();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String odds= request.getParameter("num"); //클라이언트 단에서 받았다
		String gogonum= request.getParameter("gogonum");
		
		//구구단 라인
		if(odds ==null) { 
			ArrayList<String> list = gogoModel.getgogo(gogonum);
			request.setAttribute("datas", list);			
			viewName += "/gogo.jsp";
		}
		//홀짝라이
		if(gogonum ==null) {
			request.setAttribute("result", model.getNum(odds));
			viewName += "/test.jsp";
		}
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}

}
