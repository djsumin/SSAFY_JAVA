package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Mysql DB ���� ��ü�� �������ְ�, ����ߴ� �ڿ��� �����ϴ� ����� �����ϴ� Ŭ�����Դϴ�.
 */
public class DBUtil {
	/**
     * DB ���ӿ� �ʿ��� url�� �ۼ��Ѵ�.
     * url�� jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]���·� �ۼ��Ѵ�.
     * serverTimezone=UTC ������ ������ ������ �߻��ϹǷ� �����Ѵ�.
     */
	// DB�� �����ϱ����� �ʿ��� DB�� URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	// DB�� USER �̸�
	private final String username = "ssafy";
	// �� USER�� PASSWORD
	private final String password = "ssafy";
	// Mysql ����̹� Ŭ���� �̸�
	private final String driverName = "com.mysql.cj.jdbc.Driver";

	/**
     * Singleton Design Pattern�� �������ش�.
     */
    private static DBUtil instance = new DBUtil();

    private DBUtil() {
        // JDBC ����̹��� �ε��Ѵ�. ����̹� �ε��� ��ü ���� �� �ѹ��� �����ϵ��� ����.
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBUtil getInstance() {
        return instance;
    }
    /**
     * DriverManager�� ���� Connection�� �����ϰ� ��ȯ�Ѵ�.
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(url, username, password);
    }

//	public static void close(Connection conn, PreparedStatement pstmt) {
//		try {
//			if (pstmt != null)
//				pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
//		try {
//			if (rs != null)
//				rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			if (pstmt != null)
//				pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
     * ����� ���ҽ����� �����Ѵ�.
     * Connection, Statement, ResultSet ��� AutoCloseable Ÿ���̴�.
     * ... �� �̿��ϹǷ� �ʿ信 ����
     * select �迭 ȣ�� �Ĵ� ResultSet, Statement, Connection
     * dml ȣ�� �Ĵ� Statement, Connection �� �پ��� �������� ����� �� �ִ�.
     *
     * @param closeables
     */
    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
