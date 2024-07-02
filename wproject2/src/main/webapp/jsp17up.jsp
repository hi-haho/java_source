<%@page import="pack.controller.SangpumDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
p

String code = request.getParameter("code");
//out.print(code);
%>
<jsp:useBean id="g con" class="w pack.business.ConnPooli" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
SangpumDTO dto = connP.updateData(code);
if(dto == null){
%>
	<script type="text/javascript">
		alert("등록된 상품 코드가 없습니다.\n 수정 불가");
		history.back(); //이 전으로 돌아가는 것
		//location.href="jsp17dbcp.jsp";
	</script>
<%
	return; //사실 이 코드는 만나지 않는다.
}
%>

**상품 수정**
<form action="jsp17upok.jsp" method="post">
코드 : <%=dto.getCode() %><br>
<input type="hidden" name="code" value="<%=dto.getCode() %>"> <!-- 상품명 코드를 읽을 수 있도록 한다. -->
품명 : <input type="text" name="sang" value="<%=dto.getSang() %>"><br>
수량 : <input type="text" name="su" value="<%=dto.getSu() %>"><br>
단가 : <input type="text" name="dan" value="<%=dto.getDan() %>"><br>
<br>
<input type="submit" value="자료 수정">
<input type="button" value="수정 취소" onclick="javascript:location.href='jsp17dbcp.jsp'">
</form>
</body>
</html>