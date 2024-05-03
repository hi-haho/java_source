package pack6thread;

public class Ex42BreadPlate {
	private int breadCount = 0; //스레드 간 자원(공유대상)
	
	public Ex42BreadPlate() {
		// TODO Auto-generated constructor stub
	}
	
	//현재 메소드를 스레드로 호출하면 해당 스레드의 연산 처리가 진행되는 동안 lock이 걸린다.
	//다른 스레드는 대기하고 있다.
	public synchronized void makeBreak() {
		if (breadCount >= 10) {
			try {
				System.out.println("빵 생산 목표초과(10개 기준)");
				wait(); //스레드를 낫 넌어블 상태로 만듬
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		breadCount++; //빵 만들기
		System.out.println("빵 생산 총 수: " + breadCount + "개");
		notify(); // 스레드를 러너블 상태로 복구
		
	}
	public synchronized void eatBreak() {
		if (breadCount < 1) {
			try {
				System.out.println("빵이 없어 먹을게 없네..");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		breadCount--; //빵 먹기
		System.out.println("빵 소비 후 총 수: " + breadCount + "개");
		notify(); // 스레드를 러너블 상태로 복구
	}
	
}
