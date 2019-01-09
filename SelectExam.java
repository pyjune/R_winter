import java.sql.*;

public class SelectExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// JDBC ����̹� ����
		try {
			Class.forName("org.gjt.mm.mysql.Driver"); //com.mysql.jdbc.Driver		
		} catch(ClassNotFoundException ee) {
			System.err.println("DB ���� ����̹��� ����.");
		}
		
		// DB ���� ����
		Connection conn = null;
		String url =  "jdbc:mysql://127.0.0.1:3306/exam";
		String id = "root";
		String pw = "12345678";
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch(SQLException ee) {
			System.err.println("DB ���� ���� ����");
		}
		
		// ��ɾ� ó�� Statement ��ü ����
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch(SQLException ee) {
			System.err.println("�۾� ó�� ���� ����");
		}
		// ����
		try {
			int num = stmt.executeUpdate("delete from t1 where name = '��ģ��'");
			System.out.println(num+"���� ���� ����");
		} catch (SQLException ee) {
			System.err.println("��ɾ� ���� ����"+ee.toString());
		}
		// ����
		try {
			int num = stmt.executeUpdate("insert into t1 values ('��ģ��',10,14,'���','02-111-1234', true, false, false, false)");
			System.out.println(num+"���� ���� ����");
		} catch (SQLException ee) {
			System.err.println("��ɾ� ���� ����"+ee.toString());
		}
		// ��ȸ
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from t1");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException ee) {
			System.err.println("��ɾ� ���� ����" + ee.toString());
		}
		// ���� ����
		try {
			rs.close(); // ResultSet�� ����� ���
			stmt.close();
			conn.close();
		} catch(SQLException ee) {
			System.err.println("���� ���� ����"+ee.toString());
		}
	}

}
