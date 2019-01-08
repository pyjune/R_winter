import java.awt.*;
import java.awt.event.*;
/*
public class ActionEventExam {

	public static void main(String[] args) {
		Frame f = new Frame("ActionEvent");

		Panel p = new Panel();
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				p.setBackground(Color.blue);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				p.setBackground(Color.yellow);
			}
		});
		p.add(b1);
		p.add(b2);


		// 패널
		f.add(p);
		f.setSize(150, 100);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        }); 	
	}
}
*/
public class ActionEventExam extends Frame implements ActionListener  {

	Button b1 = new Button("버튼1");
	Button b2 = new Button("버튼2");
	Panel p1 = new Panel();
	
	public ActionEventExam() {
		// TODO Auto-generated constructor stub
		super("ActionEvent");
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        }); 
		p1.add(b1);
		p1.add(b2);
		add(p1);
		setSize(300, 150);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionEventExam();
	}

	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == b1)
		{
			p1.setBackground(Color.blue);
		}
		if(ae.getSource() == b2)
		{
			p1.setBackground(Color.yellow);
		}
		
	}

}
