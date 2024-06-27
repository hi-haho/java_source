<%@page import="pack.business.SangpumDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="l connUt" class="w pack.business.ConnUt"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el DB 연결</title>
</head>
<body>
<h2>상품 정보(beans : 전통적방법으로 출력)</h2>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	<%
	ArrayList<SangpumDTO> list = connUtil.getDataAll();
	for(SangpumDTO s : list){
		%>
		<tr>
			<td><%=s.getCode() %></td>
			<td><%=s.getSang() %></td>
			<td><%=s.getSu() %></td>
			<td><%=s.getDan() %></td>
		</tr>
		<%
	}
	%>
</table>

<br><hr><br>
<h2>상품 정보(beans : jstl로 출력)</h2>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%ArrayList<SangpumDTO> list2 = connUtil.getDataAll(); %>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	<c:forEach var="s" items="<%=list2 %>">
		<tr>
			<td>${s.code}</td> <!-- dto부른거아님. getter부른 것이다. -->
			<td>${s.sang}</td>
			<td>${s.su}</td>
			<td>${s.dan}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>