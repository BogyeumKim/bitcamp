package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() {
		// 2. �����ͺ��̽� ����
		Connection conn = null;

		// String url = "jdbc:oracle:thin:@�ּ�:��Ʈ:�����ͺ��̽��̸�";
		// �ּ� : localhost or 127.0.0.1
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";

		// Connection ��ü ����
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}