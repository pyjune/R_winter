import java.io.*;
import java.net.*;

public class TCPClientExam {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		
		Socket so = new Socket(ia, 5000);
		
		System.out.print("보낼 메시지 : ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String msg = in.readLine();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
		
		bw.write(msg + "\n");
		bw.flush();
		bw.close();
	}
}
