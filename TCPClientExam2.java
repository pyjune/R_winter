import java.io.*;
import java.net.*;

public class TCPClientExam2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		
		Socket so = new Socket(ia, 5000);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
		
		while(true) {
			System.out.print("보낼 메시지 : ");
			String send_msg = in.readLine();
			bw.write(send_msg + "\n");
			bw.flush();
			
			System.out.println(">>>>서버의 메시지를 기다리는 중<<<<");
			String get_msg = br.readLine();
			
			System.out.println("보낸 주소 : " + so.getInetAddress());
			System.out.println("보낸 내용 : " + get_msg);
			if(get_msg.equals("exit")) {
				so.close();
				bw.close();
				System.exit(0);
			}
		}
	}
}
