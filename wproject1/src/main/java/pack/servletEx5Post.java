package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post.do")
public class servletEx5Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //수신 자료 한글 깨짐 방지

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //FileOutputStream > 웹브라우저 출력
		out.println("<html><body>");
		out.println("<h2>get 요청 결과</h2>");
		String irum = request.getParameter("name");
		String []juso = request.getParameterValues("addr"); // 매개변수 중복 > 배열처리
		out.println("이름은 : " + irum + "주소 : " + juso[0]+ juso[1]);
		//checked box
		try {
			String sports[] = request.getParameterValues("sports");
			out.println("<br><br>선택한 종목은 ");
			for(String s : sports) {
				out.print( s + ", ");
			}
			
		} catch (Exception e) {
			out.println("<br><br>종목 하나 이상을 선택하는 것을 추천합니다.");
			return;
		}
		
		// radio button
		String language = request.getParameter("lan");
		out.println("<br>자신있는 언어는 " + language);
		
		//select
		String tr = request.getParameter("tr");
		out.println("<br>교통수단은 " + tr);
		
		//hidden
		String edu = request.getParameter("edu");
		out.println("<br>교육은 " + edu);
		
		out.println("<br><br> <a href='postdata.html'>자료 다시 입력</a>");
		out.println("</body></html>");
		out.close();
	}

}
