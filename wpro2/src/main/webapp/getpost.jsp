<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% //html 파일에서 받아온다. fName 확인
String irum = request.getParameter("name");
String nai = request.getParameter("age");
%>

<%=irum + "님의 나이는 "+ nai+"살" %>
