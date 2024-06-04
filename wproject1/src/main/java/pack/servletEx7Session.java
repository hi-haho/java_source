package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletEx7Session")
public class servletEx7Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//session : 각 클라이언트의 정보를 웹서버에 메모리 확보 후 저장(크기는 동적이다.)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client cookie 속 세션의 아이디를 읽어온다.
		HttpSession session = request.getSession(true); // 세션을 읽고 없으면 세션을 생성
		//HttpSession session = request.getSession(false); //세션을 읽고 없으면 세션을 생성을 안한다.
		session.setMaxInactiveInterval(10); //session 유효시간(초단위) : 60 > 1분 (xml도 만들 수 있음. 지역 세션시간)
		//서버에서 세션을 보내고 연결이 끊기자마자 카운팅이 시작된다.(적대적 1분이 아님)
		//카운팅되다가 서버에 클라이언트가 들어오면 다시 1분 시작 > 로그인 유효시간 카운팅(오른쪽 상단)
		
		//(jsp경우) session.setAttribute("idkey",id);
		//session.getMaxInactiveInterval(10);
		if(session != null) {
			session.setAttribute("name", "홍길동");
			//session id 생성 후 서버뿐아니라 클라이언트 컴퓨터의 cookie에도 저장된다.
			session.setAttribute("id", "hong");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("session id : " + session.getId());
		out.println("<br> 사용자명 : " + session.getAttribute("name"));
		//out.println("session id : " + session.getId());
		out.println("<br>사용자 아이디 : " + session.getAttribute("id"));
		out.println("</body></html>");
		out.close();
	}
		
}
