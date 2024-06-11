package pack.borad;

import java.time.LocalDate;

import lombok.Data; //getter, setter, 아규먼트 없는 생성자까지 만들어진다.

@Data
public class BoardFormbean {
	private String name,pass,mail,title,cont,bip,bdate;
	private int num,readcnt,gnum,onum,nested;
	
	public void setBdate() { //overloading _ setbdate
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		String mon="";
		//month 2자리수로 출력
		if(month <10) {
			mon = "0"+month;
		}
		
		this.bdate = year + "-" + mon + "-"+ day;
	}
	
	
}
