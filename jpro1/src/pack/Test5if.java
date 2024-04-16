package pack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test5if {

	public static void main(String[] args) {
		/*
		 * int num = 35; String msg = "";
		 * 
		 * if (num >= 90) { msg = "수"; } else if (num >= 80) { msg = "우"; } else if (num
		 * >= 70) { msg = "미"; } else if (num >= 60) { msg = "양"; } else if (num >= 50)
		 * { msg = "가"; } else { msg = "재시험"; } System.out.println("평가 결과: " + msg);
		 * 
		 * System.out.println(); // 입장료: 8세 이하 65세 이상 무료 // 9세 이상 20세 미만 3000원 // 20세 이상
		 * 65세 미만 5000원
		 * 
		 * int age = 30;
		 * 
		 * if (8 >= age || age >= 65) { System.out.println("무료"); } else if (9 <= age &&
		 * age < 20) { System.out.println("3000"); } else { System.out.println("5000");
		 * }
		 * 
		 * System.out.println("========"); age = 20; int total = 0; if (9 <= age && age
		 * < 20) { total = 3000; } else if (20 <= age && age < 65) { total = 5000; }
		 * System.out.println("가격은" + total + "원 입니다.");
		 */
		System.out.println();
		// 문제 : 키보드로 상품명, 수량, 단가를 각각 입력받아 금액(수량*단가)을 출력
//		조건: 금액이 5만원 이상이면 금액에 10%를 아니면 금액에 5%를 세금으로 출력
//		출력 모양은 상품명 : *** 금액 *** 세금:***

		Scanner sc = new Scanner(System.in);
		String name = "";
		int price = 0; // 가격
		int quan = 0; // 수량

		System.out.print("상품명을 입력하세요: ");
		name = sc.nextLine();

		System.out.print("수량을 입력하세요: ");
		quan = sc.nextInt();
		sc.nextLine();

		System.out.print("가격을 입력하세요: ");
		price = sc.nextInt();

		double t = 0;// 세금
//		지역변수는 초기화를 해야하는데 출력 전에 값을 주지않으면 에러남
//		즉, 모든 경우에 값이 들어가면 오류가 안됨.
		if ((quan * price) >= 50000) { // 금액이 50000원 이상인 경우
			t = (quan * price) * 0.1;
		} else {// 금액이 50000원 이하인 경우
			t = (quan * price) * 0.05;
		}
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("상품명: " + name + " 금액: " + df.format(quan * price) + "원 세금: " + df.format(t) + "원");
		
	}

}
