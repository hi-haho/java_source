package pack6thread;

public class Ex38Thread2 implements Runnable {

	public Ex38Thread2() {
		// TODO Auto-generated constructor stub
	}
	public Ex38Thread2(String name) {
		Thread tt = new Thread(this,name);
		tt.start();
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			//System.out.println(i+" ");
			System.out.println(i+": "+Thread.currentThread().getName());
			//currentThread() 현재 사용중인 쓰레드
			try {
				Thread.sleep(100); //Unhandled exception type InterruptedException 예외처리
				//thread를 일정 시간동안 비활성화.
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void main(String[] args) {
		Ex38Thread2 my1 = new Ex38Thread2();
		Ex38Thread2 my2 = new Ex38Thread2();
		Thread t1 = new Thread(my1);
		t1.start();
		Thread t2 = new Thread(my2);
		t2.start();
		
		new Ex38Thread2("하나");
		new Ex38Thread2("둘");
		
		
		System.out.println("종료");
	}

}
