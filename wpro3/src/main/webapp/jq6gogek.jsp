<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
//sangdata 테이블을 읽어 json형식으로 출력
Connection conn =null;
PreparedStatement pstmt=null;
ResultSet rs =null;

String arg = request.getParameter("arg");

try{	
	Class.forName("org.mariadb.jdbc.Driver");
	String url="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url,"root","123");
	
	String sql = "select gogek_name,gogek_tel from gogek inner join jikwon on jikwon_no=gogek_damsano where jikwon_no=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, arg);
	rs=pstmt.executeQuery();
	
	String result = "";
	while(rs.next()){
		result +="{";
		result +="\"gogek_name\":"+ "\"" +rs.getString("gogek_name")+ "\",";
		result +="\"gogek_tel\":"+ "\"" +rs.getString("gogek_tel")+ "\"";
		result +="},";
	}
	if(result.length()>0){
		result = result.substring(0,result.length() -1);
		//전체길이 -1까지만 취함
	}
	out.print(result);
	
}catch(Exception e){
	System.out.println("err : " + e);
	
}finally{
	try{
		rs.close();
		pstmt.close();
		conn.close();
	}catch(Exception e){
		System.out.println("close : "+e);
	}
}
%>
]