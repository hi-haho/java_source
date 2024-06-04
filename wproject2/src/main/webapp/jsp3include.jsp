<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jsp3Top.jsp"%>
	<h1>include 연습</h1>
	include 지시어 : 여러 jsp 파일에서 공통 부분을 별도 파일로 작성 후 필요할때 포함해서 사용한다.
	<pre>
 여기는 
     본  문 이  야
	</pre>
	------- include action tag로 파일 포함 결과 출력 영역 --------
	<!-- <jsp:include page="jsp3tag1.jsp"/> : 넘겨줄 데이터가 없는 경우, 사용하면 된다. -->
	<jsp:include page="jsp3tag1.jsp"></jsp:include>
	<!-- 액션태그는 실행을 하고 결과를 가져온다. 동적인 느낌이다.-->
	<br> 무언가를 작업함
	<br>
	<div style="color: green;">
		<jsp:include page="jsp3tag2.jsp">
			<jsp:param value="good" name="msg" />
		</jsp:include>
	</div>

	<hr>
	<%@ include file="js3bottom.jsp"%>
	<!-- 코드를 가지고 와서 실행한다. 보통 머릿글,바닥글은 페이지지시어로 가지고온다. -->
</body>
</html>