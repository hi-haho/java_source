package kr.mvc.controller;
// Controller가 처리한 결과 데이터와 뷰에 대한 정보를 담는 객체
public class ModelAndView {
	private boolean isRedirect = false; //스프링은 포워드가 기본
	private String viewName = "";
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}	
}
