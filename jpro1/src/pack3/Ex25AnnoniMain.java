package pack3;
//무명클래스 연습
public class Ex25AnnoniMain {
	
	public static void main(String[] args) {
		Ex25Saram saram = new Ex25Saram();
		System.out.println(saram.getIr());
		
		System.out.println();
		Ex25Person person= new Ex25Person();
		Ex25Saram saram2 =  person.getSaram();
		System.out.println(saram2.getIr());
		
		System.out.println("hotfix 작업공간에서 적용");
		
		System.out.println("hotfix 작업공간에서 행 추가");
	}
}
