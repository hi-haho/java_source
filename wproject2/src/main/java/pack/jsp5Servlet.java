package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp5Servlet")
public class jsp5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");
		
		//System.out.println("수신 데이터  : " + data);
		
		//서버가 다른 파일을 호출하는 방법1 : redirect 방식 - client를 통해 server에게 파일 요청
		//response.sendRedirect("aaa.html"); //html을 호출할 경우, 값을 넘길 수 없다.
		//response.sendRedirect("aaa.html?data=" + data); //html은 브라우저에서 파싱한다. 즉, get 방식은 서버사이드에서만 처리하는 것이다. 이런 방식은 의미가 없다.
		//response.sendRedirect("jps5called.jsp?data=" + data); //jsp를 호출한 경우 String값을 넘길 수 있다.
		
		
		
		//서버가 다른 파일을 호출하는 방법2 : forward 방식  - server가 직접 server의 파일을 요청(호출)
		//String을 포함한 다른 객체를 전달할 경우
		request.setAttribute("name",data);
		//request에 이름, 값의 형태로 String 또는 자바의 어떤 객체이든 전달이 가능
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("jps5called.jsp");
		dispatcher.forward(request, response);
		*/
		request.getRequestDispatcher("jps5called.jsp").forward(request, response);
	}

}
