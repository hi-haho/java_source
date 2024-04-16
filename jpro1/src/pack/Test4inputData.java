package pack;

import java.util.Scanner;

public class Test4inputData {

	public static void main(String[] args) {
		//프로그램 진행 도중에 외부에서 값 얻기
		System.out.println("뭔가를 하다가 .. ");
		//args를 매개변수를 통해 값을 얻는다.
		System.out.println(args.length);
		System.out.println("args: " + args[0]);
		System.out.println("args: " + args[0].charAt(0));
		System.out.println("args: " + args[0].charAt(1));
		System.out.println();
		//프로그램 진행 도중에 외부에서 값 얻기
		System.out.print("이름 입력 : ");
		Scanner sc = new Scanner(System.in); //표준 입력장치
		String name = sc.next(); //엔터 + 스페이스바 모두 인식함
//		이후 입력값이 남아서 다음값까지 살아있음
		System.out.println("이름은 : "+name);
		String irum = sc.next();
		System.out.println("이름은 : "+irum);
		
	}
	
}
