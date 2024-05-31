package exam;

public class Students {
	
	private String num;
	private String name;
	private int kor;
	private int eng;
	
	public Students(String num,String name,int kor, int eng) {
		this.num =num;
		this.name = name;
		this.kor =kor;
		this.eng = eng;
	}

	public String getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}
	
}
