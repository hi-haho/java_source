<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>결과보기</h2>
<%
request.setCharacterEncoding("utf-8");
String idkey = (String)session.getAttribute("idkey");
String movie = request.getParameter("movie");
//System.out.println("id : " + id);
//System.out.println("modjfak : " + movie);

if(idkey != null){
%>
<%=idkey %> 님이 선택한 영화는 "<%=movie %>" 입니다.
<br>
세션 아이디 : <%=session.getId() %>
세션 유효시간 : <%=session.getMaxInactiveInterval() %>
<%-- 참고 세션 삭제 : session.invlidate() --%>

<%
}else{
	out.println("세션이 설정되지 않았습니다.");
}

%>
</body>
</html>