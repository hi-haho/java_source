package pack6thread;

public class Ex37ThreadTest1 extends Thread{ //java.lang는 import를 하지않아도 된다.
	public Ex37ThreadTest1(){
		
	}
	public Ex37ThreadTest1(String name) {
		super(name);
	}
	public void run() {
		for(int i = 1; i <=10;i++) {
//			System.out.print(i+" ");
			System.out.print(i+": "+getName()+" ");
			
		}
	}
	
	public static void main(String[] args)  { //메인 쓰레드가 작동되고 있는것임
		
		//자바에서 실행 파일 직접 실행
		try {
			//process 단위의 실행
//			Process p1 = Runtime.getRuntime().exec("calc.exe"); //하나의 작업단위
			
			//thread를 사용한 특정 메소드(run) 실행
			//thread를 사용하지 않은 경우 _순차적으로 실행(싱글 스레드)
//			Ex37ThreadTest1 th1 =new Ex37ThreadTest1();
//			th1.run(); //연산작업을 안하는 동안(출력하는 동안) cpu는 놀고있다.
//			Ex37ThreadTest1 th2 =new Ex37ThreadTest1();
//			th2.run();
			
//			사용자 정의 thread를 사용한 경우 - 랜덤하게 실행
//			Ex37ThreadTest1 th1 =new Ex37ThreadTest1();
			Ex37ThreadTest1 th1 =new Ex37ThreadTest1("one");
			th1.start(); //the Java Virtual Machinecalls the run method of this thread. (thread 메서드임)
//			Ex37ThreadTest1 th2 =new Ex37ThreadTest1();
			Ex37ThreadTest1 th2 =new Ex37ThreadTest1("two");
			th2.start();
			//MAX_PRIORITY = 10 최대 우선 순위
			//MIN_PRIORITY = 1 최소 우선 순위
//			th2.setPriority(MAX_PRIORITY); //스레드 스케줄러에게 우선 순위 요청 (우선순의를 높이는 것인데 확정은 아니다. 확률이 높아지는 것)
			
			th1.join(); //th1 스레드가 종료될때까지 main 스레드 종료를 대기
//			th2.join();
			
			th1.yield(); // 다른 스레드의 수행 요청이 들어오면 현재 스레드의 수행을 일시정지(양보)
			System.out.println();
			System.out.println("프로그램 종료");
		} catch (Exception e) {
			System.out.println("err : "+ e);
		}
	}
}
