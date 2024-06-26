<%@page import="java.util.Map"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr"/>
<jsp:useBean id="productMgr" class="pack.product.productMgr"/>

<%
//Hashtable hCart = cartMgr.getCartList();
//Enumeration enu = hCart.keys();

Hashtable<String, OrderBean> hCart = (Hashtable<String, OrderBean>)cartMgr.getCartList(); //cartlist.jsp

if(hCart.isEmpty()){
	%>
	<script>
	 alert('주문 내역이 없습니다.');
	 location.href="orderlist.jsp";
	</script>
	<%
	}else{
	/*while(enu.hasMoreElements()){
		OrderBean orderBean = (OrderBean)hCart.get(enu.nextElement()); 
		//트랜잭션 처리 대상이 될 수 있다.
		orderMgr.insertOrder(orderBean); //주문 정보DB에 저장
		productMgr.reduceProduct(orderBean);// 주문 수량 만큼 재고량 빼기
		// ---------
		cartMgr.deleterCart(orderBean);*/
		for(Map.Entry<String,OrderBean> entry : hCart.entrySet()){
			OrderBean orderBean = entry.getValue();
			orderMgr.insertOrder(orderBean); //주문 정보DB에 저장
			productMgr.reduceProduct(orderBean); // 주문 수량 만큼 재고량 빼기
			cartMgr.deleteCart(orderBean);		
		}
	%>
	<script>
	 alert('주문이 완료되었습니다.\n 고객님 감사합니다.');
	 location.href="orderlist.jsp";
	</script>
	<%
	}
%>