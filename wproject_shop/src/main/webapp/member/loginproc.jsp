<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

boolean b = memberMgr.loginCheck(id,passwd);
if(b){ //해당 아이디와 비밀번호가 있는 경우
	session.setAttribute("idKey", id);
	response.sendRedirect("login.jsp");
}else{ //해당 아이디와 비밀번호가 일치하지 않는 경우
	response.sendRedirect("logfail.html");
}
%>