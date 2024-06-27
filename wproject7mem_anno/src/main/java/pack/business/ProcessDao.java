package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.business.ProcessDao;
import pack.mybatis.SqlMapConfig;

public class ProcessDao implements ProcessInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<DataDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<DataDto> list = null;
		
		try {
			SqlMapperInter inter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = inter.selectDataAll();
			
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	@Override
	public DataDto selectPart(String id) {
		SqlSession sqlSession = factory.openSession();
		DataDto dto = null;
		try {
			SqlMapperInter inter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			dto = inter.selectDatePart(id);
			
		} catch (Exception e) {
			System.out.println("selectPart err : " + e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return dto;
	}
	
	@Override
	public boolean insertData(DataFormBean form) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			SqlMapperInter inter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			if(inter.insertData(form)>0) {
				
				b = true;
				sqlSession.commit();
			}
		} catch (Exception e) {
			System.out.println("insertData err : " + e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return b;
	}
	@Override
	public boolean updateData(DataFormBean form) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		try {
			SqlMapperInter inter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			//비밀번호 비교후 수정 여부를 판단
			DataDto dto = inter.selectDatePart(form.getId());
			if((form.getPasswd()).equals(dto.getPasswd())) {
				//수정 처리
				if(inter.updateData(form)>0) {
					 b = true;
					sqlSession.commit();
				}
			}
			
		} catch (Exception e) {
			System.out.println("updateData err : " + e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
	@Override
	public boolean deleteData(String id) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		SqlMapperInter inter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
		try {
			int cou = inter.deleteData(id);
			if(cou>0) {
				b = true;
				sqlSession.commit();
			}
		} catch (Exception e) {
			System.out.println("deleteData err : " + e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
}
