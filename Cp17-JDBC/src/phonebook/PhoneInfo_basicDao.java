package phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneInfo_basicDao {

	
	
	public List<phoneInfo_basic> basicList( Connection conn){
		
		
		
		Statement stmt=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		
		List<phoneInfo_basic> basicList=new ArrayList<phoneInfo_basic>();
		
		
		
		try {
		
			
			String sql = "select * from phoneInfo_basic";
			
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				phoneInfo_basic basic = new phoneInfo_basic(
						rs.getInt("Idx"),
						rs.getString("fr_name"),
						rs.getString("fr_phonenumber"),
						rs.getString("fr_email"),
						rs.getString("fr_address"),
						rs.getString("fr_regdate")
						);
				
				basicList.add(basic);
				
			}
			
			System.out.println("=======================================================================");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} // finally 끝

		return basicList;
			
	}
	
	
	public int basicInsert(phoneInfo_basic basic, Connection conn) {
		
		

		PreparedStatement pstmt =null;
		int resultCnt = 0;
		
		
		String sql = "insert into phoneInfo_basic values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,basic.getIdx());
			pstmt.setString(2, basic.getFr_name());
			pstmt.setString(3, basic.getFr_phonenumber());
			pstmt.setString(4, basic.getFr_email());
			pstmt.setString(5, basic.getFr_address());
			pstmt.setString(6, basic.getDate());
			
			resultCnt=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				

		} // finally 끝
		return resultCnt;
	
	}
	
	
	public int basicDelete (String dname, Connection conn) {
		
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		
		
		try {
			// conn이 sql 위에있는거임 
			String sql = "delete fom phoneInfo_basic where dname=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			
			resultCnt = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			if ( pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			if(conn!=null)
			{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
		}//finally 끝 
		
		
		
		
		return resultCnt;
	}
	
	
	public int basicEdit(phoneInfo_basic basic,Connection conn) {
		
		
		PreparedStatement pstmt=null;
		int resultCnt =0;
		
	
		try {
			String sql = "update phoneInfo_basic set fr_name=?,fr_phonenumber=?,fr_email=?,fr_address=?,date=?"
					+"where Idx=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, basic.getFr_name());
			pstmt.setString(2, basic.getFr_phonenumber());
			pstmt.setString(3, basic.getFr_email());
			pstmt.setString(4, basic.getFr_address());
			pstmt.setString(5, basic.getDate());
			
			pstmt.setInt(6, basic.getIdx());
			
			resultCnt = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}//finally 끝
		
		
		return resultCnt;
	
	}
	
	
	public phoneInfo_basic basicSearchName(String searchName, Connection conn) {
		
		
		phoneInfo_basic basic =null;
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		
	
		
		try {
			String sql = "select * from phoneInfo_basic where fr_name=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				basic = new phoneInfo_basic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return basic;
		

	}
	
	
	
	
	
	
	public List<phoneInfo_basic> basicSearch(String searchName, Connection conn) {
		
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<phoneInfo_basic> basic = new ArrayList<phoneInfo_basic>();
		
		try {
			String sql= "select * from phoneInfo_basic where fr_name=?";
			pstmt.setString(1, searchName);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				basic.add(new phoneInfo_basic(
				rs.getInt("idx"),
				rs.getString("fr_name"),
				rs.getString("fr_phonenumber"),
				rs.getString("fr_email"),
				rs.getString("fr_address"),
				rs.getString("date")
				));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			
			
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
		return basic;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
