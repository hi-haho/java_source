package kr.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class ListController implements Controller {
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<UserDto> list = UserManager.insetance().getUserAll();
		request.setAttribute("list", list);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.jsp");
		modelAndView.setRedirect(false);// list를 가지고 list에 가야한다. forwarding을 해야한다.(request에 객체를 담았잖아.)
		return modelAndView;
	}
}
