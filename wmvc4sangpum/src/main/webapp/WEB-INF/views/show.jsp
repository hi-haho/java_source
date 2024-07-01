<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공이지롱</title>
</head>
<body>
<h2>*상품 목록(mvc 패턴 사용)*</h2>
<table>
	<tr>
		<th>코드</th><th>상품명</th><th>수량</th><th>단가</th>
	</tr>
	<c:forEach var="s" items="${datas}">
	<tr>
		<td>${s.code }</td>
		<td>${s.sang }</td>
		<td>${s.su }</td>
		<td>${s.dan }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>