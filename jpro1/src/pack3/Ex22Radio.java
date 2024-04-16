package pack3;
//인터페이스는 다중상속이 가능하다.
//extends는 다중 상속이 불가능하지만 implements를 사용하면 콤마를 사용해서 다중 상속의 효과를 볼 수 있습니다.
//1번 
//public class Ex22Radio implements Ex22InterVol,Ex22VolEtc {
public class Ex22Radio implements Ex22InterVol {
	private int v = 0;
	
	@Override
	public void volUp(int v) {
		this.v += v;
		
	}
	
	@Override
	public void volDown(int v) {
		this.v -= v;
		
	}
	
	@Override
	public void volOff() {
		v = 0;
		
	}
	
	@Override
	public void volOn() {
		v = 1;
		
	}
	
	public void showVol() {
		System.out.println("현재 볼륨은 "+ v);
	}
}
