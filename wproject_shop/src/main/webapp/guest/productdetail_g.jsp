<%@page import="pack.product.productDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.productMgr" />
<%
String no = request.getParameter("no");

productDTO dto = productMgr.getProduct(no); //특정 번호의 값의 상품을 가져온다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h2>* 상품 상세 보기 *</h2>
<%@ include file="guest_top.jsp"%>
<%if(memid != null){ %> <!-- 로그인 한 경우만 상세보기 보여주기 -->
<form action="cartproc.jsp">
<table>
	<tr>
		<td style="width: 30%">
			<img src="../upload/<%=dto.getImage()%>" width="150"/>
		</td>
		<td style="width: 30%;vertical-align: top">
			<table style="width:100%">
				<tr>
					<td>번호 : <%=dto.getNo() %></td>
				</tr>
				<tr>
					<td>상품명 : <%=dto.getName() %></td>
				</tr>
				<tr>
					<td>가격 : <%=dto.getPrice() %></td>
				</tr>
				<tr>
					<td>등록일 : <%=dto.getSdate() %></td>
				</tr>
				<tr>
					<td>재고량 : <%=dto.getStock() %></td>
				</tr>
				<tr>
					<td>
						주문수량:<input type="number" min="1" name="quantity" value="1" name="quantity" width="3cm" style="text-align: center">
					</td>
				</tr>
			</table>
		</td>
		<td style="vertical-align: top;">
			<h3>상세 설명</h3>
			<%=dto.getDetail() %>
		</td>
	</tr>
	<tr>
		<td colspan="3" style="text-align: center;">
			<br>
			<input type="hidden" name="product_no" value="<%=dto.getNo()%>"/>
			<input type="submit" value="장바구니 담기"/>
			<input type="button" value="이전 페이지로 이동" onclick="history.back()"/>
		</td>
	</tr>
</table>
</form>
<%} %>
<%@ include file="guest_bottom.jsp"%>
</body>
</html>