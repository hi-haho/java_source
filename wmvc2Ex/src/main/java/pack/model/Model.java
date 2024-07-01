package pack.model;

public class Model {
	public String getNum(String odds) {
		String res = "";
		int odd = Integer.parseInt(odds);
		if(odd%2 == 0) {
			res="짝수";
		}else {
			res="홀수";
		}
		return res;
	}
}
