package pack4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex29MapTest {

	public static void main(String[] args) {
		// Map류의 HashMap연습: 자료를 키와 값으로 저장, 검색이 편리
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("1", "lee");
		list.put("2", "kim");
		list.put("3", "han");
		list.put("4", "kim");
		list.put("5", "choi");
		
		System.out.println("크기는: "+list.size());
		//키 번호 찾기 (t/f)
		System.out.println(list.containsKey("2")); 
		System.out.println(list.containsKey("7"));
		//값 찾기(t/f)
		System.out.println(list.containsValue("kim"));
		System.out.println(list.containsValue("ho"));
		
		System.out.println();
		
		Set set = list.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.print(ss + ": ");
			System.out.println(list.get(ss));
		}
	}

}
