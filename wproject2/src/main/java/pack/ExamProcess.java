package pack;

public class ExamProcess { //연산용 프로세스
	private ExamBean bean;
	
	public void setBean(ExamBean bean) {
		this.bean = bean;
	}
	
	public int getTot() {
		return bean.getKor()+bean.getEng()+bean.getMat();
	}
	public double getAvg() {
		return getTot()/3;
	}
}
