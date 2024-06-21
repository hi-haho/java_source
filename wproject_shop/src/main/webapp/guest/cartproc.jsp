<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>
<!-- ** scope="session" 세션이 살아있는 동안 카트가 살아있다. ** -->
<jsp:useBean id="order" class="pack.order.OrderBean"/>
<jsp:setProperty property="*" name="order"/>
<%
String orderFlag  = request.getParameter("flag"); //구매목록 보기,수정,삭제 판단용
String id = (String)session.getAttribute("idKey");

if(id == null){ //로그인을 안한 경우
	response.sendRedirect("../member/login.jsp");
}else{
	if(orderFlag == null){//cart에 주문 상품 담기
		order.setId(id); //order : id,quantity,product_no
		cartMgr.addCart(order);
		%>
		<script>
			alert("장바구니에 담았습니다");
			location.href="cartlist.jsp"; //(일반적으로 쇼핑몰 목록으로 이동) 장바구니 목록으로 이동
		</script>
		<%
	}else if(orderFlag.equals("update")){ //문자열 비교는 == 안된다.(js랑 헷갈리지말기)
		order.setId(id);
		cartMgr.updateCart(order);
		%>
		<script>
			alert("장바구니 내용을 수정했습니다.");
			location.href="cartlist.jsp"; //장바구니 목록으로 이동
		</script>
		<%
	}else if(orderFlag.equals("del")){
		cartMgr.deleteCart(order);
		%>
		<script>
			alert("해당 상품의 주문을 삭제했습니다.");
			location.href="cartlist.jsp"; //장바구니 목록으로 이동
		</script>
		<%
	}
}

%>