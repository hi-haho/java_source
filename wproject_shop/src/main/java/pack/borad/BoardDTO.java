package pack.borad;

import lombok.Data; //getter, setter, 아규먼트 없는 생성자까지 만들어진다.
//순수한 데이터를 저장하는 공간
@Data
public class BoardDTO {
	private String name,pass,mail,title,cont,bip,bdate;
	private int num,readcnt,gnum,onum,nested;
}
