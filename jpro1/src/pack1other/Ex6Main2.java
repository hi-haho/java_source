package pack1other;
//다른 패키지에 잇는 클래스 읽기 (C#은 using)
import pack1.Ex6Bank;
//import pack1.*; //pack1의 모든 클래스를 가져오는 것임(비권장;메모리 낭비가 심하다)

public class Ex6Main2 {

	public static void main(String[] args) {
		// 프로젝트는 같으나 다른 패키지에 있는 Ex6Bank 클래스
		Ex6Bank kildong = new Ex6Bank();
		/*
		 * //클래스에 import가 안되어 있는 경우 Multiple markers at this line
		 * - TODO Auto-generated method stub 
		 * - Ex6Bank cannot be resolved to a type
		 * - Ex6Bank cannot be resolved to a type
		 */
		
//		System.out.println("a: "+ kildong.a); //default 같은 패키지에서만 가능하기에 불가능 
		System.out.println("b: "+ kildong.b); //public 다른 패키지에서

	}

}
