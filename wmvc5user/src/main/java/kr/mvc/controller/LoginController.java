package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.mvc.model.UserManager;

public class LoginController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		
		//모델(비즈니스 모델)과 통신
		UserManager manager = UserManager.insetance();
		boolean b = manager.login(id, pwd);
		
		ModelAndView modelAndView = new ModelAndView(); //객체 만들어
		if(b) {//로그인 성공 (그럼 세션 만들어줄게)
			HttpSession session = request.getSession(true); //없으면 만들고 있으면 사용해
			session.setAttribute("userid", id);
			modelAndView.setViewName("list.m2");
			//클라이언트에게 세션id를 가지고 갔다가 와야하기때문에 redirect를 사용해야한다.
			//세션인 경우에는 
		}else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
