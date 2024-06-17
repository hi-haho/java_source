<%@page import="pack.product.productDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.productMgr"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록보기</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h1>** 도토리 쇼핑몰 **</h1>
<%@ include file="guest_top.jsp"%>
<table>
	<tr>
		<th>상품명</th><th>가격</th><th>재고량</th><th>상세보기</th>
	</tr>
	<%
	ArrayList<productDTO> plist = productMgr.getProductAll();
	for(productDTO p : plist){
	%>
	<tr style="text-align: center;">
		<td>
			<%=p.getName() %>
			<img src="../upload/<%=p.getImage()%>" width="120"/>
		</td>
		<td><%=p.getPrice() %></td>
		<td><%=p.getStock() %></td>
		<td><a href="javascript:productDetail_guest('<%=p.getNo() %>')">보기</a></td>
	</tr>
	<%
	}
	%>
</table>
<%@ include file="guest_bottom.jsp"%>
<form action="productdetail_g.jsp" name="detailFrm">
<input type="hidden" name="no">
</form>
</body>
</html>