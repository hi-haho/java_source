<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

// 인증(Authentication) : 실제로는 DB 정보를 읽어 확인
String validId = "ok";
String validPassword = "123";

if(id != null && password != null && id.equals(validId) && password.equals(validPassword)){
	//인증이 유효한 경우, 새션 생성
	HttpSession ses= request.getSession();
	ses.setAttribute("userid", id); //세션 생성 후 session id를 클라이언트 컴(쿠키)에 보낸다.
	
	//인증에 성공한 경우, 페이지 이동
	response.sendRedirect("jsp9success.jsp"); //html로 만들어도 상관없다.
	
	
}else{
	//인증에 실패한 경우, 페이지 이동
	out.println("<html><body>");
	out.println("<h2>로그인 실패</h2>");
	out.println("<a href='jsp9sessionlogin.html'>다시시도</a>");
	out.println("</body></html>");
}
%>