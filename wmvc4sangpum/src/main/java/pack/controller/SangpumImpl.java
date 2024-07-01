package pack.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.model.SangpumDto;
import pack.model.SangpumModel;

public class SangpumImpl implements CommandInter {
	//model과 통신하기 위한 controller 영역 내 클래스
	@Override
	public String showDate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SangpumModel sangpumModel = new SangpumModel(); //싱글톤을 써야한다.
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)sangpumModel.selectDataAll();
		request.setAttribute("datas", list);
		return "show.jsp";
	}
}
