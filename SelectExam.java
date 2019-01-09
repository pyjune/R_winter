import java.sql.*;

public class SelectExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// JDBC 드라이버 연결
		try {
			Class.forName("org.gjt.mm.mysql.Driver"); //com.mysql.jdbc.Driver		
		} catch(ClassNotFoundException ee) {
			System.err.println("DB 연결 드라이버가 없음.");
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
		// 삭제
		try {
			int num = stmt.executeUpdate("delete from t1 where name = '김친구'");
			System.out.println(num+"개의 삭제 성공");
		} catch (SQLException ee) {
			System.err.println("명령어 전송 실패"+ee.toString());
		}
		// 삽입
		try {
			int num = stmt.executeUpdate("insert into t1 values ('김친구',10,14,'양력','02-111-1234', true, false, false, false)");
			System.out.println(num+"개의 삽입 성공");
		} catch (SQLException ee) {
			System.err.println("명령어 전송 실패"+ee.toString());
		}
		// 조회
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from t1");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException ee) {
			System.err.println("명령어 전송 실패" + ee.toString());
		}
		// 접속 종료
		try {
			rs.close(); // ResultSet을 사용한 경우
			stmt.close();
			conn.close();
		} catch(SQLException ee) {
			System.err.println("접속 종료 실패"+ee.toString());
		}
	}

}
