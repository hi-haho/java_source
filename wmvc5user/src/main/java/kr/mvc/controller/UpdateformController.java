package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class UpdateformController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//수정화면 띄우기
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		//모델과 통신
		UserDto dto =  UserManager.insetance().findUser(userid); //수정하기 특정 유저 가져오기
		request.setAttribute("user", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.setRedirect(false);
		
		return modelAndView;
	}
}
