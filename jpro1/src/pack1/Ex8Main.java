package pack1;

import java.time.LocalDate;

public class Ex8Main {

	public static void main(String[] args) {
		// GoF 싱글톤 패턴 연습 
		
		
		Ex8SingletonClass aa1 = new Ex8SingletonClass();
		System.out.println(aa1.kor);
		
		Ex8SingletonClass aa2 = new Ex8SingletonClass();
		System.out.println(aa2.kor);
		
		System.out.println(aa1+" / "+ aa2);
		System.out.println(aa1.hashCode()+" "+ aa2.hashCode());
		//.hashCode() 16진수로
		
//		aa1.getInstance()
		System.out.println();
		Ex8SingletonClass aa3 = Ex8SingletonClass.getInstance();
		System.out.println(aa3.kor);
		
		Ex8SingletonClass aa4 = Ex8SingletonClass.getInstance();
		System.out.println(aa4.kor);
		System.out.println("======주소 비교======");
		System.out.println(aa3.hashCode() +" "+ aa4.hashCode());
		System.out.println(aa3.hashCode() == aa4.hashCode());
		
		System.out.println("--------");
		LocalDate mynow = LocalDate.now(); // new 안했음. static임(final은 아님)
		LocalDate mynow2 = LocalDate.now();
		System.out.println(mynow.hashCode());
		System.out.println(mynow2.hashCode());
		System.out.println(mynow.getYear());
		
	}

}
