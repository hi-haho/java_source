<%@page import="java.time.ZoneId"%>
<%@ page
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.time.LocalDate"
import="java.sql.*, java.util.*"
session="true"
buffer="8kb"
autoFlush="true"
isThreadSafe="true"
info="jsp 문서 정보를 기술"
errorPage="jsp2err.jsp"
%>
<!-- 보통 페이지 지시어 위에 적지 않는다.-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 지시어</title>
</head>
<body>
<h2> page 지시어 관련</h2>
페이지 지시어는 jsp 문서의 앞에서 꼭 필요한 것만 적어 준다.
<br><hr>
날짜 출력<br>
<%
LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
int year = localDate.getYear();
int month = localDate.getMonthValue();
int day = localDate.getDayOfMonth();

out.print("오늘은 " + year + "년 "+month+"월 "+day + "일");
%>
<br><!-- info가 보인다. -->
<%=this.getServletInfo() %>
<br>
<%
int num1 = 20; //이 변수는 외부에서 주어지는 값을 기억하기 위함
int num2 = 10;

//만약 num2 = 0 이라고 가정하면 httpt 상태 500에러 (/ by zero)가 나타난다. >> 에러 메세지 대신 jsp 화면을 보여주자.
out.print("나누기 결과 : "+ num1/num2);
%>
</body>
</html>