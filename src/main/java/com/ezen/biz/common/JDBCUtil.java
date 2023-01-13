package com.ezen.biz.common;

import java.sql.*;

public class JDBCUtil {

	public static Connection getConnection() {
		// 오라클 jdbc 드라이버를 메모리에 로드
		// 데이터베이스에 연결한 후에 연결정보(Connection)를 반환
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "spring_user";
		String pwd = "ora123";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	// SELECT문 연결 해지에 사용
	public static void close(PreparedStatement stmt, Connection conn, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}		
	// Update, Delete 문 등의 연결 해지에 사용
	public static void close(PreparedStatement stmt, Connection conn) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
