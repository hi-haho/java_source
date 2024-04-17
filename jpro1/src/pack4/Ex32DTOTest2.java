package pack4;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex32DTOTest2 {

	private ArrayList<Ex32HaksaengDTO> dtos = new ArrayList<Ex32HaksaengDTO>();
	
	public void inputData(String[] datas) {
//		System.out.println(datas[0]);
		//김밥,100,100,100 이런 문자열을 콤마(,)를 기준으로 분리
//		StringTokenizer tokenizer = new StringTokenizer("kbs,mbc,sbs",",");
//		String s1 = tokenizer.nextToken();
//		String s2 = tokenizer.nextToken();
//		String s3 = tokenizer.nextToken();
//		System.out.println(s1+"  "+s2+"  "+s3);
		
		for (int i = 0; i < datas.length; i++) {
			StringTokenizer tok = new StringTokenizer(datas[i],",");
			String ir = tok.nextToken();
			int kor = Integer.parseInt(tok.nextToken());
			int eng = Integer.parseInt(tok.nextToken());
			int mat = Integer.parseInt(tok.nextToken());
			
			Ex32HaksaengDTO dto = new Ex32HaksaengDTO(); // 레코드 단위용 클래스 dto처리
			dto.setName(ir);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMat(mat);
//			Ex32HaksaengDTO dto2 = new Ex32HaksaengDTO(ir,kor,eng,mat); //생성자를 사용한 것임
			dtos.add(dto);
		}
	}
	public void displayData() {
		for(Ex32HaksaengDTO hd : dtos) {
			int tot = hd.getKor() + hd.getEng() + hd.getMat();
			double avg = Math.round(tot/3.);
			
			System.out.println(hd.getName()+ ", 총점: "+tot+", 평균: "+ avg);
		}
	}
	
	public static void main(String[] args) {
		String[] datas = new String[3];
		datas[0] = "김밥,100,100,100";
		datas[1] = "주먹밥,80,75,88";
		datas[2] = "비빔밥,77,88,80";
		
		Ex32DTOTest2 test2 = new Ex32DTOTest2();
		test2.inputData(datas);
		test2.displayData();
	}

}
