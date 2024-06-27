<%@page import="pack.business.DataDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 상품 목록 (myBatis) **<br>
<%
ArrayList<DataDto> list = (ArrayList<DataDto>)processDao.selectDataAll(); 
/* request.setAttribute("list",list);*/
%>
<a href="ins.html">상품추가</a>
코드를 클릭하면 삭제, 품명을 크릭하면 수정
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	
	<c:forEach var="s" items="<%=list %>">
	<tr>
		<td><a href="delete.jsp?code=${s.code}">${s.code}</a></td>
		<td><a href="update.jsp?code=${s.code }">${s.sang }</a></td>
		<td>${s.su }</td>
		<td>${s.dan }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>