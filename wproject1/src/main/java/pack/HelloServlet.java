package pack;

//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloServlet")
@WebServlet( name = "ServletGo",  urlPatterns = {  "/HelloServlet",  "/Hello.kor",  "/dajeong"  },
loadOnStartup = 1 )     // 요청이 없어도, 웹서비스가 시작되면 서블릿 수행

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//HttpServletRequest jsp에도 존재한다. = request.getparameter();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet : URL에 정보가 포함되어 보안에 약함. 기본 호출 메소드.
		System.out.println("get 요청 성공"); //http://localhost/wproject1/HelloServlet
		
		//conn, pstmt.. 연결
		
		//servlet(웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8"); //mime type과 문자코드 //서블릿이 먼저 받아 > 자바야 톰켓받아 > 톰켓 jdk 컴파일시킨후 >servlet이 전달
		PrintWriter out = response.getWriter(); //FileOutputStream > 웹브라우저 출력
		out.println("<html><body>");
		out.println("<h1>서블릿 문서</h1>");
		out.println("안녕!");
		out.println("</body></html>");
		out.close();
	}

}
