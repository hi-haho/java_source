package pack3;

public class Ex20Main {

	public static void main(String[] args) {
//		Ex20Volume volume = new Ex2Voluem  //인스턴스 생성 불가.
		Ex20Volume volume;
		
		Ex20Radio radio = new Ex20Radio();
		Ex20Tv tv = new Ex20Tv();
		Ex20HandPhone phone = new Ex20HandPhone();
		
		radio.volumeUp(5);
		radio.volumDown(2);
		
		tv.volumeUp(10);
		tv.volumDown(7);
		
		phone.volumeUp(7);
		phone.volumDown(1);
		
		System.out.println("=======");
		volume = radio;
		volume.volumeUp(1);
		
		volume = tv;
		volume.volumeUp(2);
		
		volume = phone;
		volume.volumeUp(3);
		
		System.out.println("=======");
		Ex20Volume volArr[] = new Ex20Volume[3]; //배열을 만든것임 , 생성자 아님
		volArr[0] = radio;
		volArr[1] = tv;
		volArr[2] = phone;
		
		for (int a = 0; a < volArr.length; a++) {
			volArr[a].volumDown(1);
		}
		System.out.println();
		for(Ex20Volume dmc : volArr) {
			dmc.volumDown(1);
		}
	}

}
