package pack;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessDao {
	private static ProcessDao dao = new ProcessDao();
	
	public static ProcessDao getInstanse() {
		return dao;
	}
	
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
	public void insData(DataDto dto) throws SQLException{
		SqlSession sqlSession = factory.openSession(); // 트랜젝션 "수동" 처리
		sqlSession.insert("insertData",dto);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void upData(DataDto dto) throws SQLException{
		SqlSession sqlSession = factory.openSession(true); //트랜젝션 "자동"처리
		sqlSession.update("updateData",dto);
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
