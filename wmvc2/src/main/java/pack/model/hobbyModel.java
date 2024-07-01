package pack.model;

import java.util.ArrayList;

public class hobbyModel { //model 영역의 클래스
	
	public ArrayList<String> getHobby(String hobby){
		ArrayList<String> list = new ArrayList<>();
		
		if(hobby.equals("m")) {
			list.add("한라산");
			list.add("설악산");
		}else if(hobby.equals("t")) {
			list.add("부산");
			list.add("제주");
			list.add("인천");
		}else if(hobby.equals("g")) {
			list.add("상추");
			list.add("토마토");
			list.add("블루베리");
		}else if(hobby.equals("r")) {
			list.add("소설");
			list.add("만화");
		}
		return list;
	}
}
