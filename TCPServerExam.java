import java.io.*;
import java.net.*;

public class TCPServerExam {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("TCP ���� �����");
		
		Socket so = ss.accept();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
		String msg = br.readLine();
		
		System.out.println("���� �ּ� : " + so.getInetAddress());
		System.out.println("���� ���� : " + msg);
		so.close();
	}
}
