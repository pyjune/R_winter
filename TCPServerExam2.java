import java.io.*;
import java.net.*;

public class TCPServerExam2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("TCP 서버 대기중");
		
		Socket so = ss.accept();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
		while(true) {
			System.out.println(">>>클라이언트의 메시지를 기다리는 중<<<");
			String get_msg = br.readLine();
			System.out.println("보낸 주소 : " + so.getInetAddress());
			System.out.println("보낸 내용 : " + get_msg);
			
			System.out.print("모낼메시지: ");
			String send_msg = in.readLine();
			bw.write(send_msg + "\n");
			bw.flush();
			if(send_msg.equals("exit")) {
				so.close();
				bw.close();
				System.exit(0);
			}
		}
	}
}
