<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    
    <%
    String id = request.getParameter("id");
    // request/application/session 모두 내장객체이자 컨테이너(데이터가 담길 수 있다.)이다.
    //request.setAttribute("idkey", id); //현재 jsp파일에서만 유효 (느낌 : pravite) - a.jsp가 b.jsp를 부르는 경우, "idkey"를 못찾는다.
    
    //application.setAttribute("idkey", id); // 현재 service 중 모두에게 유효 (느낌 : public) - a.jsp가 b.jsp를 부르는 경우, "idkey"를 찾는다.
    //너무 다방면에서 쓰니깐 잘 사용하지 않는다.
    session.setAttribute("idkey", id);
    // 세션을 참조하는 파일에서만 유효 - 세션id가 달라서(클라이언트의 값마다 분리되어 저장된다.)
    session.setMaxInactiveInterval(10);
    //서버가 클라이언트 컴에 세션 id를 쿠키에 저장해 둔다. 이후 클라이언트가 서버에 정보요청시 sessionID가 담긴 쿠키를 들고간다.
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> * 세션 연습*</h2>
<form action="jsp7session2.jsp">
보고 싶은 영화선택 :  <br>
<input type="radio" name="movie" value="원더랜드" checked="checked">원더랜드
&nbsp;&nbsp;
<input type="radio" name="movie" value="인사이드아웃">인사이드아웃&nbsp;&nbsp;
<input type="radio" name="movie" value="매드맥스">매드맥스&nbsp;&nbsp;
<input type="radio" name="movie" value="원더랜드">원더랜드&nbsp;&nbsp;

<input type="submit" value="결과보기">
</form>
</body>
</html>