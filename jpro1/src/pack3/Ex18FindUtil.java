package pack3;

public class Ex18FindUtil {
	public static void find(Ex18Animal ani) { //객체 변수로 부르는게 아니고 츨래스로 불러도 된다.
		ani.animalprint();
		
		//instanceof 객체 타입 비교연산자
		if (ani instanceof Ex18Cow) {
			Ex18Animal a = ani;
			System.out.println(a.name());
			System.out.println(a.eat());
		}else if(ani instanceof Ex18Lion) {
			System.out.println(ani.name());
		}
	}
}
