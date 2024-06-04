<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8"); //request : 내장객체
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String[] name  = request.getParameterValues("name");
String job = request.getParameter("job");


if(!(id.equals("aa") && pwd.equals("11"))){
	response.sendRedirect("jsp4member.html"); //response : 내장객체 (sendRedirect : 클라이언트로 재요청이 들어가는 것.)
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>** 성공이야! 전송된 입력 자료 확인해봐! 껄껄 **</p>
<%
out.println("이렇게 여러로직이 있는 경우는 사용할 수 있지만 한줄인 경우, 아래와 같이 사용할 수 있다.");
%>
아이디는 <% out.println(id+"<br>"); %>
비밀번호는 <%=pwd+"<br>" %>
작성자는 <%=name[0]+"<br>" %>
닉네임은 <%=name[1]+"<br>" %>
하는일은 <%=job+"<br>" %>
<hr>
기타정보 <br>
client ip : <%=request.getRemoteAddr() %><br>
client domain : <%=request.getRemoteHost() %><br>
protocol : <%=request.getProtocol() %><br>
method : <%=request.getRemoteAddr() %><br>
server domain : <%=request.getServerName() %><br>
<br>
server buffer size = <%=response.getBufferSize() %><br>
server CharacterEncoding = <%=response.getCharacterEncoding() %><br>
<br>
context path : <%= application.getContextPath() %> <!-- 현재 실행중인 페이지의 외부 환경정보관련 객체 -->
Session : <%= pageContext.getSession() %>
<br>
session, page, config, exception 등의 내장 객체에 해당된다.
</body>
</html>