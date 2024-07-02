package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDaoModel;
import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class ViewController implements Controller{ //상세보기 처리

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userid");
		//모델과 통신
		UserDto dto = UserManager.insetance().findUser(id);
		request.setAttribute("user", dto); //"user"란 이름으로 req에 넣은 것
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp");
		modelAndView.setRedirect(false); //포워딩 해야한다. dto를 가져가야한다.
		
		return modelAndView;
	}
}
