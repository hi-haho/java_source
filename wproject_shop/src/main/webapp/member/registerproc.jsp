<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %> <!-- 받기 전에 해당 인코딩을 넘겨야한다. -->
<jsp:useBean id="mbean" class="pack.member.MemberBean"/>
<jsp:setProperty property="*" name="mbean"/>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>
<%
boolean b = memberMgr.memberInsert(mbean);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(b){
	out.print("<b>회원가입을 축하합니다.</b>");
	out.print("<a href='login.jsp'>회원 로그인</a>");
}else{
	out.print("<b>회원가입 실패</b>");
	out.print("<a href='register.jsp'>회원가입 페이지로 돌아가기</a>");
}
%>
</body>
</html>