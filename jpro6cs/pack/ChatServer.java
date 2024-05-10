package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//멀티 채팅 서버 : Thread + Socket
public class ChatServer {
	private static final int PORT = 5000;
//	private static List<Socket> clients = new ArrayList<Socket>();
	//스레드에 최적화 되어있는 list : 스레드용 array리스트 CopyOnWriteArrayList
	//CopyOnWriteArrayList : 컨텐츠를 읽어 어딘가에 전달할 때 컨텐츠를 복사해서 전달한다.
	//스레드에서 안심하고 처리가 가능하다.(신뢰도가 높아짐, 데이터 누수가 방지된다)
	private static List<Socket> clients = new CopyOnWriteArrayList<Socket>();
	
	//ExecutorService를 이용하면 thread pool을 생성해 병렬처리 할 수 있다. //클라이언트 배려 : 사람이 몰리면 크기 늘려
	private static ExecutorService pool = Executors.newFixedThreadPool(4);//thread 크기
	

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("채팅 서버 서비스 시작 ..");

		try {
			while(true) {
				Socket clientSocket = serverSocket.accept();  //접속할때마다 클라이언트 담아둬야한다.
				System.out.println("새 접속자와 연결: " + clientSocket.getInetAddress());
				clients.add(clientSocket); //추가된 사용자를 담기
				
				// 스레드 풀 객체가 스레드를 실행 //run을 부르게 되어 있다.
				pool.execute(new ClientHandler(clientSocket));
			}
		} finally {
			serverSocket.close();
		}

	}

	static class ClientHandler implements Runnable{
		private Socket socket;
		private BufferedReader in;
		 private PrintWriter out;
		 
		public ClientHandler(Socket socket) throws IOException {
			this.socket = socket;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
		}
		@Override
		public void run() {
			try {
				String name = in.readLine(); //접속자명 받기
				if (name == null) {
					throw new IOException("클라이언트 연결이 끊어졌습니다.");
				}
				System.out.println(name+"님이 접속했습니다.");
				broadcastMessage("^^;" + name + "님 입장 ^^"); //thread 클래스 밖에 있음(thread와 다름)
				
				String message;
				while((message = in.readLine()) != null){ //메세지를 수신
					broadcastMessage(name+"님 : " + message);
				}
			} catch (Exception e) {
				System.out.println("접속자 연결 오류 : "+e.getMessage());
			}finally {
				try {
					if(socket != null) {//클라이언트가 나가는 경우 오류발생
						socket.close();
						clients.remove(socket); //클라이언트를 지우는 것
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		private void broadcastMessage(String message) { //스레드 1개 차지
			for(Socket client:clients) {
				try {
					if(!client.isClosed()) { //isClosed() 소켓이 닫혔는지 유무
						//클라이언트로 송신할 데이터를 위한 PrintWriter객체를 생성해 송신 후 자동으로 null이라고 flush한다.
						PrintWriter clientOut = new PrintWriter(client.getOutputStream(),true);
						clientOut.println(message);
					}
				} catch (Exception e) {
					System.out.println("broadcastMessage err" + e.getMessage());
				}
			}
		}
		
		
	}
}
