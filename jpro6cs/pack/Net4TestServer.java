package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestServer {

	public static void main(String[] args) {
		// 단순 서버 (요청 받고 보내버린다.)
		ServerSocket ss = null;
		
		//내 컴퓨터가 사용중인 port number 확인
		/*
		for (int i = 0; i < 65536; i++) {
			try {
				ss=new ServerSocket(i); //이미 소켓을 사용중이면 err
				ss.close();
			} catch (Exception e) {
				System.out.println(i+"번 port는 사용중");
			}
		}
		System.out.println("확인 종료");
		*/
		Socket socket = null; //TCP(4꼐층)/IP(5계층) > TCP를 사용하면 사실 IP가 함께이다.
		//TCP 기반의 통신용 클래스(파일) /A socket is an endpoint for communication between two machines.
		//지금 여기서는 스레드는 안쓰겁니다.
		
		try {
			ss = new ServerSocket(9999); //서버 소켓
			System.out.println("서버 서비스 시작 ..");
			socket = ss.accept(); //서버 소켓으로부터 클라이언트 컴과 통신하기 위한 개별 소켓 생성
			//클라이언트가 요청하기를 기다리고 있다.(무한루프)
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			String data = reader.readLine();
			System.out.println("tntls : " + data); //클라이언트가 자료를 전달하면 바로 서버 죽는다.
			// 사실 서버 역할을 안하고 있는 중이다.
			
			reader.close();
			socket.close();
			ss.close();
		} catch (Exception e) {
			System.out.println("server err"+e);
		}
	}

}
