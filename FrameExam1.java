import java.awt.*;
import java.awt.event.*;

public class FrameExam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.setTitle("제목");
		f.setLocation(0, 0);
		f.setSize(350, 100);
		f.setVisible(true);
	}
}
