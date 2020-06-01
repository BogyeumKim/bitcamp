package ex;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest4insert {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		
		//1. DB 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Oracle 드라이버 로드 중... ");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			// 데이터베이스에 접속
		
			conn = DriverManager.getConnection(url, user, pw);
		
			System.out.println("데이터베이스 접속성공");
			
			
			
			
			//3. sql 로 데이터 처리부분
			
			
			// Statement : connection
			
			stmt = conn.createStatement();
			
			String sql = "insert into dept ( deptno, dname, loc)"
					+ " values (90,'son','UK')";
			
			
			int resultCnt = stmt.executeUpdate(sql); // DML(인서트,업뎃,삭제시)
			System.out.println(resultCnt+"개 행이 입력됐습니다.");
			
			
			
			
		
						
			
			//4. close
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
