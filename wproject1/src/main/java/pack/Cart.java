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

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		/*
		 * 클라이언트에서 해당 캑체를 만들면 세션을 만든다.
		 * 세션을 만들고 나면 리스트를 읽어본다.
		 * 만약 값이없으면 컬렉션을 만든다. 상품이 들어오면 생성자를 통해서 들어간다. 이후 세션을 만든다.
		 * 유효시간안주면 기본 30분간 유지된다.
		 * */
		HttpSession session = request.getSession(true); //session 없으면 생성
		ArrayList<Goods> glist = (ArrayList<Goods>)session.getAttribute("list"); // "list"를 만들어서 배열로 불러온다.
		//하나의 collection을 만들어 객체를 담는다. 객체를 하나의 키값으로 서버에 전달한다.(서버에는 해당 키값으로 저장)
		
		//session.setMaxInactiveInterval(10);
		
		if(glist == null) { //최초의 상품
			glist = new ArrayList<Goods>(); //goods 객체를 담을 glist를 만든다.
		}
		glist.add(new Goods(name,price));
		session.setAttribute("list", glist);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>♡⊙_⊙♡<head> <meta charset=\"UTF-8\"</head>");
		out.println("구입상품: " + name);
		out.println("<br>[ <a href='myshop.html'>계속 쇼핑</a> ] ");
		out.println(" [ <a href='Buy'>결제하기</a> ]<br>");
		out.println("<p><table width='80%'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for(int i =0; i < glist.size(); i++) {
			Goods goods = (Goods)glist.get(i);
			out.println("<tr><td>"+goods.getName()+"</td>");
			out.println("<td>"+goods.getPrice()+"</td></tr>");
		}
		out.println("</p></table>");
		out.println("</body></html>");
		out.close();
	}

}
