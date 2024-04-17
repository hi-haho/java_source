package pack4;

public class Ex30StudentDTO {
	//레코드 단위 기억장소
	//type이 다른 여러 개의 기억장소를 하나의 묶음으로 만들어 자료 전송
	
	private String hacbun, irum;
	private int jumsu;
	
	public Ex30StudentDTO() {
	}
	public Ex30StudentDTO(String hacbun,String irum,int jumsu) {
		//setter가 필요없다. VO가 아니래 DTO래
		this.hacbun = hacbun;
		this.irum = irum;
		this.jumsu = jumsu;
		//생성자를 통해 멤버필드에 값을 줄 경우에 setter는 필요 없다.
	}

	public String getHacbun() {
		return hacbun;
	}

	public void setHacbun(String hacbun) {
		this.hacbun = hacbun;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
	
}
