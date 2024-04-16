package pack1;

public class Ex9Callby2 {
	public void ex(int a, int b) { //매개변수(파라미터) : 기본형
		int imsi =a+30;
		a =b;
		b = imsi;
		System.out.println("메소드 내의 a: "+ a + " b: "+ b);
	}
	
	public void ex(Ex9Callby1 data) {//매개변수(파라미터) : 참조형
		int imsi = data.a;
		
		data.a = data.b;
		data.b = imsi;
		System.out.println("메소드(참조) 내의 a:"+ data.a + " b: "+ data.b);
	}
	
	public void ex(int[] ar) {//매개변수(파라미터) : 참조형 주소를 받은거지
		int imsi = ar[0];
		ar[0] = ar[1];
		ar[1]= imsi;
		System.out.println("배열 메소드 내의 0번: "+ ar[0] + " 1번: "+ ar[1]);
		
	}
}
