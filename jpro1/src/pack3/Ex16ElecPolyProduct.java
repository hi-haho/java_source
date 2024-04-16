package pack3;
//상속은 권유이다.
// 자식클래스에서 오버라이딩 되기를 권장하며 ..(강요는 아님)
// 메소드의 이름을 통일하고 싶음
public class Ex16ElecPolyProduct {
	//가전제품이 가져야할 기본 멤버를 선언한 부모 클래스 + 기본 기능을 하는 메서드를 만든 것
	private int volume = 0;
	
	public Ex16ElecPolyProduct() {
		
	}
	
	public void volumeControl(){
		//가전제품의 볼륨을 조립하는 기능 + 자식클래스가 오버라이딩해서 사용하기를 기대하는 메소드 
		//왜 불편하게 기능도 없는데 만들어? 상속을 받으면 제한적이잖아
		//각 객체들의 기능 변수명이 다르면 찾기 힘들다. 큰 기능의 변수명이 같아야 찾기가 편하다. (다형성을 위해)
		//오버라이딩 하기를 원해 (메소드의 이름을 강요하려고)
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getVolume() {
		return volume;
	}
}
