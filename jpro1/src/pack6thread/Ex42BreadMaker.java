package pack6thread;

public class Ex42BreadMaker extends Thread{ //빵 생산자
	private Ex42BreadPlate plate;
	
	public Ex42BreadMaker(Ex42BreadPlate plate) {
		this.plate = plate;
	}
	
	@Override //다른 언어는 꼭 run을 쓰거나 이런 제약없음
	public void run() {
		for (int i = 0; i < 30; i++) {
			plate.makeBreak(); //스레드를 가지고 Ex42BreadPlate에 접근
		}
	}
}
