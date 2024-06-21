<%@page import="pack.product.productDTO"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr"/> <!-- 클래스 포함관계(jsp 상속 불가) -->
<jsp:useBean id="productMgr" class="pack.product.productMgr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h2>* 주문 상품 정보 *</h2>
<%@ include file="guest_top.jsp"%>
<table>
	<tr style="background-color: #fdb;">
		<th>주문 번호</th><th>상품명</th><th>주문 수</th><th>주문 일자</th><th>주문 상태</th>
	</tr>
<%
String id = (String)session.getAttribute("idKey");
ArrayList<OrderBean> list = orderMgr.getOrder(id); //해당 id 주문만 받아야한다.
if(list.isEmpty()){
	%>
	<tr>
		<td colspan="5" style="text-align: center;"> <%=id %>님, 주문한 상품이 없습니다.</td>
	</tr>
	<%
}else{
	for(OrderBean ord: list){
		productDTO product = productMgr.getProduct(ord.getProduct_no());
	%>
	<tr>
		<td><%=ord.getNo() %></td>
		<td><%=product.getName() %></td>
		<td><%=ord.getQuantity() %></td>
		<td><%=ord.getSdate() %></td>
	<td>
	<%
	switch(ord.getState()){
	case "1":out.println("접수"); break;
	case "2":out.println("입금완료"); break;
	case "3":out.println("배송준비"); break;
	case "4":out.println("배송준비"); break;
	case "5":out.println("처리완료"); break;
	default: out.println("접수중");
	}
	%>
		</td>
	</tr>
	<%
	}
}
%>
</table>
<%@ include file="guest_bottom.jsp"%>
</body>
</html>