package pack.order;
/* 장바구니 */

import java.util.Hashtable;

public class CartMgr {/*Object로 하면 캐스팅해야한다.*/
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>();
	
	public void addCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		int quantity = Integer.parseInt(obean.getQuantity());
		
		if(quantity > 0) {
			//동일 상품을 담은 경우, 주문 수량만 증가
			if(hCart.containsKey(product_no)) { //1회이상 장바구니에 담겼던 경우 , containsKey() map Key가 있는지 확인
				OrderBean temp = hCart.get(product_no);
				quantity += Integer.parseInt(temp.getQuantity());
				temp.setQuantity(Integer.toString(quantity));
				hCart.put(product_no, temp);
			}else {
				hCart.put(product_no,obean); //장바구니에 담기는 최초 상품(종류가 다른 종류인 경우)
			}
		}
	}
	public Hashtable<String, OrderBean> getCartList(){
		return hCart;
	}
	public void updateCart(OrderBean obean) { //수량 수정
		String product_no = obean.getProduct_no();
		hCart.put(product_no, obean);
	}
	public void deleterCart(OrderBean obean) { //수량 삭제
		String product_no = obean.getProduct_no();
		hCart.remove(product_no);
	}
}
