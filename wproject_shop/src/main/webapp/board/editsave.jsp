<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="bean" class="pack.borad.BoardFormbean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardMgr" class="pack.borad.BoardMgr"></jsp:useBean>

<%
String spage = request.getParameter("page");

//비밀번호 확인
boolean b = boardMgr.checkPass(bean.getNum(), bean.getPass());
if(b){
	boardMgr.saveEdit(bean);
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