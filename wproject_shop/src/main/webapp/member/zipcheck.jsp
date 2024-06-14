<%@page import="pack.member.ZipcodeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>
<%
request.setCharacterEncoding("UTF-8");
String check = request.getParameter("check"); // y(입력화면) or n(결과화면)
String dongName = request.getParameter("dongName"); //동 이름

ArrayList<ZipcodeDTO> zlist = memberMgr.zipcodeRead(dongName);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 찾기</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript">
window.onload=()=>{
	document.querySelector("#btnZipFind").onclick=dongCheck;
	document.querySelector("#btnZipClose").onclick=function(){
		window.close();
	}
}

function dongCheck(){
	if(zipForm.dongName.value === ""){
		alert('검색할 동 이름을 입력하세요');
		zipForm.dongName.focus();
		return;
	}
	zipForm.submit();
}

function sendFunc(code,area1,area2,area3,area4){
	//alert(code + area1 + area2 +area3+area4);
	opener.document.regForm.zipcode.value= code;
	const addr = area1 + " " + area2 + " " + area3 + " " + area4;
	opener.document.regForm.address.value= addr;
	window.close();
}
</script>
</head>
<body>
<strong>***우편자료 찾기***</strong>
<form action="zipcheck.jsp" name="zipForm" method="post"> <!-- jsp는 get/post 구분 안한다 -->
	<table>
		<tr>
			<td>
			동 이름 입력 <input type="text" name="dongName">
			<input type="button" value="검색" id="btnZipFind">
			<input type="button" value="창 닫기" id="btnZipClose">
			<input type="hidden" value="n" name="check">
			</td>
		</tr>
	</table>
</form>

<%
if(check.equals("n")){
	if(zlist.isEmpty()){ //자죠를 못 읽은 경우
%>
		<b>검색 결과가 없습니다.</b>
<%
	}else{
%>
		<table>
			<tr>
				<td style="text-align: center;">
				검색 자료를 클릭하면 자동으로 주소가 입력됩니다.
				</td>
			</tr>
			<tr>
				<td>
				<%
				for(int i=0; i < zlist.size(); i++){
					ZipcodeDTO dto = zlist.get(i);
					String zipcode = dto.getZipcode();
					String area1 = dto.getArea1();
					String area2 = dto.getArea2();
					String area3 = dto.getArea3();
					String area4 = dto.getArea4();
					if(area4 == null){
						area4 = "";
					}
					%>
					<a href="javascript:sendFunc('<%=zipcode%>','<%=area1%>','<%=area2%>','<%=area3%>','<%=area4%>')">
					<%=zipcode%> <%=area1%> <%=area2%> <%=area3%> <%=area4%>
					</a>
					<br>
					<%
				}
				%>
				</td>
			</tr>
		</table>
<%	
	}
}
%>
</body>
</html>