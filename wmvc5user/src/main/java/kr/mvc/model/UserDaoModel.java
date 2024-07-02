package kr.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.mvc.controller.UserForm;

//controller class의 요청을 받아 DB 연동 처리 담당
public class UserDaoModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDaoModel() {
		
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		SqlSession session = factory.openSession();
		
		try {
			dto = session.selectOne("findUser", userid);
			
		} catch (Exception e) {
			System.out.println("findUser err : " + e.getMessage());
		} finally {
			session.close();
		}
		return dto;
	}
	
	public ArrayList<UserDto> getUserDataAll(){
		List<UserDto> list = null;
		
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("selectDataAll");
			
		} catch (Exception e) {
			System.out.println("getUserAll err : " + e.getMessage());
		} finally {
			session.close();
		}		
		return (ArrayList<UserDto>) list;
		//mybatis는 List를 반환한다.
	}
	
	public int insertData(UserForm userForm) {
		int res = 0;
		SqlSession session = factory.openSession();
		
		try {
			res = session.insert("insertData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertData err : " + e.getMessage());
			session.rollback();
		} finally {
			session.close();
		}	
		return res;
	}
	
	public int updateData(UserForm userForm) {
		int res = 0;
		SqlSession session = factory.openSession();
		
		try {
			//System.out.println("2 . userForm : " +userForm);
			res = session.update("updateData",userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateData err : " + e.getMessage());
			session.rollback();
		} finally {
			session.close();
		}	
		
		return res;
	}
	
	public void deleteData(String userid) {
		SqlSession session = factory.openSession();
		try {
			session.delete("deleteData",userid);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteData err : " + e.getMessage());
			session.rollback();
		} finally {
			session.close();
		}	
	}
}
