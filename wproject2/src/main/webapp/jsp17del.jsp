<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String code = request.getParameter("code");
%>
<jsp:useBean id="g con" class="w pack.business.ConnPooli" scope="page" />

<%
if(connP.deleteData(code))
	response.sendRedirect("jsp17dbcp.jsp");
else
	response.sendRedirect("jsp17fail.html");
%>