package pack3;
//인터페이스는 어떻게 사용하나요?
//
public class Ex20Radio implements Ex20Volume {

	private int volLevel;

	public Ex20Radio() {
		volLevel = 0;
	}

	@Override //추상 메서드 오버라이딩 (파란 삼각형)
	public void volumeUp(int level) {
		// 인터페이스의 추상메서드를 오버라이딩
		volLevel += level;
		System.out.println("라디오 볼륨을 올리면 " + volLevel);

	}

	@Override
	public void volumDown(int level) {
		// 인터페이스의 추상 메서드를 오버라이딩
		volLevel -= level;
		System.out.println("라디오 볼륨을 내리면 "+ volLevel);

	}

}
