package pack2;

import java.util.Scanner;

public class Ex11Machin {
	private int cupCount;
	private Ex11CoinIn coinIn = new Ex11CoinIn();
	
	public void showData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하세요: ");
		coinIn.setCoin(sc.nextInt());
		System.out.print("몇 잔을 원하세요: ");
		cupCount = sc.nextInt();
//		String result = coinIn.calc(cupCount);
//		System.out.println(result);
		System.out.println(coinIn.calc(cupCount));
		sc.close(); //자원을 쓰고나서 닫아라!!
	}
}
