<%@page import="pack.product.productDTO"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="orderMgr" class="pack.order.OrderMgr"/>
<jsp:useBean id="productMgr" class="pack.product.productMgr"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h2>** 주문관리 **</h2>
<%@ include file="admin_top.jsp"%>
<table>
	<tr style="background-color: #def">
	<th>주문 번호</th><th>주문ID</th><th>상품명</th><th>주문수량</th><th>주문일</th><th>주문 상태</th><th>보기</th>
	</tr>
	<tr>
	<%
		ArrayList<OrderBean> list = orderMgr.getOrderAll();
		if(list.size() == 0 ){
			%>
			<tr>
				<td colspan="7"> 주문 내역이 없습니다.</td>
			</tr>
			<% 
		}else{
			for(int i = 0; i <list.size(); i++){
				OrderBean order = (OrderBean)list.get(i);
				productDTO product = productMgr.getProduct(order.getProduct_no());
			%>
			<tr>
				<td><%=order.getNo() %></td>
				<td><%=order.getId() %></td>
				<td><%=product.getName() %></td>
				<td><%=order.getQuantity() %></td>
				<td><%=order.getSdate() %></td>
			<td>
			<%
				switch(order.getState()){
					case "1":out.println("접수"); break;
					case "2":out.println("입금완료"); break;
					case "3":out.println("배송준비"); break;
					case "4":out.println("배송준비"); break;
					case "5":out.println("처리완료"); break;
					default: out.println("접수중");
				}
		
		%>
			<td>
				<a href="javascript:orderDetail('<%=order.getNo() %>')">상세보기</a>
			</td>
			</tr>
		<%
				}
			}
		%>
	</tr>
</table>
<%@ include file="admin_bottom.jsp"%>
<form action="orderdetail.jsp"name="detailFrm" method="post">
	<input type="hidden" name="no">
</form>
</body>
</html>