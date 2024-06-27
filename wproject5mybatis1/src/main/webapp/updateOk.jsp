<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="form" class="pack.business.Dataform"/>
<jsp:setProperty property="*" name="form"/>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>

<% 
processDao.upData(form);
response.sendRedirect("list.jsp");
%>