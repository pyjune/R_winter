import java.net.*;
import java.io.*;

public class UDPServerExam {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket ds = new DatagramSocket(3000);
		byte [] data = new byte[65508];
		
		DatagramPacket dp = new DatagramPacket(data, data.length);
		System.out.println("UDP���� �����");
		
		ds.receive(dp);
		String msg = new String(dp.getData()).trim();
		
		System.out.println("���� �ּ� : " + dp.getAddress());
		System.out.println("���� �޽��� : " + msg);
	}

}
