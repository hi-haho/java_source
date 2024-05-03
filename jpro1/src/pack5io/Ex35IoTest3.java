package pack5io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Ex35IoTest3 {
//2byte 단위로 데이터 입출력 : 문자열 데이터 처리가 가능, 한글 자료에 효과적

	public void write_file(File file, ArrayList<String> strdatas) { // 저장
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for (String munja : strdatas) {
				writer.write(munja, 0, munja.length());
				writer.newLine(); // line skip
			}
			if (writer != null) {
				writer.close();
			}
		} catch (Exception e) {
			System.out.println("write_file erer: " + e);
		}

	}

	public void read_file(File file) {
//		try {
//			
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String online;
////			String strs = null;
//			StringBuffer buffer = new StringBuffer();
//			while((online = reader.readLine()) != null) {
////				strs += online; + "\n";// 문자열 더하기는 비권장 (많아지면)
//				//문자열 더하기가 많은 경우 아래 두개의 클래스 중 하나를 추천 "왜??? 뭐가달라?"
//				
////				StringBuilder builder = new StringBuilder();
//				buffer.append(online+"\n"); // 권장사항
//			}
//			if(reader != null) reader.close();
//			System.out.println(buffer.toString());
//			
//		} catch (Exception e) {
//			System.out.println("read_file erer: " + e);
//		} 
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("하하");
		list.add("호호");
		list.add("히히허");

		File file = new File("c:/work/iotest2.txt");

		Ex35IoTest3 test2 = new Ex35IoTest3();
		test2.write_file(file, list);
		test2.read_file(file);
	}

}
