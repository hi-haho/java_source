package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.other.ServletEx2Other;

@WebServlet("/servletEx2")
public class servletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletEx2Other other;
	// 서버는 init() 메소드를 호출해서 Servlet을  초기화 합니다.(생성자와는 다르다.)
	public void init(ServletConfig config) throws ServletException {
		//최초의 요청만 받는다. 싱글톤......?
		 other = new ServletEx2Other("고길동");
		 //최조의 요청자만 만나는 메서드. 다음 요청자는 doGet()을 만난다.
		 //doGet()에서 인스턴스를 만난다.
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8"); //mime type과 문자코드 //서블릿이 먼저 받아 > 자바야 톰켓받아 > 톰켓 jdk 컴파일시킨후 >servlet이 전달
		PrintWriter out = response.getWriter(); //FileOutputStream > 웹브라우저 출력
		out.println("<html><body>");
		out.println("<h1>서블릿 Ex2 문서</h1>");
		//지역변수 출력
		int a = 10, b=20;
		out.println("a: "+a+" b : "+b);
		
		// 현재 클래스의method 호출
		int tot = calc(a,b);
		out.println("a: "+a+" b : "+b +"<br> tot(두 수의 합) : " + tot+"<br>");
		
		//외부 클래스 호출
		//ServletEx2Other other = new ServletEx2Other("홍길동");
		//요청이 들어올때마다 인스턴스된다. 힙 메모리 오버헤드로 죽어버린다. (init 존재 이유)
		String ir = other.getIrum(); 
		out.println("이름은 " + ir);
		out.println("</body></html>");
		out.close();
	}

	private int calc(int a, int b) {
		int imsi =a+b;
		return imsi;
	}
}
