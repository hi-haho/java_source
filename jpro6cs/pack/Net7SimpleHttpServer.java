package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Thread와 Socket을 사용해 간단한 웹 서버 작성

public class Net7SimpleHttpServer {
	private ServerSocket serverSocket;
	private final int PORT;

	public Net7SimpleHttpServer(int port) {
		this.PORT = port;
	}

	public void gogo() throws IOException {
		serverSocket = new ServerSocket(PORT);
		System.out.println("HTML Server startd on post : " + PORT);
		
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept(); //클라이언트 요청 받기
				System.out.println("Received requset from "+ clientSocket.getRemoteSocketAddress()); //클라이언트 주소 찍어보기
				
				ClientHandler clientHandler = new ClientHandler(clientSocket); // 클라이언트 주소 받아 넘기기 (클라이언트 수만큼 객체 생성)
				new Thread(clientHandler).start(); // 스레드 실행해서 run()
			} catch (Exception e) {
				System.out.println("gogo err : "+e);
				break;
			}
		}
	}
	
	//내부클래스 thread
	private static class ClientHandler implements Runnable{
		private Socket clientSocket;
		
		public ClientHandler(Socket socket) {
			clientSocket = socket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 버퍼 읽어오는 객체 인스턴스 
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); // 내보내는 객체 인스턴스 했다.
				
				String requestLine = in.readLine();
				System.out.println("Request : " + requestLine);
				
				//http respone : http 요청에 대한 응답
				out.println("HTTP/1.1 200 OK");
				out.println("Content-Type:text/html:charset=UTF-8"); //내용은 text이고 한글이야
				out.println("");
				out.println("<html><head><title>연습</title></head>");
				out.println("<body>");
				out.println("<h1>홈페이지</h1>");
				out.println("<a href='https://www.daum.net'>다음으로</a>출발</br>");
				out.println("<a href='https://www.naver.com'>다음으로</a>가자");
				out.println("</body>");
				out.println("</html>");
				out.close();
				in.close();
				clientSocket.close();
			} catch (Exception e) {
				System.out.println("error client requset : "+e);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		int port = 8080; // Default port(test용 웹서버 포트번호) 실질적으로는 80
		
		try {
			Net7SimpleHttpServer httpServer = new Net7SimpleHttpServer(port);
			httpServer.gogo();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}
