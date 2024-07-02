<%@page import="org.apache.catalina.startup.ConnectorCreateRule"%>
<%@page import="pack.controller.SangpumDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="3 connUti" class="w pack.business.ConnUti"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징</title>
</head>
<body>
<h2>* 상품 정보(페이징) *</h2>
<a href="jsp16insert.html">상품 추가</a>
<br>
<table border="1">
	<tr>
		<td>코드</td><td>상품명</td><td>수량</td><td>단가</td>
	</tr>
	<%
	//페이징 처리를 위해 page 번호 받기
	String pa = request.getParameter("pa");
	if(pa == null){
		pa = "1";
	}
	
	ArrayList<SangpumDTO> list = connUtil3.getDataAll(pa);
	for(int i =0; i <list.size(); i++){
		SangpumDTO dto = list.get(i);
	%>
	<tr>
		<td><%=dto.getCode() %></td>
		<td><%=dto.getSang() %></td>
		<td><%=dto.getSu() %></td>
		<td><%=dto.getDan() %></td>
	</tr>
	<%	
	}	
	//connUtil3.prepareTotalPage(); //전체 페이지 수 출력
	
	%>
	<tr>
		<td colspan="4" style="text-align : center;">
		<%
		if(connUtil3.prepareTotalPage() > 0){
			for(int pageNo=1; pageNo<= connUtil3.prepareTotalPage(); pageNo++){
				%>
				<a href="jsp16paging.jsp?pa=<%=pageNo %>"><%=pageNo %></a> &nbsp;
				<%
			}
		}
		%>
		</td>
	</tr>
</table>

</body>
</html>