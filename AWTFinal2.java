import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AWTFinal2 extends Frame implements ActionListener {
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	Panel p4 = new Panel();
	Panel p5 = new Panel();
	Panel p6 = new Panel();
	
	Label lb_name = new Label("이 름");
	TextField tf_name = new TextField(10);
	Button bt_search = new Button("검색");
	Label lb_birth = new Label("생 일");
	Choice ch_month = new Choice();
	Label lb_month = new Label("월");
	Choice ch_day = new Choice();
	Label lb_day = new Label("일");
	CheckboxGroup gr = new CheckboxGroup();
	Checkbox cb1 = new Checkbox("양력", gr, true);
	Checkbox cb2 = new Checkbox("음력", gr, false);
	Label lb_phone = new Label("전화번호");
	TextField tf_phone = new TextField(30);
	Label lb_group = new Label("그 룹:");
	Checkbox cb_g1 = new Checkbox("학 교", true);
	Checkbox cb_g2 = new Checkbox("학 원");
	Checkbox cb_g3 = new Checkbox("동 네");
	Checkbox cb_g4 = new Checkbox("기 타");
	Button bt_save = new Button("저장");
	Button bt_delete = new Button("삭제");
	Button bt_modify = new Button("수정");
	TextArea ta = new TextArea(2, 40);
	
	public AWTFinal2() {
		// TODO Auto-generated constructor stub
		super("친구정보");
		
		p1.add(lb_name);
		p1.add(tf_name);
		p1.add(bt_search);
		ch_month.setSize(new Dimension(100, 30));
		for(int i = 1; i<=12; i++) {
			ch_month.addItem(Integer.toString(i));
		}
		for(int i = 1; i <= 31; i++) {
			ch_day.addItem(Integer.toString(i));
		}
		p2.add(lb_birth);
		p2.add(ch_month);
		p2.add(lb_month);
		p2.add(ch_day);
		p2.add(lb_day);
		p2.add(cb1);
		p2.add(cb2);
		p3.add(lb_phone);
		p3.add(tf_phone);
		p4.add(lb_group);
		p4.add(cb_g1);
		p4.add(cb_g2);
		p4.add(cb_g3);
		p4.add(cb_g4);
		p5.add(bt_save);
		p5.add(bt_delete);
		p5.add(bt_modify);
		p6.setLayout(new GridLayout(4, 1));
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(ta);
		
		add(p1, BorderLayout.NORTH);
		add(p6, BorderLayout.CENTER);
		add(p5, BorderLayout.SOUTH);
		
		setSize(350, 250);
		setVisible(true);
		
		addWindowListener(new MyClass());
		bt_save.addActionListener(this);
		bt_modify.addActionListener(this);
		bt_delete.addActionListener(this);
		bt_search.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AWTFinal2();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String str_name = tf_name.getText();
		String str_month = ch_month.getSelectedItem();
		String str_day = ch_day.getSelectedItem();
		String str_cb = null;
		// 체크박스 - 양력/음력
		if(cb1.getState())
			str_cb = cb1.getLabel();
		else
			str_cb = cb2.getLabel();
		String str_phone = tf_phone.getText();
		String str_group = "";
		// 체크박스 -그룹
		if(cb_g1.getState())
			str_group = str_group + cb_g1.getLabel();
		if(cb_g2.getState())
			str_group = str_group + cb_g2.getLabel();
		if(cb_g3.getState())
			str_group = str_group + cb_g3.getLabel();
		if(cb_g4.getState())
			str_group = str_group + cb_g4.getLabel();
		// JDBC 드라이버 연결
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.err.println("DB 연결드라이버가 없음.");
		}
		
		// DB 서버 연결
		Connection conn = null;
		String url =  "jdbc:mysql://127.0.0.1:3306/exam";
		String id = "root";
		String pw = "12345678";
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch(SQLException ee) {
			System.err.println("DB 서버 연결 실패");
		}
		
		// 명령어 처리 Statement 객체 생성
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch(SQLException ee) {
			System.err.println("작업 처리 생성 실패");
		}
		
		ResultSet rs = null;
		// 검색 버튼이 눌린 경우
		if(ae.getSource() == bt_search) {
			cb1.setState(false);
			cb_g1.setState(false);
			cb_g3.setState(false);
			cb_g4.setState(false);
			try {
				rs = stmt.executeQuery("select * from t1 where name = '"+str_name+"'");
				if(rs.next()) {
					ch_month.select(rs.getString("month"));
					ch_day.select(rs.getString("day"));
					if(rs.getString("birth_option").equals("양력")) {
						cb1.setState(true);
					}else {
						cb2.setState(true);
					}
				}
				tf_phone.setText(rs.getString("phone"));
				if(rs.getString("group1").equals("1")) {
					cb_g1.setState(true);
				}
				if(rs.getString("group2").equals("1")) {
					cb_g2.setState(true);
				}
				if(rs.getString("group3").equals("1")) {
					cb_g3.setState(true);
				}
				if(rs.getString("group4").equals("1")) {
					cb_g4.setState(true);
				}
			}
			catch (SQLException ee) {
				System.err.println("검색 명령어 전송 실패" + ee.toString());
			}
		}else if(ae.getSource() == bt_save) { // 저장
			
		}else if(ae.getSource() == bt_modify) { // 수정
			try{
				int num = stmt.executeUpdate("update t1 set month="+str_month
										+", day ="+str_day
										+", birth_option = '"+str_cb+"'"
										+", phone = '"+str_phone+"'"
										+", group1 = "+cb_g1.getState()
										+", group2 = "+cb_g2.getState()
										+", group3 = "+cb_g3.getState()
										+", group4 = "+cb_g4.getState()
										+" where name ='"+str_name+"'");
				System.out.println(num+"개의 수정 성공");
			}catch(SQLException ee){
				System.err.println("명령어 전송 실패"+ee.toString());
			}
		}else if(ae.getSource() == bt_delete) { // 삭제
			
		}
		try {
			stmt.close();
			conn.close();
		} catch(SQLException ee) {
			System.err.println("접속 종료 실패" + ee.toString());
		}
			
	}
	class MyClass extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
