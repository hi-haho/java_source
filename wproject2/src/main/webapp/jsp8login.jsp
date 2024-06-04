<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    %>

<%
//로그인 성공하면 loginok, 실패하면 loginfail로 이동하는 로직 처리
String id= request.getParameter("id");
String pw= request.getParameter("pw");

if((id.equals("admin") && pw.equals("admin111")) ||(id.equals("user") && pw.equals("000")) ){
	session.setAttribute("id", id); //session 생성
	response.sendRedirect("jsp8loginok.jsp");
	
	//session이 아닌 request를 사용하는 경우는 다음과 같다. 매번 아래와같이 불러야한다. (클라이언트 별로 구분할 수 없다)
	//request.setAttribute("id", id);
	//request.getRequestDispatcher("jsp8loginok.jsp").forward(request, response);
}else{
	response.sendRedirect("jsp8loginfail.jsp");
}

%>