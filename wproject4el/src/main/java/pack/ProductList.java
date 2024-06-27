package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("스페셜 티블렌드",5000.0,"시원하다  대박", new Date()));
		products.add(new Product("스페셜 호호",5000.0,"달다 대박", new Date()));
		products.add(new Product("춘식이",5000.0,"달달하다 대박", new Date()));
		products.add(new Product("곤약젤리",5000.0,"고소 대박", new Date()));
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pshow.jsp").forward(request, response);
	}

}
