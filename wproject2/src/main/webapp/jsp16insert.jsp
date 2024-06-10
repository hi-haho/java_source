<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 입력 자료를 전송받아 insert하는 로직
request.setCharacterEncoding("UTF-8");
//String sang = request.getParameter("sang"); // 이 코드 대신 formbean 사용
%>
<jsp:useBean id="sangpumBean" class="pack.SangpumBean" />
<jsp:setProperty property="*" name="sangpumBean" />
<%
//수신 데이터 검증 필요..
%>
<jsp:useBean id="connUtil3" class="pack.ConnUtil3" />
<%
connUtil3.insertData(sangpumBean);

// 상품 추가 후 상품 목록보기로 이동
// http://localhost/wproject2/jsp16paging.jsp
response.sendRedirect("jsp16paging.jsp");

// 이때는 포워딩을 하면안된다. 주소가 바뀌지 않아서 같은 요청이 반복적으로 들어간다.
// http://localhost/wproject2/jsp16insert.jsp
// 주의 : 추가, 수정, 삭제 후 목록보기 할 때는 forwarding하지 않는다.
// request.getRequestDispatcher("jsp16paging.jsp").forward(request, response);
%>