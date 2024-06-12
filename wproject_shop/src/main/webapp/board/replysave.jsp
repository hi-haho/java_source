<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%> <!-- 아파치 톰켓 10버전에서는 사용안할 수 있다. -->
<jsp:useBean id="bean" class="pack.borad.BoardFormbean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardMgr" class="pack.borad.BoardMgr"></jsp:useBean>

<%
String spage = request.getParameter("page");

int num = bean.getNum();
int gnum = bean.getGnum();
int onum = bean.getOnum() +1; //댓글이기에 +1
int nested = bean.getNested()+1;

//같은 그룹내에서 새로운 댓글의 onum보다 크거나 같은 값을 댓글 입력 전에 먼저 수정하기
//작으면 수정하지 않는다.
boardMgr.updateOnum(gnum, onum); // onum 갱신

//해당 페이지에서 변경된 onum,nested를 저장하는 게 좋다.
bean.setOnum(onum);
bean.setNested(nested);
bean.setBip(request.getRemoteAddr()); //댓글자 ip 받아 저장
bean.setBdate();
bean.setNum(boardMgr.currentMaxNum()+1); //댓글(새글) 번호(num)
//현재 가장 큰 페이지에서 +1을 해줘야한다.
//Error: 1062-23000: Duplicate entry '9' for key 'PRIMARY' : pk err
//댓글 저장
boardMgr.replySave(bean);
response.sendRedirect("boardlist.jsp?page="+spage);
%>