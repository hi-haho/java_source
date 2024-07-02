<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="n be" class="w pack.business.SangpumBe"/> <!-- 사실 싱글톤이 아니다. new SangpumBean한 것과 같다. -->
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="g con" class="w pack.business.ConnPooli" />
<%
//out.print(connP.insertData());
boolean b = (boolean)connP.insertData(bean);

if(b) response.sendRedirect("jsp17dbcp.jsp");
else response.sendRedirect("jsp17fail.html");
%>