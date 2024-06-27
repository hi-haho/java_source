<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%
String code = request.getParameter("code");
DataDto dto = processDao.selectPart(code);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
** 상품 수정 ** <br>
<form action="updateOk.jsp" method="post">
	<input type="hidden" name="code" value="<%=dto.getCode()%>">
	코드: <%=dto.getCode()%><br>
	상품: <input type="text" name="sang"  value="<%=dto.getSang()%>"><br>
	수량: <input type="text" name="su" value="<%=dto.getSu()%>"><br>
	단가: <input type="text" name="dan"  value="<%=dto.getDan()%>"><br>
	<br>
	<input type="submit" value="수정하기">
	<input type="button" onclick="history.back()" value="이전">
	
</form>
</body>
</html>