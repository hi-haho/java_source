<!--
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
 아래의 소스 코드를 열어보면 해당 영역 내에 서술된다.
-->

<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<!-- 출력용 자바: jsp(로그인 실패'') , 내부 처리용 자바: 서블릿(로그인) -->
<h1>jsp의 이해</h1>
<% //scriptlet : 자바 코드를 입력할 수 있는 영역
String irum ="한국인"; //지역변수이다. 왜냐하면 service 메소드 내에 선언된 지역변수이기때문이다.
//System.out.println(irum); // 자바 컴의 콘솔로 출력(개발자가 뭔가 출력하고자 할때 사용)
//printWriter 객체 타입의 내장객체 중 하나
out.println(irum + "님의 홈페이지입니다."); //클라이언트 브라우저로 출력
%>
<br>
<%= irum+" : 이렇게 표현식을 사용해 출력할수도 있다. 출력문 1개만 적용 ;적지 않는다." %>
<h1>자바</h1>
<h2>자바</h2>
<h3>자바</h3>
<h4>자바</h4>
<h5>자바</h5>
<h6>자바</h6>
<%
for(int i =1; i<7; i++){
	out.print("<h"+i+">");
	out.print("자바 화이팅");
	out.print("</h"+i+">");
}
%>
현재 자바 KST시간 <%= new Date() %>
<br>
<%
int a=0, sum =0;
do{
	a++;
	sum +=a;
}while(a<10);
%>
<br>
<%=	"10까지의 합은 "+ sum %>
<hr>
<%= irum + "님의 전화번호는 "+ junhwa %>
<%!
//선언
String junhwa = "111-1234";//전역(멤버)변수
%>

<%
/*
//메서드 안에서 메서드는 선언할 수 없다.
public int dataAdd(int su1, int su2){
	return su1 + su2;
}
*/
%>
<%! //클래스 멤버 메서드
public int dataAdd(int su1, int su2){
	return su1 + su2;
}
%>
<br>
<%=dataAdd(10,20) %>
</body>
</html>