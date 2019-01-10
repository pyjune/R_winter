import java.io.*;
import java.net.*;

public class TCPServerExam2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("TCP ���� �����");
		
		Socket so = ss.accept();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
		while(true) {
			System.out.println(">>>Ŭ���̾�Ʈ�� �޽����� ��ٸ��� ��<<<");
			String get_msg = br.readLine();
			System.out.println("���� �ּ� : " + so.getInetAddress());
			System.out.println("���� ���� : " + get_msg);
			
			System.out.print("�𳾸޽���: ");
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
