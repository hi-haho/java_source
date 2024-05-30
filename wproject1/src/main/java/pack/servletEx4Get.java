package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletEx4Get")
public class servletEx4Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String age = request.getParameter("age"); //int로 못받는다.
		//받은 자료로 Business logic, DB에 등록, .. 등을 수행
		
		//client로 출력
		response.setContentType("text/html;charset=utf-8"); //mime type과 문자코드 //서블릿이 먼저 받아 > 자바야 톰켓받아 > 톰켓 jdk 컴파일시킨후 >servlet이 전달
		PrintWriter out = response.getWriter(); //FileOutputStream > 웹브라우저 출력
		out.println("<html><body>");
		out.println("<h2>get 요청 결과</h2>");
		out.println("이름은 : " + name);
		out.println(" 주소는 : " + addr);
		out.println(" 나이는 : " + age);
		out.println(" 나이대는 : " + calcAge(age));
		out.println("<br><br> <a href='getdata.html'>자료 다시 입력</a>");
		out.println("</body></html>");
		out.close();
	}
	private String calcAge(String age) {
		int imsi = Integer.parseInt(age)/10 *10; //연령대
		String result = "기타";
		switch(imsi) {
		case 20:
			result = "이십대"; break;
		case 30:
			result = "삼십대"; break;
		case 40:
			result = "사십대"; break;
		case 50:
			result = "아저씨"; break;
		}
		return result;
	}
}
