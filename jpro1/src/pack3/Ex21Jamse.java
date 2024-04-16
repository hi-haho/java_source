package pack3;

// 신입 지원자 제임스
public class Ex21Jamse implements Ex21Resuume {
	private String irum, phone, juso;
	String skill;

	public Ex21Jamse() {
		// 불리는 메서드을 위에 올리고 부르는 메서드는 아래에 적어라
	}

	@Override
	public void setIrum(String irum) {
		if (irum.equals(null)) {
			this.irum = "아무개";
		} else {
			this.irum = irum;
		}
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSkill(String s) { // 톰의 고유 메서드
		skill = s;
	}

	@Override
	public void printData() {
//		Ex21Resuume.SIZE = "b5"; // final이기 때문에 변경이 불가능
		System.out.println("이력서 규격은 " + Ex21Resuume.SIZE);
		System.out.println("이름: " + irum);
		System.out.println("전화: " + phone);
		System.out.println("보유기술: " + skill);

	}

}
