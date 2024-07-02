<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="n be" class="w pack.business.SangpumBe"></jsp:useBean> <!-- 수정된 값 -->
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="g con" class="w pack.business.ConnPooli" scope="page" />

<%
boolean b = connP.updateDataOK(bean);
if(connP.updateDataOK(bean))
	response.sendRedirect("jsp17dbcp.jsp");
else
	response.sendRedirect("jsp17fail.html");
%>