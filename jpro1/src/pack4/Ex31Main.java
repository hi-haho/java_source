package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31Main {

	ArrayList<Ex31DTO> ex31List = new ArrayList<Ex31DTO>(); // list 컬렉션 타입의 객체변수에 ArrayList<Ex31DTO>생성자 호출한다.
	Ex31DTO ex31dto;

	public String dtoInsert() throws Exception {
		Scanner scanner = new Scanner(System.in);

		ex31dto = new Ex31DTO(); // Ex31DTO 생성자 호출한다.
		System.out.print("이름 입력: ");
		ex31dto.setName(scanner.nextLine()); // 값을 입력받고 ex31dto인스턴스 setName을 통해 Ex31DTO 필드 변수에 치환시킨다.
		System.out.print("국어 점수: ");
		ex31dto.setKor(scanner.nextInt());
		System.out.print("영어 점수: ");
		ex31dto.setEng(scanner.nextInt());
		scanner.nextLine();
		System.out.print("계속할까요(y/n) ? ");
		String q = scanner.nextLine();

		ex31List.add(ex31dto); // 값을 컬렉션 List에 넣어준다.
		return q;
	}

	public void showList() throws Exception {
		System.out.println("\n이름\t국어\t영어\t총점");
		for (Ex31DTO dto : ex31List) {
			System.out.println(dto.getName() + "\t" + dto.getKor() + "\t" + dto.getEng() + "\t"
					+ (dto.getKor() + dto.getEng()));
		}

		System.out.println("\n**응시인원 " + ex31List.size() + "명");
	}

	public static void main(String[] args) {
		boolean r = true;

		try {
			Ex31Main main = new Ex31Main();
			while (r) {
				String q = main.dtoInsert(); // 값 넣기
				if (q.equalsIgnoreCase("n")) {
					main.showList();
					r = false;
				}

			}
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e.getMessage());
		}
	}

}
