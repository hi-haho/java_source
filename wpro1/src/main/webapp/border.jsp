<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 // 자바 영역
 String irum = request.getParameter("writer"); //클라이언트에서 받는 경우 request
 String jemok = request.getParameter("subject");
 String nai = request.getParameter("age");
 String content = request.getParameter("content");
 
 System.out.println(irum+" "+jemok +" " + nai + " "+content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html 영역 -->
작성자 이름은 <%=irum %> <br>
제목은 <%=jemok %>
</body>
</html>