package pack6thread;

public class Ex41Bank {
	private int money = 10000; // 프로세스가 가진 자원(공유자원으로 사용할 것임)

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public synchronized void saveMoney(int mon) { // 입금
		int m = this.getMoney();
		try {
			Thread.sleep(2000); // 은행에 입금 시 약간의 지연 시간(2초)을 표현
		} catch (Exception e) {
			System.out.println(e);
		}
		setMoney(m + mon);
	}

	public synchronized void minusMoney(int mon) { // 출금
		int m = this.getMoney();
		if (mon > m) {
			System.out.println("잔고액 보다 출금액이 더 큽니다.");
			return; //메소드의 탈출
		}
		try {
			Thread.sleep(3000); // 은행에 출금 시 약간의 지연 시간(3초)을 표현
		} catch (Exception e) {
			System.out.println(e);
		}
		setMoney(m - mon);
	}

}
