package pack3;
//인터페이스는 어떻게 사용하나요?
//
public class Ex20Tv implements Ex20Volume {

	private int volLevel;

	public Ex20Tv() {
		volLevel = 0;
	}

	@Override //추상 메서드 오버라이딩 (파란 삼각형)
	public void volumeUp(int level) {
		// 인터페이스의 추상메서드를 오버라이딩
		volLevel += level;
		String msg = "Tv 볼륨을 높이기 ";
		System.out.println(msg+ volLevel);

	}

	@Override
	public void volumDown(int level) {
		// 인터페이스의 추상 메서드를 오버라이딩
		volLevel -= level;
		String msg = "TV 볼륨을 내리기 ";
		System.out.println(msg+ volLevel);

	}

}
