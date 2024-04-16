package pack1;


public class Ex3Main {

	public static void main(String[] args) {
		// main을 위한 의미없는 클래스
		Ex3Programmer programmer = new Ex3Programmer();
		//main이 사용하는 것은 Ex3Programmer안에 있는 Ex3Programmer()를 사용하는 것임
		//**이때 실행하면, 주기억장치로 올려지는데 이때 static 영역에 들어가게된다.
		programmer.displayData();
		System.out.println();
		
		//ctrl키 누르고 메서드명을 누르면 바로간다.
		programmer.setAge(33);
		System.out.println("나이는 "+ programmer.getAge());
		programmer.displayData();
		
		System.out.println("\n====");
		Ex3Programmer tom = new Ex3Programmer();
		tom.nickName = "톰 아저씨";
		tom.displayData();
		
		System.out.println("\n====");
		Ex3Programmer james = new Ex3Programmer(); //.을 찍으면 해당 객체로 들어간다.
		james.nickName = "제임스";
		james.displayData();
		
		System.out.println("------");
//		System.out.println("너의 모토는? "+ james.motto); //static을 안쓰는 경우 객체변수(stack)를 사용해 불러와야함.
		//static 멤버는 클래스이름.멤버 하고 사용한다.(권장) / heap에 들어있는 게아니고 그런 용도가 아니다.
		
		System.out.println("너의 모토는? "+ Ex3Programmer.motto); //new 생성안해도된다.
		
		Ex3Programmer.goodMethod();// static으로 사용하면 new를 사용하지 않아도 된다.
		
		//
		
		

	}

}
