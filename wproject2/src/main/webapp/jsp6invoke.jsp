<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 현재 jsp 파일은 비즈니스 로직 처리용으로 출력에는 참여하지 않는다.
String data = request.getParameter("data");
String msg = "Mr. " + data;

//1. redirect 방식으로 파일 호출
// response.sendRedirect("jsp6invoked.jsp?data=" + msg); //클라이언트를 통해서 전달


//2. requestDispatcher 방식으로 파일 호출
//request.setAttribute("data", msg);
application.setAttribute("data",msg);

ArrayList<String> list = new ArrayList<String>();
list.add("mouse");
list.add("pen");
list.add("book");
request.setAttribute("product", list); //request에는 컨테이너의 기능을 가지고있다.

//request.getRequestDispatcher("jsp6invoked.jsp").forward(request, response);

%>
<jsp:forward page="jsp6invoked.jsp"></jsp:forward>