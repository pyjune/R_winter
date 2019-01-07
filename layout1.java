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
		
		// 프레임에 패널 추가..
		Panel p = new Panel();
		//p.setBackground(Color.blue);
		
		f.add(p);
		// 패널에 버튼 추가..
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		
		p.add(b1);
		p.add(b2);
		
		// 체크 박스
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
	}
}
