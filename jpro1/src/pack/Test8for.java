package pack;

public class Test8for {

	public static void main(String[] args) {
		// 반복문 : continue, break

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			if (i == 3) continue;
			if (i == 5)	break;
//			if (i == 5) System.exit(0); //아예 프로그램 종료
			System.out.println("금요일");
		}

		System.out.println();
		int kk = 0;
		for (;;) {
			kk++;
			System.out.println("무한 출력" + kk);
			if (kk == 10)
				break;
		}

		System.out.println(); // 라벨 for
		kbs: for (int i = 1; i <= 3; i++) {
			mbc: for (int j = 1; j <= 5; j++) {
				System.out.print(i + "-" + j + " ");
				if (j == 3) continue kbs;
			}
			System.out.println("=====");
		}
	}

}
