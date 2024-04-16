package pack3;

public class Ex16ElecPolyTv extends Ex16ElecPolyProduct{

	@Override
	public void volumeControl() {
		int soriSize = getVolume();
		System.out.println("TV 소리 변경 후 " + soriSize);
	}
	
	public void tvShow() {
		System.out.println("Tv의 고유 메서드");
	}
}
