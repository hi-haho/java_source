<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%request.setCharacterEncoding("utf-8");
String  id = request.getParameter("id");
DataDto dto = processDao.selectPart(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
<form action="upok.jsp" method="post">
<input type="hidden" value="<%=dto.getId() %>" name="id">
아이디 : <%=dto.getId() %>
<br>
이름 : <input type="text" value="<%=dto.getName() %>" name="name">
<br>
비밀번호 : <input type="text" name="passwd" value="<%=dto.getPasswd()%>"><br>
<br>
<input type="submit" value="수정">
</form>
</body>
</html>