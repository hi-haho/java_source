package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jumsu")
public class jumsu extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor")); //국어 점수
		int eng = Integer.parseInt(request.getParameter("eng")); //영어 점수
		
		/*Session*/
		HttpSession session = request.getSession(true); //세션이 없는 경우 생성
		ArrayList<Students> jumlist = (ArrayList<Students>)session.getAttribute("list"); // "list"를 만들어서 배열로 불러온다.
		
		if(jumlist == null) { //최초에 사람
			jumlist = new ArrayList<Students>(); //해당 collection 생성
		}
		for (int i = 0; i < jumlist.size(); i++) {
			if(num.equals(jumlist.get(i).getNum())){
				System.out.println("있습니다.");
				response.sendRedirect("../wproject1/student_jum.html");
				return;
			}
		}
		jumlist.add(new Students(num,name,kor,eng)); //Students 객체 생성 후 jumlist에 추가
		session.setAttribute("list", jumlist); // 새션 추가
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><style type=\"text/css\"> th,td{text-align: center;}</style><body>");
		out.println("<h2>학생들 성적표</h2>");
		out.println("<p><table width='80%'>");
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		for(int i =0; i < jumlist.size(); i++) {
			Students goods = (Students)jumlist.get(i);
			out.println("<tr><td>"+goods.getNum()+"</td>");
			out.println("<td>"+goods.getName()+"</td>");
			out.println("<td>"+goods.getKor()+"</td>");
			out.println("<td>"+goods.getEng()+"</td>");
			out.println("<td>" +(goods.getKor()+goods.getEng())+"</td></tr>");
		}
		//인원수
		out.println("<br><tr><td colspan='5'> 인원수: "+jumlist.size()+" 명</td></tr>");
		out.println("</table></p><br><br>");
		//
		out.println("<a href=\"javascript:history.back();\">새로입력</a> ");
		out.println(" <a href='clear'>세션 삭제</a>");
		out.println("</body></html>");
	}


}