package pack2;

public class Ex10PohamHandle {
	int quantity; //자동차의 회전량
	
	public Ex10PohamHandle() {
		quantity =0;
	}
	
	String leftTurn(int q) { //디폴트 같은 패키지 내에서
		quantity = q;
		return"좌회전";
	}
	
	String rightTurn(int quantity) {
		this.quantity = quantity;
		return "우회전";
	}
	
	String straight(int quantity) {
		this.quantity = quantity;
		return "직진";
	}

}
