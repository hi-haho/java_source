package pack3;

public class Ex23FlyerUtill {
	public static void show(Ex23Flyer f) { //static으로 했으면 클래스로 부를 수있어.
		f.fly();
		System.out.println("동물인가요?" + f.isAnimal());
	}
}
