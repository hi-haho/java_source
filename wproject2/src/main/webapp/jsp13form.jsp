<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//String name = request.getParameter("name"); //전통적인 방법
%>
<jsp:useBean id="bean" class="pack.business.ExamBean" />
<!-- <jsp:setProperty property="name" name="bean"/> //수신데이터의 양이 적은 경우, 사용 -->

<jsp:setProperty property="*" name="bean" /> <!-- 수신된 값이 자동으로 ExamBean의 멤버 필드에 저장 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
formbean에 등록된 자료 출력하기<br>
이름 : <jsp:getProperty property="name" name="bean" />
국어 : <jsp:getProperty property="kor" name="bean" />
영어 : <jsp:getProperty property="eng" name="bean" />
수학 : <jsp:getProperty property="mat" name="bean" />


<jsp:useBean id="process" class="pack.business.ExamProcess"></jsp:useBean>
<jsp:setProperty property="bean" name="process" value="<%=bean %>"/>
총점은 <jsp:getProperty property="tot" name="process" />
<br>
평균은 <jsp:getProperty property="avg" name="process" />

</body>
</html>