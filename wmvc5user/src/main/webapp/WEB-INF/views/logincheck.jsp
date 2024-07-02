<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //액션 태그로 사용하면 코드가 살아있고 지시어로 들어가면 실행 결과가 들어간다.
session = request.getSession(false); // session이 없으면 안만든다.

if(session == null || session.getAttribute("userid") == null){
	//response.sendRedirect("login.html");
	out.println("<script>");
	out.println("alert('로그인 후 목록보기 가능합니다.')");
	out.println("location.href='login.html'");
	out.println("</script>");
	
	return;
}
%>