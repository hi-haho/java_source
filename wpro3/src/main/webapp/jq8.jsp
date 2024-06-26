<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//csv 형태로 결과 반환
Connection conn =null;
PreparedStatement pstmt=null;
ResultSet rs =null;

try{	
	Class.forName("org.mariadb.jdbc.Driver");
	String url="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url,"root","123");
	String keyword = request.getParameter("keyword");
	
	String sql = "select jikwon_name from jikwon where jikwon_name like ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,keyword+"%");
	
	rs=pstmt.executeQuery();
	
	ArrayList<String> list = new ArrayList<String>();
	
	while(rs.next()){
		list.add(rs.getString("jikwon_name"));
	}
	out.print(list.size());
	out.print("|");
	for(int i=0 ; i<list.size();i++){
		String data = list.get(i);
		out.print(data);
		if(i<list.size() -1){ //마지막 data에 ,빼기
			out.print(",");
		}
	}
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



//System.out.println("keyword : "+keyword);

%>