package pack3;

public class Ex14Main {

	public static void main(String[] args) {
		// 개과의 동물들 상속으로 처리
		Ex14Dog dog = new Ex14Dog();
		dog.printMsg();
		System.out.println(dog.callName());
		
		System.out.println("\n houseDog에 대하여========");
		Ex14HouseDog houseDog = new Ex14HouseDog("집개");
		houseDog.printMsg();
		System.out.println(houseDog.callName());
		
		System.out.println("\n wolfDog에 대하여========");
		Ex14WolfDog wd = new Ex14WolfDog("늑대");
		wd.printMsg();
		System.out.println(wd.callName());
		wd.display();
		
		
		System.out.println("\n\n 주소 치환======");
		Ex14WolfDog bushDog = wd; //주소를 줄거면 타입이 같아야해
		bushDog.printMsg();
		
		System.out.println();
//		Ex14HouseDog houseDog2 = wd; Type mismatch: cannot convert from Ex14WolfDog to Ex14HouseDog
		Ex14Dog dog2 = wd; //부모 객체가 크다. 자동 타입(형)변환이 된다.
		dog2.printMsg();
//		System.out.println( dog2 instanceof Ex14WolfDog );
		
		Ex14Dog dog3 = new Ex14Dog();
//		Ex14WolfDog wolfDog2 = dog3
		dog3.printMsg();
//		wd = dog3; //자식으로 부모가 들어갈 수 없음
		
		
//		wd = (Ex14WolfDog)dog3; 그냥 혼자 해봤음 블로그 놉
	}

}
