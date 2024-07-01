package pack.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.model.hobbyModel;

//@WebServlet("/hobby.do")
//@WebServlet({"/hobby.do","/hobby2.do","/*.kor"})
public class HobbyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hobbyModel model;
	
	public void init(ServletConfig config) throws ServletException {
		model = new hobbyModel(); //객체 관리를 프로그래머가 한다.
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hobby = request.getParameter("hobby");
		//model을 통해 결과를 얻음
		ArrayList<String> list = model.getHobby(hobby);
		request.setAttribute("datas", list);
		String viewName = "/WEB-INF/views/show.jsp";
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}

}
