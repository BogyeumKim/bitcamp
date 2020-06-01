package ex;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest3emp {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		ResultSet rs = null;
		
		
		
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
			Statement stmt = conn.createStatement();
			
			
			Scanner kb = new Scanner(System.in);
			
			System.out.println("회원의 이름을 입력하세요.");
			String searchName = kb.nextLine();
			
			
			
			String sql = "select * from emp";
			String sql1 =  "select o.orderid, c.name,b.bookname from customer c, book b, orders o "
					+ " where c.custid=o.custid and b.bookid=o.bookid"
					+ " and c.name='"+searchName+"'";
			
			
			System.out.println("sql :" + sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			
			
			// Select 의 결과는 ResultSet 이 받는다.
			// excuteQuery(sql문) -> ResultSet
//			rs = stmt.executeQuery(sql);
			rs = stmt.executeQuery(sql1);
			
			
			//ResultSet : next() -> 행의 존재 유무 확인 
			
//			System.out.println("사원리스트");
//			System.out.println("----------------------");
//			System.out.println("사원번호\t사원이름\t직급");
//			System.out.println("----------------------");
			
			System.out.println("판매리스트");
			System.out.println("---------------------------");
			System.out.println("판매 아이디 \t 회원이름 \t 책이름");
			System.out.println("---------------------------");
			
			
			while(rs.next()) {
//				System.out.print(rs.getInt("empno")+ "\t");
//				System.out.print(rs.getString("ename")+"\t");
//				System.out.print(rs.getString("sal")+"\n");	
				System.out.print(rs.getInt(1)+ "\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\n");	
//				System.out.print(rs.getString(4)+"\t");
//				System.out.print(rs.getString(5)+"\n");	
			}
			
			rs.close();
			stmt.close();
						
			
			//4. close
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
