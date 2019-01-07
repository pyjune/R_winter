import java.awt.*;
import java.awt.event.*;

public class FrameExam1 {

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
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		//p.setLayout(new BorderLayout());
		p.setLayout(new GridLayout(3, 1));
		f.add(p);
		//p.setBackground(Color.blue);
		p.add(p1);
		p.add(p2);
		p.add(p3);
//		p.add(p1, BorderLayout.NORTH);
//		p.add(p2, BorderLayout.CENTER);
//		p.add(p3, BorderLayout.SOUTH);
		
		// 패널에 버튼 추가..
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		
		p1.add(b1);
		p1.add(b2);
		
		// 라디오 버튼
		CheckboxGroup g = new CheckboxGroup();
		Checkbox ch1 = new Checkbox("사과", g, false);
		Checkbox ch2 = new Checkbox("딸기", g, true);
		Checkbox ch3 = new Checkbox("바나나", g, false);
		p2.add(ch1);
		p2.add(ch2);
		p2.add(ch3);
		// 체크 박스
		Checkbox ch4 = new Checkbox("사과");
		Checkbox ch5 = new Checkbox("딸기", true);
		Checkbox ch6 = new Checkbox("바나나");

		p3.add(ch4);
		p3.add(ch5);
		p3.add(ch6);
	}
}
