<%@page import="java.util.Base64"%>
<%@page import="java.util.Date"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="javax.servlet.*"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@page import="java.security.Key"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

// 인증(Authentication) : 실제로는 DB 정보를 읽어 확인
String validId = "ok";
String validPassword = "123";

if(id != null && password != null && id.equals(validId) && password.equals(validPassword)){

	//인증이 되면 JWT 생성(비밀키와 서면, 만료시간 등을 설정)
	//생성된 JWT를 클라이언트 스토리지(xss 취약) 또는 쿠키에 저장
	//이후 로그인에 성공하면 성공 페이지로 이동.
	//고정된 비밀키(예제용) 최소 256비트 길이의 비밀키
	//String secretKeyString = "mySuperSecretKey12345678901234567890123456789012";
	//Keys.hmacShaKeyFor() 메서드는 key byte array를 기반으로 적절한 HMAC 알고리즘을 적용한 Key(java.security.Key) 객체를 생성
	//Key secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes());
	
	
	String encodedKey = (String) getServletContext().getAttribute("secretKey");
    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
    Key secretKey = Keys.hmacShaKeyFor(decodedKey);
	
	
	long expirationTime = 3600000; // 1시간(밀리초/ms)
	
	//JWT 생성 : 문자열로 반환되며 인증 및 권한 부여 매커니즘에서 주로 사용
	String jwt = Jwts.builder() //객체 생성
		.setSubject(id). // id, 사용자 식별자, 주제 등이 포함된 클래임 설정
		setIssuedAt(new Date())	// 클래임 내용 중 lat : 발행시간
		.setExpiration(new Date(System.currentTimeMillis()+expirationTime)) //클래임 내용 중 exp : 만료시간
		.signWith(secretKey) //서명 알고리즘, 비밀키 설정(무결성 보장이 목적)
		.compact(); //jwt 생성
	
	//쿠키에 jwt 저장
	Cookie jwtCookie = new Cookie("jwt", jwt);
	jwtCookie.setHttpOnly(true); //HttpOnly : 자바 스크립트에서 쿠키값을 읽어가지 못하도록 설정
	jwtCookie.setPath("/"); // / : 모든 경로 ; 모든 경로에서 쿠키 접근 가능
	response.addCookie(jwtCookie);
	
	//인증에 성공한 경우, 페이지 이동
	response.sendRedirect("jsp10success.jsp"); //html로 만들어도 상관없다.
	
	
}else{
	//인증에 실패한 경우, 페이지 이동
	out.println("<html><body>");
	out.println("<h2>로그인 실패</h2>");
	out.println("<a href='jsp10jwtlogin.html'>다시시도</a>");
	out.println("</body></html>");
}
%>