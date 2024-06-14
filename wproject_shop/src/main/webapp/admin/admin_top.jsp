<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//boardcontent.jsp에 있다. (생성했다고 미리 가정)
String adminId = (String)session.getAttribute("adminKey");

if(adminId == null){
	response.sendRedirect("adminlogin.jsp");
	return;
}
%>
<table>
	<tr style="background-color: #abf; text-align: center;">
		<td><a href="../guest/guest_index.jsp">홈페이지</a></td>
		<td><a href="adminlogout.jsp">로그아웃</a></td>
		<td><a href="membermanager.jsp">회원관리</a></td>
		<td><a href="productmanager.jsp">상품관리</a></td>
		<td><a href="ordermanager.jsp">주문관리</a></td>
	</tr>
</table>