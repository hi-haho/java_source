package kr.mvc.model;

import java.util.ArrayList;

import kr.mvc.controller.UserForm;

// 여러 개의 DAO 클래스 관리가 목적 //모델 중 관리자
public class UserManager {
	private static UserManager manager = new UserManager();
	
	public static UserManager insetance() { //싱글톤
		return manager;
	}

	private UserDaoModel getUserDaoModel() {
		return new UserDaoModel(); //싱글톤으로 만들어야해
	}
	public boolean login(String user_id, String user_password) {
		UserDto dto = getUserDaoModel().findUser(user_id); //해당 user 찾아와
		if(dto == null) { //해당 유저 없는 경우
			return false;
		}
		
		if(dto.getPassword().equals(user_password)) { //해당 유저와 password 같은 경우
			return true;
		}else { //user와 password 다른경우
			return false;
		}
	}
	
	public ArrayList<UserDto> getUserAll(){
		return getUserDaoModel().getUserDataAll();
	}
	
	public int insert(UserForm userForm) {
		return getUserDaoModel().insertData(userForm);
	}
	
	public UserDto findUser(String userid) {
		return getUserDaoModel().findUser(userid);
	}
	
	public int updateData(UserForm userForm) {
		//System.out.println("1 . userForm : " + userForm);
		return getUserDaoModel().updateData(userForm);
	}
	public void deleteData(String userid) {
		getUserDaoModel().deleteData(userid);
	}
}
