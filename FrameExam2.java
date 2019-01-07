import java.awt.*;
import java.awt.event.*;

public class FrameExam2 extends Frame{

	public FrameExam2() {
		super("제목");
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
		setLocation(500, 200);
		setSize(350, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameExam2 f = new FrameExam2();
	}

}
