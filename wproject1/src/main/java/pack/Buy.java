package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니 가격 합을 구한 후 세션 삭제
		//클라이언트가 넘겨준 쿠키속 세션아이디를 이용해 세션 읽기 (초기에 서버에서 넘길때 다른 아이디를 넘겼다)
		HttpSession session  = request.getSession(false);
		if(session == null) return;
		ArrayList<Goods> glist = (ArrayList<Goods>)session.getAttribute("list");
		
		if(glist == null) return; //Cart가 Buy를 불러야하는데 역주행할 수도 있으니 막아야한다.
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>♡⊙_⊙♡<head> </head>");
		
		out.println("<p><table width='80%'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		int tot = 0;
		//for(Googs s : glist) {}
		for(int i =0; i < glist.size(); i++) {
			Goods goods = (Goods)glist.get(i);
			out.println("<tr><td>"+goods.getName()+"</td>");
			out.println("<td>"+goods.getPrice()+"</td></tr>");
			tot+= goods.getPrice();
		}
		out.println("<tr><td colspan='2'> 총액: "+tot+"</td></tr>");
		//실질 결제는 현실적으로 불구 결제 되었다는 가정
		//결제가 된 후 세션 삭제
		//session.invalidate(); //해당 고객의 모든 세션을 지운 것> 브라우저를 닫기 , 타임아웃, invalidate()
		out.println("</p></table>");
		session.removeAttribute("list"); //해당 고객의 특정 세션만 지운 것
		out.print("<br>결제가 완료되었습니다.");
		out.println("<br>[ <a href='myshop.html'>쇼핑 홈 바로가기</a> ] ");
		out.println("</body></html>");
		out.close();
	}

}
