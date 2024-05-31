package pack;
//한개의 상품이 이름과 가격으로 구성된다. 해당 구성을 하나의 객체로 만들기 위한 DTO(VO)클래스
public class Goods {
	private String name;
	private int price;
	
	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
}
