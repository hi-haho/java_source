package pack4;

import java.util.HashSet;
import java.util.Iterator;

// collection : 다수의 객체를 담을 수 있는 (집합형)자료구조
public class Ex27SetTest {

	public static void main(String[] args) {
		//Set류의 HashSet으로 연습 : 중복 불가, 순서x
		
//		Ex27SetTest test = new Ex27SetTest();
//		HashSet<Ex27SetTest> test = new HashSet<Ex27SetTest>();
		
		HashSet<Object> list = new HashSet<Object>();
//		list.add(1);
//		list.add("lee");
//		System.out.println("크기는: "+list.size());
//		//size는 메서드임. set은 size이다.
//		for (Object obj : list) {
//			System.out.println(obj);
//		}
//		HashSet<Integer> list = new HashSet<Integer>();
//		list.add(1);
//		HashSet<Ex27SetTest> list = new HashSet<Ex27SetTest>();
//		list.add(test);
//		HashSet<String> list = new HashSet<String>();
		list.add("lee");
		list.add("lee"); //순서없고 유니크하다. (값은 유일하게 들어감)
		list.add("lee");
		list.add("park");
		list.add("hong");//더하기
//		list.remove("park"); // 지우기
//		list.clear(); //모두 삭제
		
//		list.add("lee");
		//들어오는 데이터에 제한을 거는 것임
		System.out.println("크기는: "+list.size());
		//size는 메서드임. set은 size이다.
//		for (Object obj : list) {
//			System.out.println(obj);
//		}
		
		System.out.println();
		//Iterator 반복자 : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
		
	}

}
