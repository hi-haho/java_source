<%@page import="pack.Gogodan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
** 지금까지 배운 방법 사용 **<br>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println(dan + "단 출력 <br>");

//Gogodan gugudan = new Gogodan();// 클래스의 포함관계 //객체가 요청 수 만큼 생성된다
Gogodan gugudan = Gogodan.getInstance(); // 싱글톤 패턴(포함관계)
int re[] = gugudan.computeGugu(dan);

for(int a = 0; a < 9; a++){
	out.println(dan + " * " + (a + 1) +" = "+re[a] + "&nbsp;&nbsp;");
}
%>
<hr>
** jsp 액션 태그 중 use bean 사용**<br>

<jsp:useBean id="gugu" class="pack.Gogodan" scope="page"/> <!-- Gogodan gugu = new Gogodan() 과 비슷-->
<%--
 Page : 페이지 내에서 지역변수처럼 사용한다. 매번 객체 생성
 Request : http 요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용,매번 객체 생성
 Session : 웹 브라우저 별로 변수가 관리되는 경우 사용, 객체 1회만 생성
 Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용, 객체 1회만 생성
 --%>
<%
int re2[] = gugu.computeGugu(dan);

for(int a = 0; a < 9; a++){
	out.println(dan + " * " + (a + 1) +" = "+re2[a] + "&nbsp;&nbsp;");
}
%>
</body>
</html>