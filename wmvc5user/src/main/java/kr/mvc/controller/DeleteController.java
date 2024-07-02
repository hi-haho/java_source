package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class DeleteController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userid = request.getParameter("userid");
		
		UserManager.insetance().deleteData(userid);
		
		//model과 통신
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.m2");
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
