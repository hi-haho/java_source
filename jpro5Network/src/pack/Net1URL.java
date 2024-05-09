package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

// URL 클래스로 특정 웹 서버 컴의 문서 읽기
// 인터넷이 가능한 서버들의 자원에 접근하여 주소 밎 기타 정보를 다루는 클래스
public class Net1URL {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net"); //No subject alternative DNS name matching www.daum.com found.
			//https://www.naver.com:80/index.html
			//http 보안용 서버 ==> https, tcp 프로토콜(4계층) 기반 응용 프로그램 계층에서 사용 //tcp는 계속 연결되어 있는데 naver 서버와는 요청이 있을때만 연결되고 끊어진다.
			InputStream is  = url.openStream(); //stream과 다른 이야기(데이터의 흐름)
			BufferedReader br = new BufferedReader(
					new InputStreamReader(is,"UTF-8"));
//			System.out.println(br.read());
			//읽은 문서 파일로 저장
			PrintWriter pw = new PrintWriter(System.out,true); //PrintWriter.PrintWriter(OutputStream out, boolean autoFlush)
			PrintWriter fw = new PrintWriter(new FileOutputStream("c:/work/okky.html"));
			
			String line = "";
			while ((line = br.readLine()) != null) {
				pw.println(line); //colnsole로 출력
				fw.println(line); //파일로 저장
				fw.flush(); //버퍼를 깨끗하게 치운다.
			}
			br.close();
			is.close();
			pw.close();
			fw.close();
			
		} catch (Exception e) {
			System.out.println("main err : " + e);
		}
	}

}
