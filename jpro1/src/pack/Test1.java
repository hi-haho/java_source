package pack;
//대전제
//정수가 들어오면 int형으로 자동형변환이된다.
public class Test1 {
	//main >메인 클래스 
	public static void main(String[] args) {
		System.out.println("성공");//syso
		System.out.println("단축키를 사용하자 syso");
		System.out.print("자바");
		System.out.println("변수");
		System.out.println("------------변수------------");
//		기본형 : bcbsilfd - 값을 변수가 직접 기억
//		참조형 : 객체- 객체의 주소를 변수가 기억
		byte var1; // 1byte 정수 기억장소 -128 ~127
		var1 = 3;
		var1 = 1; 
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println("------------변수------------");
		short var2 = 123; //2byte
		System.out.println(var2);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println("------------변수------------");
		int var3 = 123; //4byte
		System.out.println(var3);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println("------------변수------------");
		long var4 = 123451234512345L; //8byte
		System.out.println(var3);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println("------------변수------------");
		
		short i = 2; // promotion 
		
		short i2 = (short)3; // casting
		//int i33 = i;// 내가 알던 casting
		System.out.println(i +"---"+i2); //문자끼리 +면 숫자도 문자로 인식함
		
		short i3 = (short)50000;
		System.out.println(i3);
		
		int imsi = 123;
//		short ss4 = 123;
		short ss4 = (short)imsi;
//		컴퓨터 입장 : imsi에 어떤 숫자가 들어가있는지 모른다. casting해야한다.
//		java 문법적으로 틀림.
		System.out.println(ss4);
		
		System.out.println("------------");
		// 자바에서 실수는 무조건 dobule로 인정 8byte(소수 18자리까지 확보)
		double d1 = 1.2;
		d1 = 12.345;
		d1 = 12345; //자동형변환 promotion
		System.out.println(d1);
		
		// float는 4byte크기 
		float f1= 12; //강제 형변환
//		Type mismatch: cannot convert from double to float
		d1 = f1;
		System.out.println(d1);
		float f2 = (float)12.3; //강제 형변환 casting
		
		double result = 4.5 + 10;
//		result = 4.5+(double)10;
//		result = (int)4.5 + 10; //강제로 실수를 정수화할 때 버림 발생
		
		double dd = 5.5;
		int result1 = (int)(4.5+10);
		result1 = (int)4.5+ (int)dd;
		System.out.println(result1);
		System.out.println("지금부터는 논리형(boolean)");
		boolean bul1 = true; //1byte 차지함.
		bul1 = false;
		System.out.println(bul1);
		
		System.out.println("지금부터는 문자형(char) - ASCII코드 문자");
		char c1 = 'a';
		c1='A';
		System.out.println(c1+" "+(int)c1 +" ~ " +65 + " "+(char)65);
		
		System.out.println("안녕" +13 + "반가워");
		System.out.println("안녕" +(char)13 + "반가워");
		System.out.println("안녕" +"\n" + "반가워"); //JAVA escape문자 정리
		
		System.out.println(11+" "+0xf4 + " "+ 013);
	}
}
//실행 단축키 ctrl + f11 
//단축키 먹이는 법: ctrl + enter