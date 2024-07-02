<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_3jstl.jsp</title>
</head>
<body>
<pre>
JSTL은 JavaServer Pages "Standard Tag Library"의 약어로, Java 코드를 바로 사용하지 않고 HTML 태그(<>) 형태로 직관적인 코딩을 지원하는 라이브러리.
XML 데이터 처리와 조건문, 반복문, 국제화와 지역화와 같은 일을 처리하기 위한 JSP 태그 라이브러리
자신만의 태그를 추가할 수 있는 기능을 제공합니다.
빠른 개발이 목적이다!
</pre>
<br>
변수, 제어문 사용이 가능. 일반적으로 el과 함께 사용!
<hr>
<h3>** 변수 처리 **</h3>
<c:set var="irum" value="짱구" scope="page"></c:set> <%-- page, request, session, application --%>
이름 : <c:out value="${irum}"/>
<br>
<c:set var="ir" scope="session">
신형만
</c:set>
이름 : <c:out value="${ir}"/>
<br>
<c:remove var="irum"/>
이름 : <c:out value="${irum}"/>
<br>
<c:remove var="ir" scope="session"/>
이름 : <c:out value="${ir}"/>
<br><br>


<c:set var="abc" value="${header['user-Agent']}" scope="page"/>
abc 값은 (현재 사용 중인 브라우저 정보) - <c:out value="${abc}"/>
<c:set var="su1" value="10"/>
<c:set var="su2">
20
</c:set>
두수의 합은 ${su1 + su2}

<hr>
**조건 판단문**
<c:set var="nice" value="star"/>
<c:if test="${nice =='star'}"> <%-- ${nice eq 'star'}--%>
	if 연습 : nice 값은 <c:out value="${nice}"/>
</c:if>

</p>
* 조건 판단문 choose *</p>
<c:choose>
	<c:when test="${nice == 'moon' }">
		달 <c:out value="${nice }"></c:out>
	</c:when>
	<c:when test="${nice == 'star' }">
		별 <c:out value="${nice }"></c:out>
	</c:when>
	<c:otherwise>
		어떠한 조건도 만족하지 않은 경우
	</c:otherwise>
</c:choose>
<br>
<c:choose>
	<c:when test="${empty param.myid}">
		<form> <%-- action 태그 없으면 자신이 받는다 --%>
			아이디 :  <input type="text" name="myid">
			<input type="submit">
		</form>
	</c:when>
	<c:when test="${param.myid == 'haha'}">
		wow!! 
	</c:when>
	<c:when test="${param.myid == 'hoho'}">
		wow!! <c:out value="${param.myid}"/>
	</c:when>
	<c:otherwise>
		환영합니다. 회원 <c:out value="${param.myid }"/> 님
	</c:otherwise>
</c:choose>
<br><hr>
** 반복문 foreach **
연습1 :  
<c:forEach var="i" begin="1" end="10" step="2">
	${i} &emsp;
</c:forEach>
<br>
<c:forEach var="i" begin="1" end="9" step="1">
	${i}단 ====
	<c:forEach var="j" begin="1" end="10" step="1">
		${i} * ${j} &emsp; = ${i * j}<br>
	</c:forEach>
</c:forEach>
<br><br><br>
<hr>
<%
HashMap<String , Object> map = new HashMap<>();
map.put("name", "신짱구");
map.put("today", new Date());
%>
<c:set var="m" value="<%=map %>"/>
<c:forEach var="i" items="${m}">
	${i.key} - ${i.value}<br>
</c:forEach>
<hr>
<br><br><br>
----배열 생성 후 출력--<br>
<c:set var="arr" value="<%=new int[]{1,2,3,4,5} %>"/>
<c:forEach var="a" items="${arr}" begin="2" end="4" step="1">
	${a} &emsp;
</c:forEach>

<hr>
**문자열 분할 후 출력**
<c:forTokens var="animal" items="horse,dog,cat,lion*tiger,pig" delims=",*">
	동물 : ${animal} &emsp;
</c:forTokens>

<hr>
**숫자 및 서식**<br>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
숫자 : <fmt:formatNumber value="12345.678" type="number"/><br>
숫자 : <fmt:formatNumber value="12345.678" type="number" pattern="#,###"/><br> <!-- 숫자형태이다. 연산에 참여한다. -->
숫자 : <fmt:formatNumber value="12345.678" pattern="#,###"/><br>
숫자 : <fmt:formatNumber value="12345.678" type="currency"/><br>
숫자 : <fmt:formatNumber value="12000" pattern="#,###.0"/><br> <!-- 유효한 0을 찍어줌: 0 무효의 숫자는 안찍어준다 : #  -->
숫자 : <fmt:formatNumber value="00345.678" pattern="#,##0.0"/><br>
숫자 : <fmt:formatNumber value="12345.678" pattern="0,000.0"/><br>
숫자 : <fmt:formatNumber value="12" pattern="0,000.0"/><br>
<br>
<fmt:formatNumber value="12345.678" type="number" pattern="#,###"/> + <fmt:formatNumber value="12345.678" type="number" pattern="#,###"/><br>


<br>
<c:set var="now" value="<%=new Date() %>"/>
날짜:<fmt:formatDate value="${now}" type="date"/><br>
시간:<fmt:formatDate value="${now}" type="time"/><br>
모두:<fmt:formatDate value="${now}" type="both"/><br>
모두(형식):<fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일"/><br>















</body>
</html>