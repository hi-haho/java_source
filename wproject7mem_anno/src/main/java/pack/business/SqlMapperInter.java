package pack.business;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SqlMapperInter { //추상 무조건 있어야하는 메서드!
	//myBatis annotation 사용
	//xml 의존성을 낮춘다. 이 방법이 oop(객체 지향)에 더 가깝다.
	//dataDao도 없어도 된다.
	//configuration.xml : <typeAliases> / <mappers> 가 없다.
	//각 sql문에 매핑된다.
	
	@Select("select * from memberteb")
	List<DataDto> selectDataAll(); //
	
	@Select("select id,name,passwd,reg_date from memberteb where id=#{id}")
	public DataDto selectDatePart(String id);
	
	@Insert("insert into memberteb values(#{id},#{name},#{passwd},now())")
	public int insertData(DataFormBean form);
	
	@Update("update memberteb set name=#{name} where id=#{id}")
	public int updateData(DataFormBean form);
	
	@Delete("delete from memberteb where id=#{id}")
	public int deleteData(String id);
}
