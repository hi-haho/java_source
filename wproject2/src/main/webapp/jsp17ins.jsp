<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bean" class="pack.SangpumBean"/> <!-- 사실 싱글톤이 아니다. new SangpumBean한 것과 같다. -->
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="connP" class="pack.ConnPooling" />
<%
//out.print(connP.insertData());
boolean b = (boolean)connP.insertData(bean);

if(b) response.sendRedirect("jsp17dbcp.jsp");
else response.sendRedirect("jsp17fail.html");
%>