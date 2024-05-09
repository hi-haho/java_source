package my;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream_ex {
	public Stream_ex() {
		ex1();
	}
	
	private void ex1() {
		String[] strArr = {"a","b","c"};
		List<String> strList = Arrays.asList(strArr);
		
		Stream<String> strStream1 = strList.stream();
		Stream<String> strStream2 = Arrays.stream(strArr);
		
		
	}
}
