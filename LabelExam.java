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
		p.setBackground(Color.gray);
		
		Label label1 = new Label("레이블1");
		Label label2 = new Label("레이블2", Label.CENTER);
		label1.setBackground(Color.yellow);
		label2.setBackground(Color.blue);
		p.add(label1);
		p.add(label2);
		
		add(p);
		setSize(300, 80);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelExam();

		
		
	}

}
