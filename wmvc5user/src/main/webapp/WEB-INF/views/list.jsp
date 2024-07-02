<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 > list보기!</title>
</head>
<body>
<h3> * 사용자 목록 * </h3>
<a href="insert.jsp">사용자 추가</a><br> <!-- redirect 일종이라 생각하자 -->
<table border="1">
	<tr>
		<th>아이디</th><th>이름</th><th>이메일</th>
	</tr>
	<c:forEach var="u" items="${list}">
		<tr>
			<td>${u.userid}</td>
			<td><a href="view.m2?userid=${u.userid}">${u.name}</a></td>
			<td>${u.email}</td>
		</tr>
	</c:forEach>
</table>
<br>
<a href="logout.m2">로그아웃</a>
</body>
</html>