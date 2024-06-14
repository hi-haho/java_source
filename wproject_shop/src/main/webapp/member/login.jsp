<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("idKey");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript">
window.onload=()=>{
	//document.querySelector("#btnLogin").addEventListner('click',funcLogin);
	document.querySelector("#btnLogin").onclick = funcLogin;
	document.querySelector("#btnNewmember").onclick = funcNewMember;
}


</script>
</head>
<body>
<%
if(id != null){ //세션 유(로그인 O)
%>
	<!--
	<b><%=id %></b>님 환영합니다.<p/><br>
	<a href="logout.jsp">로그아웃</a
	-->
	<script type="text/javascript">
		location.href="../guest/guest_index.jsp";
	</script>
	
<%
}else{ //세션 무(로그인 X)
%>
	<form name = "loginForm">
		<table>
			<tr>
				<td>*회원 로그인*</td>
			</tr>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name = "id"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="text" name = "passwd"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" id = "btnLogin" value="로 그 인">
				<input type="button" id = "btnNewmember" value="회 원 가 입">
				</td>
			</tr>
		</table>
	</form>
<%	
}
%>
</body>
</html>