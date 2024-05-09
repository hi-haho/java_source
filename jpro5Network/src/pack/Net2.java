package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 제 3자가 제공하는 라이브러리(jsoup.jar)를 사용해 웹 스크래핑
// HTML 문서 데이터 구문 분석, 추출 및 조작용 오픈 소스(무료)

public class Net2 {
//싱글쓰레드
	public static void main(String[] args) {
		// 위키백과 사이트에서 검색 결과 읽기
//		https://ko.wikipedia.org/wiki/%EC%8B%A0%EC%A7%B1%EA%B5%AC
		try {
//			System.out.println(URLEncoder.encode("짱구","UTF-8")); //인코딩 : %EC%A7%B1%EA%B5%AC
			
			String url = "https://ko.wikipedia.org/wiki/"+ URLEncoder.encode("짱구","UTF-8"); //자바는 브라우저와 다르기에 인코딩을 해줘야한다.
			//Document : 웹페이지 문서
			Document doc = Jsoup.connect(url).get();
			String text = doc.text();
//			System.out.println(text);//이와 같은 데이터를 가져올 수 있다. 다만 DBMS에는 데이터를 그대로 가져올 수 없다. 가공이 필요하다ㅣ
			
			printKoreanText(text); // 한글만 추출 (원하는 라이브러리 가져와서 사용해라)
			
		} catch (Exception e) {
			System.out.println("err : "+ e);
		}

	}
	
	private static void printKoreanText(String text) {
		//정규 표현식 사용
		//한글과 공백만 얻기
		Pattern pattern = Pattern.compile("[가-힣\\s]+"); // + : 공백이 없으면 하나의 문자열(단어)로 인식 s: 공백
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			String line = matcher.group().trim(); // trim()은 양쪽 공백 제거, 중간 공백 미제거
			if(!line.isEmpty()) { //빈 줄은 제외
				System.out.println(line);
			}
		}
	}
}
