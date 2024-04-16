package pack3;

public class Ex21Main {

	public static void main(String[] args) {
		// 지원자가 작성한 이력서를 인사 담당자가 취합하여 이력서 출력
		System.out.println("톰 이력서 작성 후 출력");
		Ex21Tom tom = new Ex21Tom();
		tom.setIrum("톰");
		tom.setPhone("111-1234");
		tom.setJuso("강남구 역삼 1동");
		tom.printData();
		
		System.out.println();
		Ex21Jamse jamse = new Ex21Jamse();
		jamse.setIrum("제임스");
		jamse.setPhone("123-1111");
		jamse.setSkill("웹프로그래밍 전문가");
		jamse.printData();
		
		System.out.println("\n-- 인사 담당자가 이력서 출력 --");
		Ex21Resuume[] resBox = new Ex21Resuume[2];
		resBox[0] = tom;
		resBox[1] = jamse;
		
		for(Ex21Resuume r : resBox) {
			r.printData();
			System.out.println();
		}
	}

}
