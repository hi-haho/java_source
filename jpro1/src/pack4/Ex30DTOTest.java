package pack4;

import java.util.ArrayList;

public class Ex30DTOTest {
	// DTO : getter와 setter만 있는 클래스, 레코드 단위의 기억장소
	ArrayList<Ex30StudentDTO> list = new ArrayList<Ex30StudentDTO>();
	Ex30StudentDTO dto; //레코드 단위 기억장소
	
	// DTO 유추하기
	public void aa() {
		String[] persons = new String[3];
		persons[0] = "홍길동";
		persons[1] = "고길동";
		persons[2] = "신길동";
		
		for(String s:persons) {
			System.out.println(s);
		}
	}
	
	public void insertList() { //레코드(성격(타입)이 다른 모음집) 단위 (DTO)로 학생 정보 입력해 list에 저장
		dto = new Ex30StudentDTO();
		dto.setHacbun("ks1");
		dto.setIrum("손오공");
		dto.setJumsu(90);
		list.add(dto); // 첫번째 학생 자료 list에 등록
		 //dto2로 만들면 안된다. 새로운 객체가 만들어 지는 건 의미가 없다.
		dto = new Ex30StudentDTO();
		dto.setHacbun("ks2");
		dto.setIrum("저팔계");
		dto.setJumsu(50);
		list.add(dto); // 두번째 학생 자료 list에 등록
		
		dto = new Ex30StudentDTO();
		dto.setHacbun("ks3");
		dto.setIrum("사오정");
		dto.setJumsu(80);
		list.add(dto); // 첫번째 학생 자료 list에 등록
		
	}
	
	public void showList() { //List 컬렉션에 저장된 학생 자료 출력
		System.out.println("학생 수는 "+list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(0).getIrum());
		
		System.out.println("------반복문-----");
		
		for (Ex30StudentDTO d : list) {
			System.out.println(d.getHacbun() +"  "+d.getIrum()+"   "+d.getJumsu());
		}
//		for(int i = 0 ; i <list.size(); i++) {
////			Ex30StudentDTO sDTO = list.get(i);
//			
//			Ex30StudentDTO sDTO = new Ex30StudentDTO();
//			sDTO = list.get(i);
//			System.out.println(sDTO.getHacbun() +"  "+sDTO.getIrum()+"   "+sDTO.getJumsu());
//		}
	}

	public static void main(String[] args) {
		Ex30DTOTest dtoTest = new Ex30DTOTest();
		dtoTest.aa();
		System.out.println();
		dtoTest.insertList();
		dtoTest.showList();
	}

}
