package pack4;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CompanyTest {
	
	private static ArrayList<CompanyDTO> list = new ArrayList<CompanyDTO>(); // 컬렉션
	
	public static void calYearSal(int salary, int inYear) {
		double gong;
		if(0<=inYear&&inYear<=3) {
			if (salary<2000000) {
				gong = (salary + 150000)*0.15;
			}else if(2000000<=salary && salary<=3000000){
				gong = (salary + 150000)*0.3;
			}else {
				gong = (salary + 150000)*0.5;
			}
		}else if (4<=inYear&&inYear<=8) {
			if (salary<2000000) {
				gong = (salary + 150000)*0.15;
			}else if(2000000<=salary && salary<=3000000){
				gong = (salary + 150000)*0.3;
			}else {
				gong = (salary + 150000)*0.5;
			}
		}else {
			if (salary<2000000) {
				gong = (salary + 150000)*0.15;
			}else if(2000000<=salary && salary<=3000000){
				gong = (salary + 150000)*0.3;
			}else {
				gong = (salary + 150000)*0.5;
			}
		}
		
	}
	
	public static void showDTO() {
		System.out.println("사번\t이름\t기본급\t근무년수\t근속수당\t공제액\t수령액");
		for (CompanyDTO cd : list) {
//			System.out.print(cd.getNum()+"\t"+cd.getName()+"\t"+cd.getSalary()+"\t"++"\t");
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(args[i],",");
			int num = Integer.parseInt(tokenizer.nextToken());
			String name = tokenizer.nextToken();
			int salary = Integer.parseInt(tokenizer.nextToken());
			int inYear = Integer.parseInt(tokenizer.nextToken());
			
			calYearSal(salary,inYear);
			
//			CompanyDTO dto = new CompanyDTO();
//			dto.setNum(num); //사번
//			dto.setName(name); // 이름
//			dto.setSalary(salary); // 기본급
//			dto.setInYear(inYear); // 근무년수
//			
//			list.add(dto);
			
		}
	}
}
