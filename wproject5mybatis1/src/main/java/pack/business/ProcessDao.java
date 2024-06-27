package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.business.ProcessDao;
import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession(); //세션(하나의 작업단위) 열기
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		
		return list;
	}
	
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSession = factory.openSession(); //세션(하나의 작업단위) 열기
		DataDto dto = sqlSession.selectOne("selectDataById",para);
		sqlSession.close();
		
		return dto;
	}
	public void insData(Dataform form) throws SQLException{
		SqlSession sqlSession = factory.openSession(); // 트랜젝션 "수동" 처리
		sqlSession.insert("insertData",form);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void upData(Dataform form) throws SQLException{
		SqlSession sqlSession = factory.openSession(true); //트랜젝션 "자동"처리
		sqlSession.update("updateData",form);
		sqlSession.close();
	}
	
	public boolean delData(int para) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		try {
			int cou = sqlSession.delete("deleteData", para);
			if(cou > 0) {
				b=true;
			}
			
		} catch (Exception e) {
			System.out.println(" err : " + e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
}
