<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>
<%
request.setCharacterEncoding("UTF-8"); //get 방식은 한글 안깨진다.
String id = request.getParameter("id");
boolean b = memberMgr.idcheckProcess(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
</head>
<body style="text-align: center; margin-top: 30px">
<b><%=id %></b>
<%if(b){ //아이디가 있는 경우%>
	 : 이미 사용중인 아이디 입니다.</p>
	 <a href="#" onclick="opener.document.regForm.id.focus();window.close()">닫기</a>
<%}else{%>
	: 사용 가능한 아이디 입니다.</p>
	 <a href="#" onclick="opener.document.regForm.passwd.focus();window.close()">닫기</a>
<%
}
%>
</body>
</html>