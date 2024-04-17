package pack4;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex28ListTest {

	public static void main(String[] args) {
		// List류의 ArrayList 연습: 중복 가능, 순서O
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("lee");
		list.add("lee"); //순서없고 유니크하다. (값은 유일하게 들어감)
		list.add("lee");
		list.add("park");
		list.add("hong");//더하기
//		list.remove("park"); // 지우기
		list.remove(0); //순서가 있기때문에 인덱스로 지울 수 있다. (기수 아니고 서수임)
//		list.clear(); //모두 삭제
		System.out.println("크기는: "+list.size());
		//size는 메서드임. set은 size이다.
		
		for (Object obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		//Iterator 반복자 : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
	}

}
