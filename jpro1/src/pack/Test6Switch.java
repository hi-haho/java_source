package pack;

import java.util.Scanner;

public class Test6Switch {

	public static void main(String[] args) {
//		조건 판단문 switch : 정형화된 문법
		int nai = 15;
		nai = nai / 10 * 10;
//		System.out.println(nai);
		switch (nai) {
		case 20:
			System.out.println("이십대");
			break;
		case 30:
			System.out.println("삼십대");
			System.out.println("만세");
			break;

		default:
			System.out.println("기타");
		}

		System.out.println();
		String jik = "과장";
		switch (jik) { // 버전이 올라가면서 문자열이 들어올 수 있다.
		case "대리":
			System.out.println("대리 만세");
			break;
		case "과장":
			System.out.println("과장 만세");
			break;
		case "부장":
			System.out.println("부장 만세");
			break;
		default:
			System.out.println("기타 직원");
			break;
		}
		System.out.println();
		// 난수를 발생
		System.out.println(Math.random());
//		int time = (int) (Math.random() * 10)
//		int time = (int) (Math.random() * 종료) + 시작;
//		Math.random() >> 0과1 사이의 숫자들
		int time = (int) (Math.random() * 9); // 8~11사이 정수
		System.out.println(time);

		
		  switch (time) { case 8: System.out.println("학원가자"); break; case 9:
		  System.out.println("인사하자"); System.out.println("복습하자"); // break; case 10:
		  System.out.println("문제풀자"); break; default: System.out.println("명상 시간"); }
		  System.out.println();
		  // 문제
		  // 키보드로 년과 월을 입력받아 해당 년월의 날수 출력
		  int year, month,
		  days = 28;
		  String msg = "평년";
		  Scanner sc = new Scanner(System.in);
		  System.out.println("연도 입력: ");
		  year = sc.nextInt();
		  System.out.println("월 입력: ");
		  month = sc.nextInt();
		  
//		  year = 2024; month =3;
		  if (month < 1 || month > 12) {
			  //1-12사이만 허용(입력자료 오류 검사)
		  System.out.println("잘못 입력하셨습니다.");
		  System.exit(0);//프로그램 강제 종료
		  } //윤년 체크
		  if(year % 4 == 0 && year % 100 !=0 || year % 400 ==0) {
			  days = 29; msg = "윤년";
		  }else {
			  days = 28;
			  msg = "평년"; }
		  
		  System.out.println( year+"년 "+days+"일 "+month+" 달은 "+ msg)
		 ;
	}

}
