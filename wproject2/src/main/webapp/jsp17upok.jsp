<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bean" class="pack.SangpumBean"></jsp:useBean> <!-- 수정된 값 -->
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="connP" class="pack.ConnPooling" scope="page" />

<%
boolean b = connP.updateDataOK(bean);
if(connP.updateDataOK(bean))
	response.sendRedirect("jsp17dbcp.jsp");
else
	response.sendRedirect("jsp17fail.html");
%>