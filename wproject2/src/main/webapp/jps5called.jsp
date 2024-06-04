<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버에 의해 호출(servlet이 호출)된 파일<br>
<h4>* redirect 방식 *</h4>
<%
String mydata = request.getParameter("data");
out.println("전송된 데이터 " + mydata);
%>


<h4>* forward 방식 *</h4>
<%
String ourdata = (String)request.getAttribute("name");
out.println("전송된 데이터 " + ourdata);
%>
</body>
</html>