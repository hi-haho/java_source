<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//쿠키에서 jwt를 제거
Cookie jwtCokkie = new Cookie("jwt","");
jwtCokkie.setMaxAge(0);
response.addCookie(jwtCokkie); //cookie에 다시 밀어넣어줘야한다.

response.sendRedirect("jsp10jwtlogin.html");
%>