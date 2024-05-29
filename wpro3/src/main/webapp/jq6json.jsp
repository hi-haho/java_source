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
String bname = request.getParameter("bname");

PreparedStatement pstmt2 = null;
ResultSet rs2 = null;

try{	
	Class.forName("org.mariadb.jdbc.Driver");
	String url="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url,"root","123");
	String sql = "select * from jikwon inner join buser on buser_num=buser_no where buser_name like ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, bname+"%");
	rs=pstmt.executeQuery();
	
	String result = "";
	while(rs.next()){
		result +="{";
		result +="\"jikwon_no\":"+ "\"" +rs.getString("jikwon_no")+ "\",";
		result +="\"jikwon_name\":"+ "\"" +rs.getString("jikwon_name")+ "\",";
		result +="\"jikwon_jik\":"+ "\"" +rs.getString("jikwon_jik")+ "\",";
		//담당 고객수 구하기
		sql = "select count(*) as cou from jikwon inner join gogek on jikwon_no=gogek_damsano where jikwon_no=?";
		pstmt2 = conn.prepareStatement(sql);
		pstmt2.setString(1, rs.getString("jikwon_no"));
		rs2=pstmt2.executeQuery();
		rs2.next();
		result +="\"jikwon_gogek\":"+ "\"" +rs2.getString("cou")+ "\"";
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
		rs2.close();
		pstmt.close();
		pstmt2.close();
		conn.close();
	}catch(Exception e){
		System.out.println("close : "+e);
	}
}
%>
]