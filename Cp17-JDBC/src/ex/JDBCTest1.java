package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		
		//1. DB 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Oracle 드라이버 로드 중... ");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		
		// 데이터베이스에 접속
	
			conn = DriverManager.getConnection(url, user, pw);
	
		System.out.println("데이터베이스 접속성공");
		
		//트레젝션 설정
		conn.setAutoCommit(false);
		
		
		
		//3. sql 로 데이터 처리부분
		
		
		
		
		
		// commit : 처리완료
		conn.commit();
		
		
		//4. close
		
		conn.close();
		
		
		
		
	}

}
