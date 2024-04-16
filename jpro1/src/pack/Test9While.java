package pack;

import java.util.Scanner;

public class Test9While {
	public static void main(String[] args) {
//		int w = 0;
//
//		while (true) {
//			w++;
//			if (w == 5)
//				break;
//			if (w == 3)
//				continue;
//			System.out.println(" w는 " + w);
//		}
//
//		System.out.println("==========");
////		factorial
////		Scanner scanner = new Scanner(System.in);
//		System.out.print("정수 입력: ");
////		int  number = scanner.nextInt();
//		int number = 5;
//
////		factorial 계산 초기값 설정
//		int factorial = 1;
//		int i = 1; // 반복을 위한 counter
//		while (i <= number) {
////			System.out.println(i);
//			factorial *= i;
//			i++;
//		}
//		System.out.printf("number는 %d factorial은 %d", number, factorial);
//
//		System.out.println("\n-- 다중 while --");
//		int a = 1;
//		while (a <= 3) {
//			System.out.println("a: " + a);
//			int b = 1;
//			while (b <= 4) {
//				System.out.print("b:" + b + " ");
//				b++;
//			}
//			a++;
			System.out.println();
//		}
		System.out.println();
//		키보드로 입력받은 숫자에 대해 1부터 시작해 그 숫자까지 모든 수에
//		나누기를 시도하고 나누어 떨어지는 경우(약수) 그 수를 출력한다.
//		0이나 음수를 입력하면 프로그램을 종료
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.print("정수 입력: ");
//			int num = sc.nextInt();
//			if (num <=0) {
//				System.out.println("프로그램 종료");
//				break; //break는 반복문을 벗어나는 것임.
//			}
//			System.out.println(num+"의 약수는 ");
//			int divisor = 1; //약수를 찾기 위해 1부터 시작
//			while (divisor <= num) {
//				if (num % divisor == 0) {
//					System.out.println(divisor); //약수 출력
//				}
//				divisor++; //다음 수로 이동
//			}
//			
//		}
//
//		// do-while
//		int k = 1;
//		do { // 무조건 실행시키는
//			System.out.println("k: " + k);
//			k = k + 1;
//		} while (k <= 5);
//
//		System.out.println("----문----제-----");
//		// 문1) 1 -10 사이의 정수 중 3의 배수이지만 2의 배수가 아닌 수를 출력하고,
//		// 합과 개수도 출력하라
//
//		int m = 1, tot = 0, su = 0;
//		while (m <= 100) {
//			if (m % 3 == 0 && m % 2 != 0) {
//				System.out.print(m + " ");
//				tot += m;
//				su += 1;
//			}
//			m++;
//		}
//		System.out.println();
//		System.out.println("합은 " + tot + ", 갯수: " + su);
//
//		// 문2) -1,3,-5,7.-9.13 ..99까지의 합 출력
//		int n = 1, cnt = 1, hap = 0;
//
//		while (n < 100) {
//			if (cnt % 2 == 0) {
//				hap += n;
//				System.out.println("짝수: " + n);
//			} else {
//				int imsi = n * -1;
//				hap += imsi;
//				System.out.println("홀수: " + imsi);
//			}
////			System.out.println(n);
//			n += 2;
//			cnt += 1;
//		}
//		System.out.println("합은 " + hap + "입니다.");
//
//		// for로 출력
//		int hap2 = 0, cnt2 = 1;
//		for (int c = 1; c < 100; c += 2) {
//			if (cnt2 % 2 == 0) { // 양수
//				hap2 += c;
//			} else { // 음수
//				hap2 += -1 * c;
//			}
//			cnt2++;
//		}
//		System.out.println("for 합은 " + hap2 + "입니다.");

		// 문3) 1~100 사이의 정수 중 소수와그 개수를 출력
		// 소수 : 1보다 크며 1과 그 수 자체 이외의 다른 수로는 나누어 떨어지지 않는 수

		int aa = 2;
		int count2 = 0;
		int su2 = 0;
		System.out.println("1부터 100까지의 소수: ");
		while (aa <= 100) {
			boolean imsi = false;
			int bb = 2;
			while (bb <= aa - 1) { //2<=1 // 2=<2 //3<=2
				if (aa % bb == 0) {
					imsi = true;
				}
				bb++;
			}
			if (imsi == false) {
				System.out.print(aa + " ");
				count2++;
			}
			aa++;
		}
		System.out.println("\n건수: " + count2);

		System.out.println("2부터 그 숫자의 제곱근까지의 모든 수로 나누어 떨어지는지 확인");
		// 소수를 찾는 이유로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의 제곱근을 넘지 않기 때문

		int num = 2; // 소수는 1이 아니다
		int count3 = 0;// 건수
		System.out.println("1부터 100까지의 소수:");
		while (num <= 100) {
			boolean isPrime = true; // 현재 숫자가 소수인지 판별
			int divisor = 2;
			while (divisor <= Math.sqrt(num)) { // 제곱근
				if (num % divisor == 0) {
					isPrime = false;
					break; // 나누어 떨어지지 않으면 더이상 검사는 필요없다.
				}
				divisor++;
			}
			if (isPrime) { //if (isPrime == true)
				count3++; // 소수의 개수를 증가
				System.out.print(num + " ");
			}
			num++;
		}
		System.out.println("\n건수: " + count3);
	}

}
