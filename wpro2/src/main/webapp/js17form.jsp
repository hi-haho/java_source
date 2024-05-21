<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//자바영역
request.setCharacterEncoding("utf-8");
//html의 각 요소의 name의 값을 가져온다.
String irum = request.getParameter("name");
String id = request.getParameter("id");
//수신된 자료를 자바에서 표준 출력장치로 출력한다.
System.out.println(irum + " " + id);

String email = request.getParameter("email");
String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
console.log(`자바 스크립트 표준 출력장치로 출력<%=irum%>`);
</script>
</head>
<body>
이름은 <%=irum%> 이다.
<%=id %>
<%=email %>
<%=age %>
</body>
</html>