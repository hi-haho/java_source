package pack3;

public class Ex18Lion extends Ex18Animal {
	@Override
	public String name() {
		return "나의 이름은 사자야~ 어흥";
	}
	@Override
	public String eat() {
		String imsi = "사람을 뜯어";
		return imsi;
	}
	@Override
	public String action() {
		return "밤에 이동해";
	}
	
	public void eatOther() {
		System.out.println("가끔 물도 마심");
	}
}
