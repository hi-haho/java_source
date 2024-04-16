package pack1;

public class ClassPreceding {

	public static void main(String[] args) {
		// 클래스 이해 전에 자원의 재활용에 대해 알아보기
		int su1 = 6;
		int su2 = 3;
		
		System.out.println("~~~방법 1~~~");
		System.out.println("합은 " + (su1 + su2));
		System.out.println("차는 " + (su1 - su2));
		System.out.println();
		System.out.println("합은 " + (su1 + su2));
		System.out.println("차는 " + (su1 - su2));
		
		System.out.println("\n~~~방법 2~~~");
		//별도의 단위 프로그램을 작성 후 필요할 때 마다 호출
		hap(su1, su2);
		cha(su1, su2);
		
		System.out.println("\n~~~방법 3~~~");
		//별도의 클래스(ClassPre2)를 호출
		//여러 클래스에서 사용할때 클래스 만듬
		ClassPre2 my = new ClassPre2(); //붕어빵을 만들거라는 거지!
//		(메모리 공간 쓸거니깐 메모리에 올리고(heap) my에 주소알려줘 )
		my.hap(su1, su2);
		my.hap(5, 20);
		my.cha(su1, su2);
		
	}
	
	//하나의 클래스 안에서 사용하는 기능 > 메소드
	public static void hap(int su1, int su2) { //합구하기 >> 다른 기억 장소에 저장된다.
		System.out.println("합은 " + (su1 + su2));
	}

	public static void cha(int su1, int su2) { //차구하기
		System.out.println("차는 " + (su1 - su2));
	}

}
