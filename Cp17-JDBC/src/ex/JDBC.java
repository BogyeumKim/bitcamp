package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Connection conn=null;
		Statement stmt =null;
		ResultSet rs = null;
		Scanner kb = new Scanner(System.in);
		
		
		String sql=null;
		int resultCnt=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			
			System.out.println("1.사원관리 \t 2.부서관리 ");
			int num = kb.nextInt();
			switch(num) {
				
			case 1:

				
				System.out.println("1. 입력 ,2. 수정, 3.삭제 , 4.리스트, 5.검색");
				int key = kb.nextInt();
				
				
				switch (key) {
				case 1:   // 입력
					conn = DriverManager.getConnection(url, user, pw);
					
					kb.nextLine();
					
					System.out.println("추가할 정보를 입력하세요");
					
					System.out.println("사원번호");
					int insert_empno = kb.nextInt();
					System.out.println(insert_empno);
					kb.nextLine();
					
					System.out.println("사원이름");
					String insert_ename = kb.nextLine();
					kb.nextLine();
					System.out.println(insert_ename);
					
					
					
					System.out.println("직무");
					String insert_job = kb.nextLine();
					
					System.out.println("매니저");
					int insert_mgr = kb.nextInt();
					
					
					kb.nextLine();
					System.out.println("입사일");
					String insert_hiredate = kb.nextLine();
					kb.nextLine();
					
					System.out.println("급여");
					int insert_sal = kb.nextInt();
					
					System.out.println("수당");
					int insert_comm = kb.nextInt();
					
					System.out.println("부서번호");
					int insert_deptno = kb.nextInt();
					
					
					
					stmt = conn.createStatement();
					
					sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)"
	+ "values('"+insert_empno+"','"+insert_ename+"','"+insert_job+"','"+insert_mgr+"','"+insert_hiredate+"','"+insert_sal+"','"+insert_comm+"','"+insert_deptno+"')";
					
				
					
					resultCnt = stmt.executeUpdate(sql); // DML(인서트,업뎃,삭제시)
					System.out.println(resultCnt+"개 행이 입력됐습니다.");
					System.out.println(sql);
					
					
					stmt.close();
					conn.close();
					
					break;

					
				case 2: // 수정
					
					conn = DriverManager.getConnection(url, user, pw);
					
					kb.nextLine();
					System.out.println("수정하고싶은 정보의 이름을 입력하세요");
					String search_ename = kb.nextLine();
		
			
					System.out.println("수정할 이름을 입력하세요");
					String up_ename = kb.nextLine();
					System.out.println("수정할 부서번호를 입력하세요");
					int up_empno = kb.nextInt();
					System.out.println("수정할 급여를 입력하세요");
					int up_sal = kb.nextInt();
					System.out.println("수정할 수당을 입력하세요");
					int up_comm = kb.nextInt();
					System.out.println("수정할 매니저번호를 입력하세요");
					int up_mgr = kb.nextInt();
					kb.hasNextLine();
					
					
					stmt = conn.createStatement();
					
					
					sql = "update emp "
							+"set ename='"+up_ename+"', empno='"+up_empno+"', sal='"+up_sal+"',comm='"+up_comm+"',mgr='"+up_mgr+"' "
							+"where ename='"+search_ename+"'";
					
					resultCnt = stmt.executeUpdate(sql); // DML(인서트,업뎃,삭제시)
					System.out.println(resultCnt+"개 행이 업데이트됐습니다.");
					System.out.println(sql);
					
					
					stmt.close();
					conn.close();
					
					
					
					break;
					
					
				case 3: // 삭제
					
					conn = DriverManager.getConnection(url, user, pw);
					
					kb.nextLine();
					
					System.out.println("삭제하고싶은 정보의 사원번호를 입력하세요");
					int search_empno = kb.nextInt();
					
					stmt = conn.createStatement();
					
					sql = "delete from emp where empno='"+search_empno+"'";
					
			
					stmt.executeUpdate(sql);
					System.out.println(sql);
					
					
					stmt.close();
					conn.close();
					
					break;
					
				case 4: // 리스트
					
					conn = DriverManager.getConnection(url, user, pw);
					
					System.out.println("전체 리스트를 출력합니다");
					
					stmt = conn.createStatement();
					
					sql ="select * from emp";
					
					stmt.executeUpdate(sql);
					rs = stmt.executeQuery(sql);
					
					
					System.out.println("사원리스트");
					System.out.println("---------------------------");
					System.out.println("EMPNO \t ENAME \t JOB \t MGR \t HIREDATE \t SAL \t COMM \t DEPTNO ");
					System.out.println("---------------------------");
					
					
					while(rs.next()) {
						
			System.out.println(rs.getInt(1) +"\t" + rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\n");
			
						
					}
					
					rs.close();
					stmt.close();
					conn.close();
					
					
					break;
					
				case 5: // 검색
					
					kb.nextLine();
					
					conn = DriverManager.getConnection(url, user, pw);
					
					
					System.out.println("검색하고자 하는 사원의 이름을 입력하세요");
					search_ename = kb.nextLine();
					
					stmt = conn.createStatement();
					
					
					sql = "select * from emp where ename='"+search_ename+"'";
					
					
					stmt.executeQuery(sql);
					rs = stmt.executeQuery(sql);
					
					
					System.out.println("사원리스트");
					System.out.println("---------------------------");
					System.out.println("EMPNO \t ENAME \t JOB \t MGR \t HIREDATE \t SAL \t COMM \t DEPTNO ");
					System.out.println("---------------------------");
					

					while(rs.next()) {
						
			System.out.println(rs.getInt(1) +"\t" + rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\n");
			
						
					}
					
					rs.close();
					stmt.close();
					conn.close();
					
					break;
					
					
					
				default:
					break;
				}
				
				
				
				
			case 2:
			
				System.out.println("1. 입력 ,2. 수정, 3.삭제 , 4.리스트, 5.검색");
				int key2 = kb.nextInt();
				
				
				switch (key2) {
				case 1:   // 입력
					conn = DriverManager.getConnection(url, user, pw);
					
					kb.nextLine();
					
					System.out.println("추가할 정보를 입력하세요");
					
					System.out.println("부서번호");
					int insert_deptno = kb.nextInt();
					kb.nextLine();
					
					System.out.println("부서이름");
					String insert_dname = kb.nextLine();
					kb.nextLine();
				
					
					
					
					System.out.println("지역");
					String insert_loc = kb.nextLine();
					
					
					stmt = conn.createStatement();
					
					sql = "insert into dept (deptno,dname,loc)"
	+ "values('"+insert_deptno+"','"+insert_dname+"','"+insert_loc+"')";
					
				
					
					resultCnt = stmt.executeUpdate(sql); // DML(인서트,업뎃,삭제시)
					System.out.println(resultCnt+"개 행이 입력됐습니다.");
					System.out.println(sql);
					
					
					stmt.close();
					conn.close();
					
					break;

				
				case 2: // 수정
					
					conn = DriverManager.getConnection(url, user, pw);
					
					kb.nextLine();
					System.out.println("수정하고싶은 부서의 이름을 입력하세요");
					String search_dname = kb.nextLine();
		
			
					System.out.println("수정할 부서의 이름을 입력하세요");
					String up_dname = kb.nextLine();
					System.out.println("수정할 부서의 위치를 입력하세요");
					String up_loc = kb.nextLine();
					
					
					
					stmt = conn.createStatement();
					
					
					sql = "update dept "
							+"set dname='"+up_dname+"', loc='"+up_loc+"'"
							+"where dname='"+search_dname+"'";
					
					resultCnt = stmt.executeUpdate(sql); // DML(인서트,업뎃,삭제시)
					System.out.println(resultCnt+"개 행이 업데이트됐습니다.");
					System.out.println(sql);
					
					
					stmt.close();
					conn.close();
					
					
					
					break;
					
					
				case 3: // 삭제
					
					conn = DriverManager.getConnection(url, user, pw);
					
					kb.nextLine();
					
					System.out.println("삭제하고싶은 부서번호를 입력하세요");
					int search_deptno = kb.nextInt();
					
					stmt = conn.createStatement();
					
					sql = "delete from dept where deptno='"+search_deptno+"'";
					
			
					stmt.executeUpdate(sql);
					System.out.println(sql);
					
					
					stmt.close();
					conn.close();
					
					break;
					
				case 4: // 리스트
					
					conn = DriverManager.getConnection(url, user, pw);
					
					System.out.println("전체 리스트를 출력합니다");
					
					stmt = conn.createStatement();
					
					sql ="select * from dept";
					
					stmt.executeUpdate(sql);
					rs = stmt.executeQuery(sql);
					
					
					System.out.println("부서리스트");
					System.out.println("---------------------------");
					System.out.println("DEPTNO \t DNAME \t LOC");
					System.out.println("---------------------------");
					
					
					while(rs.next()) {
						
			System.out.println(rs.getInt(1) +"\t" + rs.getString(2)+"\t"+rs.getString(3)+"\n");
			
						
					}
					
					rs.close();
					stmt.close();
					conn.close();
					
					
					break;
					
				case 5: // 검색
					
					kb.nextLine();
					
					conn = DriverManager.getConnection(url, user, pw);
					
					
					System.out.println("검색하고자 하는 사원의 이름을 입력하세요");
					search_dname = kb.nextLine();
					
					stmt = conn.createStatement();
					
					
					sql = "select * from dept where dname='"+search_dname+"'";
					
					
					stmt.executeQuery(sql);
					rs = stmt.executeQuery(sql);
					
					
					
					System.out.println("부서리스트");
					System.out.println("---------------------------");
					System.out.println("DEPTNO \t DNAME \t LOC");
					System.out.println("---------------------------");
					
					
					while(rs.next()) {
						
			System.out.println(rs.getInt(1) +"\t" + rs.getString(2)+"\t"+rs.getString(3)+"\n");
			
						
					}
					
					rs.close();
					stmt.close();
					conn.close();
					
					break;
					
					
					
				default:
					break;
				}
				
				
				
				
			}
			

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
