package pack;

import java.util.Iterator;
import java.util.Scanner;

public class Test7For {

	public static void main(String[] args) {
		// 반복문 for
		// for(초기치;조건;증감){반복 처리 구간}
		// 변수가 변하면 조건 체크
		// int a 는 지역변수 >최대한 지역변수로 만들어야한다.
		// 전역으로 하면 단위 내에서만 만들어야한다. 자원의 재활용!
		// 메모리도 누수가 발생한다.
		int a;
		int sum = 0; // 누적 기억장소

		for (a = 1; a <= 5; a++) {
			System.out.println("a: " + a);
			sum += a;
			// 반복문 안에서 변수를 정의하지말자. 예상하지 못한 값이 나온다.
		}
		System.out.println("반복문 수행 후 a: " + a);
		System.out.println("반복문 수행 후 sum: " + sum);

		System.out.println();

		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 10; i > 0; i -= 2) {
			System.out.print(i + " ");
		}
		System.out.println();
		int aa = 1;
		for (; aa <= 5; aa++) {
			System.out.print(aa + ",");
		}

		System.out.println("\n\n다중 for");
		for (int m = 0; m <= 3; m++) {
			System.out.println("m= " + m);
			for (int n = 1; n < 4; n++) {
				System.out.print(" n: " + n + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (char i = 65; i <= 90; i++) {
			System.out.print(i + ":");
			for (char j = i; j <= 'Z'; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		// 구구단
//		System.out.println();
//		for (int i = 1; i < 10; i++) {
//			System.out.println("====="+i+"단=====");
//			for (int j = 1; j < 10; j++) {
//				System.out.println(i+" * "+j+ " = "+ i*j);
//			}
//		}
		// 키보드로 숫자를 받아 구구단 출력
		// 예) 몇단 ? 3
		// 결과 3*1 = 3 ..옆으로 찍기
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단? ");
		int num = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.print(num + "*" + i + "=" + (num * i) +" ");
		}
		System.out.println();
		// 1~100 사이의 정수 중 3의 배수이면서 5의 배수의 갯수와 그 합을 출력
		System.out.println("=========");
		int number = 0; // 갯수
		int total = 0;
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
//				System.out.println(i);
				number++;
				total += i;
			}
		}
		System.out.println("갯수: "+number+" 합: "+total );

		// 2~9단까지 출력

		System.out.println();
		for (int i = 2; i < 10; i++) {
			System.out.println("====="+i+"단=====");
			for (int j = 1; j < 10; j++) {
				System.out.println(i+" * "+j+ " = "+ i*j);
			}
		}

	}

}
