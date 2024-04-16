package pack1;

public class Ex5Main {

	public static void main(String[] args) {
		// Method Overloading을 연습하기 위해서
		
		Ex5AnimalOverload tiger = new Ex5AnimalOverload();
		tiger.display();
		System.out.println();
		tiger.display(10); //인수, 인자, argument
		tiger.display("호랑이");
		tiger.display("호랭이", 2);
		tiger.display("호돌이", 3);
		
		System.out.println("\n===== 생성자 오버로딩에 대해서 =====");
		Ex5AnimalOverload dog = new Ex5AnimalOverload();
		dog.display();
		
		Ex5AnimalOverload hen = new Ex5AnimalOverload(2);
		hen.display();
		
		Ex5AnimalOverload wof = new Ex5AnimalOverload("늑대",3,4);
		wof.display();
		
	}

}
