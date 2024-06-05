package pack;


public class Gogodan {
	private static Gogodan gugudan = new Gogodan();
	public static Gogodan getInstance() { //싱글톤
		return gugudan;
	}
	
	//구구단 계산 비즈니스 로직 구현 클래스
	public int[] computeGugu(int dan) {
		int gu[] = new int[9];
		for(int i = 1; i <10 ;i++) {
			gu[i-1] = dan*i;
		}
		return gu;
	}
}
