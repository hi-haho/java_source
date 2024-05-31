package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletEx6Cookie")
public class servletEx6Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //FileOutputStream > 웹브라우저 출력
		out.println("<html><body><head> <meta charset=\"UTF-8\"</head>");
		//쿠키가 있는 경우, 로그인만 상태를 알리고 없다면 로그인 화면을 출현
		String id = null;
		String pwd = null;
		//libraries 파일에 들어가 있음
		try {
			//쿠키는 키이름 : 값 형태로 구성됨
			Cookie[] cookies = request.getCookies();//클라이언트의 모든 쿠키 읽기(모든 쿠키)
			for(int i=0; i < cookies.length; i++) {
			//for(Cookie c : cookies) {
				String name = cookies[i].getName();
				out.println("!!!!name : " + name);
				if(name.equalsIgnoreCase("id")) {
					//쿠키값 디코딩(암호 해제)
					id = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
				if(name.equals("pwd")) {
					//쿠키값 디코딩(암호 해제)
					pwd = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(id !=null && pwd != null) { //id pwd가 있는 경우
			out.println(id + "님 쿠키를 통해 로그인한 상태입니다.");
			out.close();
			return;
		}
		//id pwd가 없는 경우
		out.println("<h2>login</h2>");
		out.println("<form method='post'>");
		out.println("아이디 : <input type='text' name='id'><br>");
		out.println("비밀번호 : <input type='text' name='pwd'><br>");
		out.println("<input type='submit' value='로그인'>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}
	
	//servlet이 만든것 request, response
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//System.out.println(id + " "+pwd);
		
		if(id.equals("aa") && pwd.equals("111")) {
			//쿠키 생성
			try {
				id = URLEncoder.encode(id,"utf-8"); //암호화
				Cookie idCookie = new Cookie("id", id);
				idCookie.setMaxAge(60*60*24*365); //쿠키 유효기간(1년)
				
				pwd = URLEncoder.encode(pwd,"utf-8"); //암호화
				Cookie pwdCookie = new Cookie("pwd", pwd);
				pwdCookie.setMaxAge(60 *60*24*365);
				
				response.addCookie(idCookie);
				response.addCookie(pwdCookie); //client 컴퓨터에 쿠키를 저장
				
				out.println("login success, 쿠키 설정 완료");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			out.println("로그인 실패");
		}
		
		out.println("</body></html>");
		out.close();
	}

}
