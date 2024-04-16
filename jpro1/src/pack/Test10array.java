package pack;

import java.util.Iterator;

public class Test10array {

	public static void main(String[] args) {
		// 배열(array) : 반복처리가 효과적

		int aa; // 기억장소 : 한개 선언 싱글
		// int ar[];// 배열로 선언 == int []ar
		int[] ar = new int[5];
		System.out.println("배열 크기: " + ar.length);
		ar[0] = 10;
		ar[1] = 20;
		ar[4] = ar[0] + ar[1] + ar[2];
		System.out.println(ar[4]);
//		ar[5] =50;
		int a = 4, b = 4;
		System.out.println(ar[4] + " " + ar[a] + " " + ar[b] + " " + ar[1 + 3]);

		System.out.println();
		int[] ar1 = { 1, 2, 3, 4, 5 };
		System.out.println(ar1[0] + " " + ar1.length);
		// 반복문
		for (int i = 0; i < ar1.length; i++) {
			System.out.print(ar1[i] + " ");
		}

		System.out.println("\n향상된 for문");
//		향상된 for : 배열, 컬렉션에서 사용 가능
		for (int i : ar1) { // 타입이 같아야한다. 배열 전체를 돈다.
			System.out.print(i + " ");
		}

		System.out.println();
		String city[] = { "서울", "대전", "제주" };
		for (String lee : city) {
			System.out.print(lee + " ");
		}

		System.out.println("\n=== 배열에 값 저장 후 출력 ===");
		int[] ar2 = new int[5];

		for (int i = 0; i < ar2.length; i++) {
			ar2[i] = i + 10;
		}
		int tot = 0;
		for (int i = 0; i < ar2.length; i++) {
			System.out.println(ar2[i] + " ");
			tot += ar2[i];
		}
		System.out.println("ar 총합: " + tot);

		System.out.println("\n=== 다차원 배열 ===");
		// int[row][column]
//		int au[] = new int[12]; //1차원 배열로 요소 수 12개
		int su[][] = new int[3][4]; // 2차원 배열로 요소 수 12개 //> for문을 2번쓴거라고 이해해보자
		su[0][0] = 100;
		System.out.println(su[0][0]);
		System.out.println("행수: " + su.length + " 열수: " + su[0].length);

		// 2차원 배열 값 저장
		int num = 10;
		for (int i = 0; i < su.length; i++) {
			for (int j = 0; j < su[i].length; j++) {
				su[i][j] = num++;
//				su[i][j] = ++num;
			}
		}
		System.out.println(su[0][0] + " " + su[2][0]);
		for (int i = 0; i < su.length; i++) {
			for (int j = 0; j < su[i].length; j++) {
				System.out.println(su[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---향상된 for문 2차열---");
		for (int[] row : su) {
			for (int ele : row) {
				System.out.print(ele +" ");
			}
			System.out.println( );
		}
		
		System.out.println("\n== 가변 배열 : 행 마다 값의 요소 개수가 다를 수 있다.==");
		int[][] scores = new int [2][];
		scores[0] = new int [2];
		scores[1] = new int [3];
		System.out.println(scores.length +" "+scores[0].length +" "+scores[1].length);
		System.out.println();
		
		int[][] jum = {{90,87},{88,99,100}}; //가변배열의 초기화
		
		for (int i = 0; i < jum.length; i++) {
			for (int j = 0; j < jum[i].length; j++) {
				System.out.print(jum[i][j] + " ");
				
			}
		}
		System.out.println();
		
		for (int[] row : jum) {
			for (int column : row) {
				System.out.println(column + "! ");
			}
		}
		
	}

}
