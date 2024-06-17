package pack.order;
/* 장바구니 */

import java.util.Hashtable;

public class CartMgr {/*Object로 하면 캐스팅해야한다.*/
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>();
	
	public void addCart(OrderBean obean) {
		
	}
	public Hashtable<String, OrderBean> getCartList(){
		return hCart;
	}
	public void updateCart(OrderBean obern) {
		
	}
	public void deleterCart(OrderBean obern) {
		
	}
}
