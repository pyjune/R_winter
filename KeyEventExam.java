import java.awt.*;
import java.awt.event.*;

public class KeyEventExam extends Frame implements KeyListener {
	TextField jumin1  = new TextField(10);
	Label lb = new Label("-", Label.CENTER);
	TextField jumin2 = new TextField(10);
	Panel p = new Panel();
	
	public KeyEventExam() {
		// TODO Auto-generated constructor stub
		super("KeyEvent");
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });
		p.add(jumin1);
		p.add(lb);
		p.add(jumin2);
		add(p);
		setSize(300, 100);
		setVisible(true);
		
		jumin1.addKeyListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEventExam();
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		if(ke.getKeyCode() == ke.VK_LEFT) {
			jumin2.setText("Left 눌림");
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		if(jumin1.getText().trim().length() == 6)
			jumin2.requestFocus();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
