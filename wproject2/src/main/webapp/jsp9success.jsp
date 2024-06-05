<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션 읽기
HttpSession ses = request.getSession(false); // 세션 있으면 읽고 안만든다.
if(ses != null && ses.getAttribute("userid") != null){
	String userid = (String)ses.getAttribute("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
<h2> 로그인 성공 </h2>
인증에 성공한 경우 처리할 뭔가를 작업 Autorization(인가)
<p>환영합니다. <%=userid %>님!</p>
인증에 성공한 경우 처리할 뭔가를 작업

<br>
<a href="jsp9logout.jsp">로그아웃</a>
</body>
</html>
<%
}else{
	//로그인 없이 호출된 경우
	response.sendRedirect("jsp9sessionlogin.jsp");
}
%>