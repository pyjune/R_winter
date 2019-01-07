import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBoxExam extends Frame {

	public CheckBoxExam () {
		super("체크박스");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
		
		Panel p = new Panel();
		// 라디오 버튼
		CheckboxGroup g = new CheckboxGroup();
		Checkbox ch1 = new Checkbox("사과", g, false);
		Checkbox ch2 = new Checkbox("딸기", g, true);
		Checkbox ch3 = new Checkbox("바나나", g, false);
		// 체크 박스
		Checkbox ch4 = new Checkbox("사과");
		Checkbox ch5 = new Checkbox("딸기", true);
		Checkbox ch6 = new Checkbox("바나나");
		p.add(ch1);
		p.add(ch2);
		p.add(ch3);
		p.add(ch4);
		p.add(ch5);
		p.add(ch6);
		add(p);
		setSize(400, 100);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxExam();
	}

}
