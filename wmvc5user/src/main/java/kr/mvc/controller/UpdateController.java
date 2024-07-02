package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class UpdateController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userid = request.getParameter("userid");
		//if
		UserForm userForm = new UserForm();
		userForm.setUserid(userid);
		userForm.setPassword(request.getParameter("password"));
		userForm.setName(request.getParameter("name"));
		userForm.setEmail(request.getParameter("email"));
		
		int res = UserManager.insetance().updateData(userForm);
		//System.out.println("res : " + res); // 3
		ModelAndView modelAndView = new ModelAndView();
		if(res > 0) {
			modelAndView.setViewName("list.m2");
			modelAndView.setRedirect(true);
		}else {
			modelAndView.setViewName("list.m2");			
			modelAndView.setRedirect(false);
		}
		//모델과 통신
		return modelAndView;
	}
}
