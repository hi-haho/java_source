package pack3;
//1. 인터페이스의 다중 상속
public class Ex22Main {
//2개의 인터페이스르 다 가져올 수 있었다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex22Radio radio = new Ex22Radio();
		radio.volOn();
		radio.volUp(5);
		radio.volDown(2);
		radio.showVol();
		radio.volOff();
		radio.showVol();
	}

}
