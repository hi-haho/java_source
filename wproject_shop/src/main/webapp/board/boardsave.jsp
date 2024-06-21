<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="bean" class="pack.borad.BoardFormbean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardMgr" class="pack.borad.BoardMgr"/>
<%
bean.setBip(request.getRemoteAddr()); //client의 ip address가 등록된다.
bean.setBdate();
int newNum =boardMgr.currentMaxNum() + 1; //boardMgr.currentMaxNum() 가장 큰 번호
bean.setNum(newNum);
bean.setGnum(newNum); //해당 그룹num

boardMgr.saveData(bean);
response.sendRedirect("boardlist.jsp?page=1");
%>