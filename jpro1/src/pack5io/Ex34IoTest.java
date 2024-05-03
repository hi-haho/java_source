package pack5io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader; //scanner가 없을때
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex34IoTest {
	public static void main(String[] args) throws Exception {
		// console과 file을 통한 입력
		// 1. console을 통한 입력 (예전 방식)
		/*
		 * InputStreamReader in = new InputStreamReader(System.in); BufferedReader br =
		 * new BufferedReader(in); //속도 조절 System.out.print("이름은 "); String ir =
		 * br.readLine(); //Unhandled exception type IOException //예외처리
		 * System.out.println("이름은 " + ir); br.close(); in.close();
		 */

//		//scnner 클래스
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("이름은");
//		String ir= scanner.nextLine();
//		System.out.print("몸무게는");
//		double w = scanner.nextDouble();
//		System.out.println(ir+"님의 몸무게는 "+w);
//		scanner.close();

		// 파일읽기

//		File f = new File("c:/work/good.txt"); // 리눅스에서 사용 File f = new
		File f = new File("c:\\work\\good.txt"); // window에는 다름 //경로를 기억하게 하려고 한다. //문자 단위 (순수한 문자일경우)
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr); // 데이터 전송 속도 조절 // System.out.println(br.readLine());
		// readLine()는 한줄씩 읽는 것(반환값 String), read()한번에 읽음
		while (true) {
			String ss = br.readLine();
			if (ss == null)
				break;
			System.out.println(ss);
		}
		br.close(); // Garbage Collecter(GC)로 하여금 점유 메모리 해제 요청 (우선순위가 높아지는 것임) fr.close();

		System.out.println("전국 도서관 정보 파일 일부 읽기 =--=-=-=-=");

		File file = new File("c:/work/전국도서관표준데이터.csv");
		FileReader fr2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(fr2);
		int count = 0;
		String ss = br2.readLine(); // 제목 넘겨
		while (true) {
			count++;
			ss = br2.readLine();
			if (ss == null || count >= 10)
				break;
			StringTokenizer tok = new StringTokenizer(ss, ",");
			String s1 = tok.nextToken();
			String s2 = tok.nextToken();
			String s3 = tok.nextToken();
			String s4 = tok.nextToken();

			System.out.println(s1 + "\t" + s2 + "\t" + s3 + "\t" + s4);
		}
		System.out.println("건수: " + count);
	}
}
