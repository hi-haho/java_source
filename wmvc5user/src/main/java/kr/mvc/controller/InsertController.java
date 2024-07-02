package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class InsertController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		UserForm userForm = new UserForm();
		userForm.setUserid(request.getParameter("userid"));
		userForm.setPassword(request.getParameter("password"));
		userForm.setName(request.getParameter("name"));
		userForm.setEmail(request.getParameter("email"));
		
		//모델과 통신
		int res = UserManager.insetance().insert(userForm);
		ModelAndView modelAndView = new ModelAndView();
		if(res > 0) { //추가 성공 > 목록보기
			modelAndView.setViewName("list.m2");
		}else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true); //서블릿을 만나야해(=클라이언트를 통해서 불러야해)
		return modelAndView;
	}
}
