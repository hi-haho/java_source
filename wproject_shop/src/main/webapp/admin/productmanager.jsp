<%@page import="pack.product.productDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.productMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
** 전체 상품관리(관리자)**
<%@ include file="admin_top.jsp"%>
<table>
	<tr style="background-color: #def">
		<th>번호</th><th>상품명</th><th>가격</th><th>등록일</th><th>재고량</th><th>상세보기</th>
	</tr>
	<tr>
	<%
		ArrayList<productDTO> plist= productMgr.getProductAll();
		if(plist.size() == 0){
			%>
			<tr>
				<td colspan="6"> 등록된 상품이 없습니다. </td>
			</tr>
			<%
		}else{
			for(productDTO p : plist){
			%>
			<tr style="text-align: center;">
				<td><%=p.getNo() %></td>
				<td><%=p.getName() %></td>
				<td><%=p.getPrice() %></td>
				<td><%=p.getSdate() %></td>
				<td><%=p.getStock() %></td>
				<td><%=p.getDetail() %></td>
				<td>
					<a href="javascript:productDetail(<%=p.getNo() %>)" class="transition-link">보기</a>
				</td>
			</tr>
			<%
			}
		}
	%>
		<tr>
		<td colspan='6'>
		[ <a href="productinsert.jsp"> 상품등록 </a> ]
		</td>
		</tr>
	</tr>
</table>
<%@ include file="admin_bottom.jsp"%>
<form action="productDetail.jsp" name="detailForm" method="get"><!-- method="get"인 경우, 삭제또한 get 형식으로 전송되어야한다. -->
	<input type="hidden" name="no">
</form>
</body>
</html>