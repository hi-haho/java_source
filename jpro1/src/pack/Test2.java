package pack;

//소스 코드 자동 정리 ctrl+shift+f
//디버깅
// 브레이크 포인트 c+s+B
// 선택중인 메소드 외부 f7 / 다음 디버깅 f8/ 디버그 모드 f11
public class Test2 {

	public static void main(String[] args) {
		System.out.println("산수 연산자");
		int a = 5;
		int b = 3;
		int c = a + b;

		System.out.println(c);
		System.out.println(a / (double) b);// 결과가 실수

//		System.out.println(a/0);
//		Exception in thread "main" java.lang.ArithmeticException
//		System.out.println(a/0.0); //Infinity(무한대/극한으로 간다.)
		System.out.println(a % 0.0);
//		NaN (Not a Number): 숫자가 아니라 표현할 수 없는 상태

		System.out.println();
		System.out.println("문자열 더하기");
		String ss1 = "배가";
		String ss2 = "고파";
		String ss3 = ss1 + ss2;
		System.out.println(ss3);
		System.out.println(ss3 + "  " + 123); // 숫자가 문자열로 자동변환
		System.out.println(ss3 + "  " + (123 + 100));
		// String ss4 = 5 + 6;
		// Type mismatch: cannot convert from int to String
		String ss4 = "5" + 6; // promotion
		System.out.println(ss4);

		String ss5 = Integer.toString(5) + 6;// casting
		// int 기본형 클래스는 Integer (wrapper class)
		System.out.println(ss5);

		String ss6 = Double.toString(5.2) + 6;// casting
		System.out.println(ss6);

		
		System.out.println();
		int abc = 5 +Integer.parseInt("6"); //문자열을 정수로 바꾸면
		System.out.println(abc);
		
		System.out.println();
		double abc1 = 5 +Double.parseDouble("6.5"); //문자열을 실수로 바꾸면
		System.out.println(abc);
		
		System.out.println();
		int no = 1;
		no = no+1;
		no +=1;
		no++;
		++no;
		System.out.println(no);
		
		int imsi = 5;
		int result = ++imsi +1;
		System.out.println("imsi: "+imsi);
		System.out.println("res: "+result);
		
		System.out.println();
		int imsi2 = 5;
		int result2 = imsi2++ +1; //result2에 6을 넣어주고 imsi2는 7이된다.
		System.out.println("imsi2: "+imsi2);
		System.out.println("res2: "+result2);
		
		//부호 관련
		int imsi3=3;
		System.out.println(imsi3);
		System.out.println(-imsi3);
		System.out.println(imsi3 * -1);
		
	}

}
