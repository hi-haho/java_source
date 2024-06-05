<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession ses= request.getSession(false);
ses.invalidate();
//session.removeAttribute("id"); 특정 session만 지우는 경우

response.sendRedirect("jsp9sessionlogin.html");
%>