package pack;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ProcessDao dao = ProcessDao.getInstanse();
		try {
/*
			//myBatis framework 사용insData
			System.out.print("sangdata 추가 ");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("바나나");
			dataDto.setSu("5");
			dataDto.setDan("5000")
			dao.insData(dataDto);
;*/		
			/*
			//수정
			System.out.print("sangdata 추가 ");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("바나나우유");
			dataDto.setSu("7");
			dao.upData(dataDto);
			*/
			System.out.println("레코드 삭제");
			boolean b = dao.delData(100);
			
			if(b) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			
			System.out.print("상품 전체 자료 읽기 : ");
			List<DataDto> list = dao.selectDataAll();
			System.out.println(list.size());
			
			for(DataDto s: list) {
				System.out.println(s.getCode() + s.getSang() + s.getSu() + s.getDan());
			}
			System.out.println("---------- ");
			
			DataDto dto = dao.selectPart("1");
			System.out.println(dto.getCode()+ dto.getSang() + dto.getSu() + dto.getDan());
			
		
		}catch (Exception e) {
			System.out.println("err : " + e.getMessage());
		}
		
	}

}
