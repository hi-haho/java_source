package my;

import java.util.ArrayList;

public class Aa {
	public static void main(String[] args) {
		ArrayList<Shape> list = new ArrayList<>();
		list.add(new Circle());
	    list.add(new Triangle());
	    
	    System.out.println(list.get(0));
	    
	    for(Shape s : list) {
	    	s.draw();
	    }
		
	}
}
