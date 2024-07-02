package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class logoutController  implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("userid");
		
		//모델과 통신
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
