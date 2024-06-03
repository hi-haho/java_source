<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류</title>
</head>
<body>
현재 jsp문서는 예기치 않은 에러가 발생한 경우 대처용 페이지
<br>
고객님 예상치 못한 오류가 발생했습니다. 잠시만 기다려주세요.
<br>
<%= exception.getMessage() %> <!-- exception 내장 객체 중 하나 -->
</body>
</html>