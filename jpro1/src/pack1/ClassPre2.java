package pack1;

public class ClassPre2 {
	//다른 클래스에서 필요한 자원을 담아둔 저장소 역할
	//설명서라는거지?! 붕어빵 틀이라는 거지!
	
	//방법3: 별도 클래스에서 작성
	public void hap(int su1, int su2) { //합구하기 >> 다른 기억 장소에 저장된다.
		System.out.println("방법3) 합은 " + (su1 + su2));
	}

	public void cha(int su1, int su2) { //차구하기
		System.out.println("방법3) 차는 " + (su1 - su2));
	}
}
