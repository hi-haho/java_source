package pack.business;

import java.util.List;

public interface ProcessInter { //인터페이스를 만들고 추상으로 사용
	List<DataDto> selectDataAll();
	DataDto selectPart(String para);
	boolean insertData(DataFormBean form);
	boolean updateData(DataFormBean form);
	boolean deleteData(String id);
}
