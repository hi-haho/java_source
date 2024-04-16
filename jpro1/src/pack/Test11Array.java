package pack;

public class Test11Array {

	public static void main(String[] args) {
		// Main method 매개변수(배열) 확인
		if(args.length == 0) {
			System.out.println("실행 시 값을 주세요");
			System.exit(0);
		}
		System.out.println(args.length);
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[2]));
		System.out.println(args[1]);
		System.out.println("`````````");
		for (String string : args) {
			System.out.println(string+" ");
		}
		System.out.println("응용 프로그램 종료");
	}

}
