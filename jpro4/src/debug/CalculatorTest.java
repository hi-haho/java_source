package debug;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	//Calculator calculator = new Calculator();
	Calculator calculator;
	
	@Before //테스트 전에 초기화하는 경우, 다른 어노테이션보다 먼저되는 어노테이션
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void testPlus() {
		assertTrue(calculator.plus(8, 4) == 12);
//		fail("Not yet implemented");
		
		int a = 8, b = 8;
		assertEquals(a, b); //변수의 값이 같은지 확인
		
		int[] arr = {0,0};
		int arr2[] = new int[2];
		assertArrayEquals(arr, arr2);
	}

	@Ignore
	@Test
	public void testMulti() {
		fail("Not yet implemented");
	}

	@Test(timeout =1000) //1초단위로 수행시간 검사
	public void testDivide() {
		assertTrue(calculator.divide(8, 4)==2);
		//assertTrue(calculator.divide(10, 4)==2.5);
		
//		for (int i = 0; i < 1000000; i++) {
//			System.out.print(i+ " ");
//		}
		
		List<String> list = Arrays.asList("a","b","c");
		Stream<String> listStream = list.stream();
		listStream.forEach(System.out::println);
		
	}

}
