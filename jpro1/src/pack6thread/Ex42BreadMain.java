package pack6thread;

public class Ex42BreadMain {

	public static void main(String[] args) {
		// 스레드 간 자원 공유 및 스레드 활성화/비활성화 연습
		Ex42BreadPlate breadPlate = new Ex42BreadPlate();
		
		Ex42BreadMaker maker = new Ex42BreadMaker(breadPlate);
		Ex42BreadEater eater = new Ex42BreadEater(breadPlate);
//		maker.run(); // 싱글임
		
		maker.start(); //the Java Virtual Machinecalls the run method of this thread. //명시적 호출이 아님
		//start0;메서드가 실행된다. 그러면 JVM이 실행된다.
		eater.start();
		System.out.println(Thread.activeCount());
		System.out.println(Thread.currentThread().getName());
		
	}

}
