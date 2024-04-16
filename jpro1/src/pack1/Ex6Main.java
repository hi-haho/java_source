package pack1;

public class Ex6Main {

	public static void main(String[] args) {
		// 같은 패키지에 있는 Ex6Bank 클래스를 사용
		Ex6Bank kildong = new Ex6Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액: " + kildong.getMoney());
		
//		kildong.money; //private 해당 클래스에서만 참조
		/*//에러 메시지
		Multiple markers at this line
		- Syntax error, insert "VariableDeclarators" to complete LocalVariableDeclaration
		- The field Ex6Bank.money is not visible*/
		System.out.println("a: "+ kildong.a); //default 같은 패키지에서
		System.out.println("a: "+ kildong.b); //public 같은 패키지에서
		
		
		System.out.println();
		Ex6Bank dajeong= new Ex6Bank(2000);
		dajeong.dePosit(5000);
		dajeong.withDraw(2000);
		System.out.println("dajeong 예금액: " + dajeong.getMoney());
		
		System.out.println("\n==== 객체 주소 관련 ====");
		System.out.println("kildong 주소: "+kildong+" 주소 10진수 "+ kildong.hashCode());
		System.out.println("dajeong 주소: "+dajeong+" 주소 10진수 "+ dajeong.hashCode());
		
		System.out.println("\n=============");
		Ex6Bank tom = null; //생성자를 안가지왔다.
		System.out.println(tom);
		//System.out.println("tom 예금액: " + tom.getMoney());
		//java.lang.NullPointerException
		//문법 에러는 아니다. 객체 변수(stack)가 실행시 메모리에 생성되면서 heap에 주소를 가리키지 않고 있다.
		//즉, heap메모리에 생성되지 않았다.
		tom = dajeong; //주소를 복사해 넣음
		System.out.println("tom 예금액: " + tom.getMoney());
		
		System.out.println("\n---- 다정 vs 톰 ----");
		if (dajeong == tom) {
			System.out.println("둘이 같은 조소를 참조하고 있다.: " + dajeong);
		}else {
			System.out.println("둘은 다른 주소를 참조하고 있다.");
		}
		System.out.println("---- 다정 vs 길동 ----");
		if (dajeong == kildong) {
			System.out.println("둘이 같은 조소를 참조하고 있다.: " + dajeong );
		}else {
			System.out.println("둘은 다른 주소를 참조하고 있다~~~");
		}
		
		
		if (dajeong instanceof Ex6Bank) {
//			instanceof :객체타입 비교 연산자
			System.out.println("Ex6Bank 타입이 맞아요");
		}else {
			System.out.println("ㅜㅠㅜEx6Bank 타입이 아닙니다");
		}
		
		System.out.println("\n /////// String 타입의 값 비교 //////");
		String ss1="kor"; //기본형처럼
		String ss2 = new String();
		ss2 = "kor";// 너는 위의 방법이랑 똑같아
		String ss3 = new String("kor"); //생성자를 통해 값을 넣음 /heap에 들어가
		
		System.out.println(ss1 + "  "+ss2+"  "+ss3);
		if (ss1 == ss2) {
			System.out.println("같음1" + ss1);
		}else {
			System.out.println("다름1");
		}
		
		if (ss1 == ss3) {
			System.out.println("같음2");
		}else {
			System.out.println("다름2: " + ss2 +",...." + ss3);
		}
		
		// 그러므로 결론은 String은 주소 비교가 아니라 값을 비교하는 것이 목적이다. .equals()사용
		
		if (ss1.equals(ss2)) {
			System.out.println("이건 어차피 같을거야 값 자체를 비교할거걸랑");
		}else {
			System.out.println("이건 아마 안나올거야 이건 값이 같거든");
		}
		
		if (ss1.equals(ss3)) {
			System.out.println("이건 어차피 같을거야 값 자체를 비교할거걸랑");
		}else {
			System.out.println("이건 아마 안나올거야 이건 값이 같거든");
		}
		
		System.out.println("----------");
		
		if (ss1.equalsIgnoreCase(ss3)) { //대소문자 구분 안하고 값 비교할거야
			System.out.println("이건 대소문자 구분안함 어짜피 같음");
		}else {
			System.out.println("대소문자도 구분안하는데 이거 뜨면 걍 틀린것임");
		}
		
		
		
		
		
		
		
	}

}
