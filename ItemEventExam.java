import java.awt.*;
import java.awt.event.*;

public class ItemEventExam extends Frame implements ItemListener{
	Panel p1 = new Panel();
	TextArea ta = new TextArea(7, 15);
	Checkbox cb1 = new Checkbox( );
	Checkbox cb2 = new Checkbox( );
	Checkbox cb3 = new Checkbox( );
	
	public ItemEventExam() {
		// TODO Auto-generated constructor stub
		super("ItemEvent");
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });
		p1.add( );
		p1.add( );
		p1.add( );
		add(p1, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
		
		cb1.addItemListener( );
		cb2.addItemListener( );
		cb3.addItemListener( );
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ItemEventExam();
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED)
			ta.append(ie.getItem() + "가 선택됨\n");
		else if(ie.getStateChange() == ItemEvent.DESELECTED)
			ta.append(ie.getItem() + "가 취소됨\n");
			
	}

}
