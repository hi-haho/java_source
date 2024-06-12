<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%

session.removeAttribute("adminOk"); //특정 session만 지우는 것
%>
로그아웃 성공
<a href="javascript:window.close()">[ 창닫기 ]</a>
</html>