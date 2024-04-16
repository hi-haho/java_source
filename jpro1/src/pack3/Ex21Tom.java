package pack3;

// 신입 지원자 톰
public class Ex21Tom implements Ex21Resuume {
	private String irum, phone, juso;
	
	public Ex21Tom() {
		//불리는 메서드을 위에 올리고 부르는 메서드는 아래에 적어라
	}
	
	@Override
	public void setIrum(String irum) {
		this.irum = irum;
		
	}
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setJuso(String juso) { // 톰의 고유 메서드
		this.juso = juso;
	}
	@Override
	public void printData() {
//		Ex21Resuume.SIZE = "b5"; // final이기 때문에 변경이 불가능
		System.out.println("용지 규격은 " + Ex21Resuume.SIZE);
		System.out.println("이름: "+ irum);
		System.out.println("전화: "+ phone);
		System.out.println("주소: "+ juso);
		
	}
	
}
