<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//String haha = request.getParameter("msg");
%>

<jsp:useBean id="my" class="pack.business.Para1Class"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Beans 연습 : 빈즈에 값 전달</b>
<%
//우리가 현재까지 알고 있는 기술 사용
//my.setMsg(haha);
//out.println("<br>메세지 출력: "+my.getMsg());
%>
<br>
<!-- String haha = request.getParameter("msg"); 약속이 같은 내부적으로 자동처리된다. -->
<!-- 액션태그 사용 -->
<jsp:setProperty property="msg" name="my"/>
<!-- name이 값은 class, Para1Class의 setter와 getter의 property의 이름이 맞아야  -->
<br> 메세지 출력(action tag 사용) : <jsp:getProperty property="msg" name="my"/>
</body>
</html>