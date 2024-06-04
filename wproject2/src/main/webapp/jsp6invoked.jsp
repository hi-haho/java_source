<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서버(jsp6invok.jsp)가 넘겨준 자료 출력</h2>
<h4>redirect 방식</h4>
<%
String data = request.getParameter("data");
out.println("전송된 데이터는 " + data);
%>

<h4>* forward 방식 *</h4>
<%
// String ourdata = (String)request.getAttribute("data");
//out.println("전송된 데이터 " + ourdata);
// ----
//String ourdata = (String)request.getAttribute("product");
ArrayList<String> plist = (ArrayList<String>)request.getAttribute("product");
for(String p : plist){
	out.println(p);
}
%>

</body>
</html>