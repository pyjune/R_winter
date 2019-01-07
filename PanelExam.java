import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelExam extends Frame{

	public PanelExam() {
		super("Panel");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
		
		Panel p = new Panel();
		p.setBackground(Color.blue);
		add(p);
		setSize(300, 80);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelExam();

		
		
	}

}
