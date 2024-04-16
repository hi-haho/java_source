package good;

import pack1.Ex6Bank;

public class Ex6Main3 {

	public static void main(String[] args) {
		// 프로젝트가 다른곳 (public도 안통함 다른 클래스를 사용하고 싶다.)
		// .java와 . class를 압축시킬 수 있다. >.jar
		Ex6Bank kildong = new Ex6Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println();
	}

}
