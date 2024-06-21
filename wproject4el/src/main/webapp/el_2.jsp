<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <!-- isELIgnored="false" 기본값
    isELIgnored="true" 는 el의 역할을 막는다. 글자 그대로 출력된다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>연산자 / 내장객체</h2>
<h5>연산자</h5>
\${3+4}<br> <!-- ${3+4} -->
${3+4}<br> <!-- 7 -->

\${5/4 }===> ${5/4 } == ${5 div 4 }<br>
\${5%4 } ==> ${5%4 } == ${5 mod 4 }<br>

-- 관계 연산자 --<br>
\${5 > 4} ==> ${5 > 4}, ${5 gt 4}, ${5 lt 4}<br>
\${5 >= 4} ==> ${5 >= 4}, ${5 ge 4}, ${5 le 4}<br>

-- 논리 연산자 --<br>

\${5 > 4 and 3 > 2} ==> ${5 > 4 and 3>2}, ${5 > 4 or 3>2}<br>

-- 삼항 연산자--<br>
\${5 >= 4? 10 :10+5} ==> ${5 >= 4? 10 :10+5}<br>

<h5>내장객체</h5>

<%
request.setAttribute("aa", "air");
session.setAttribute("bb", "burger");
application.setAttribute("cc", "cat");
%>
* 생존 범위 관련 내장 객체 출력*<br>
jsp: <%=request.getAttribute("aa") %> --> El : ${requestScope.aa}, ${aa}<br> <!-- 많이 사용해서 생략도 가능 -->
jsp: <%=session.getAttribute("bb") %> --> El : ${sessionScope.bb}<br>
jsp: <%=application.getAttribute("cc") %> --> El : ${applicationScope.cc}<br>
<br>
jsp의 header : <%=request.getHeader("host") %>
el의 header : ${header.host} , ${header["host"]} <!-- .은 배열이라고 생각하면 된다 -->

<br><br>
**
<h5>컬렉션 객체 값 출력</h5>
<%
ArrayList<String> list = new ArrayList<>();
list.add("치킨버거");
list.add("새우버거");
list.add("불고기버거");
request.setAttribute("list", list);

ArrayList<String> list2 = new ArrayList<>();
list2 = (ArrayList)request.getAttribute("list");
out.println(list2.get(0));
out.println(list2.get(1));
out.println(list2.get(2));
%>
el로 출력 : ${list[0]} + ${list[1]} + ${list[2]}
<br><br>
  ----  html 문서 자료 받기  --<p/>
  <a href="el_2.html">el_2.html 호출</a><br>
이름 :${param.irum} or ${param["irum"]}<br><br>
성격 :${paramValues.sung[0]} + ${paramValues.sung["1"]}

</body>
</html>