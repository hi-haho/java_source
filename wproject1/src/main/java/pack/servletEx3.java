package pack;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletEx3")
public class servletEx3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int num=0;
	public void init(ServletConfig config) throws ServletException {
		//웹 서버 서비스가 시작되면 자동 호출.현재 서블릿 클래스의 초기화 담당
		num=1;
		System.out.println("init 수행 num = "+num);
	}
/* 
	//service 메서드가 없으면 get,post 형식으로 나눠진다. 나누고 싶지 않으면 service메서드를 사용하면 된다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get, post 요청(호출)시 매번 수행 (doget, dopost보다 우선순위가 높다.)
		// doget, dopost를 호출 반환 가능
		// jsp 파일은 service 메소드만을 가진 서블릿파일 // jsp는 service안에서 작성한다고 생각하면 된다.
		num +=1;
		System.out.println("service 실행 num = "+num);
		doGet(request, response);
		//doPost(request, response);
	}
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 요청 시 수행
		num +=1;
		System.out.println("get 요청시 실행 num = "+num);
	}

	//405 – 허용되지 않는 메소드 : doPost가 없으면 405에러가 나타난다. 4**에러는 client 잘못이다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 요청 시 수행
		num +=1;
		System.out.println("poet 요청시 실행 num = "+num);
	}

	public void destroy() {
		// 웹 서버 서비스가 종료되면 자동 호출
		// 마무리 작업을 담당한다. close ..등등
		System.out.println("destroy 실행");
	}
}
