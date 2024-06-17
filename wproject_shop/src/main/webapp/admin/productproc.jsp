<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.productMgr"/>

<%
request.setCharacterEncoding("UTF-8");

//controller 역할
String flag = request.getParameter("flag"); //기준값
boolean result = false;

if(flag.equals("insert")){
	result = productMgr.insertProduct(request);
}else if(flag.equals("update")){
	result = productMgr.updateProduct(request);
}else if(flag.equals("delete")){
	result = productMgr.deleteProduct(request.getParameter("no"));
}else{
	response.sendRedirect("productmanager.jsp");
}

if(result){//성공
	%>
	<script type="text/javascript">
		alert('정상처리 되었습니다.');
		location.href="productmanager.jsp";
	</script>
	<%
	
}else{//실패
	%>
	<script type="text/javascript">
	alert('오류발생');
	location.href="productmanager.jsp";
	</script>
	<%
}
%>