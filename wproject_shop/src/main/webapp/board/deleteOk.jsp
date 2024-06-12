<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.borad.BoardMgr"></jsp:useBean>
<%
String num = request.getParameter("num");
String spage = request.getParameter("page");
String pass = request.getParameter("pass");

boolean b = boardMgr.checkPass(Integer.parseInt(num),pass);

if(b){
	boardMgr.delData(num);
	response.sendRedirect("boardlist.jsp?page="+spage);
}else{
	%>
	<script>
		alert('비밀번호 입력');
		history.back();
	</script>
	<%
}
%>