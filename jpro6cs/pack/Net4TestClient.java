package pack;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Net4TestClient {

	public static void main(String[] args) {
		// 특정 컴의 접속 후 메세지 전달용
		try {
//			InetAddress ia = InetAddress.getByName("127.0.0.1"); //InetAddress : ip 주소 얻는 클래스
//			System.out.println(ia);
//			Socket socket = new Socket(ia, 9999);
			
			Socket socket = new Socket("127.0.0.1", 9999); //서버 접속
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true); //buffered는 안쓰기로
			writer.println("Hi I'am hahahoho"+"\n"); //서버로 자료 전송
			
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("client err : "+e);
		}

	}

}
