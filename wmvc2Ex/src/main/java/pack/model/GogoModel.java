package pack.model;

import java.util.ArrayList;

public class GogoModel {

	public ArrayList<String> getgogo(String num) {
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=1 ; i <10 ; i ++) {
			list.add(num + " * " + i + " = " + (Integer.parseInt(num) * i)+" ");
		}
		return list;
	}
	
}
