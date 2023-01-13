package com.ezen.biz.common;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null; //url 데이터 베이스가 있는 위치
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uid = "ora_user";
		String pass = "ora123";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버를 통해 올려줘야함
			conn = DriverManager.getConnection(url, uid, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
		// 오라클 jdbc 드라이버를 메모리에 로드
		// 데이터베이스에 연결한 후에 연결정보(Connection)를 반환
		}
	
		// Update, Delete 문 등의 연결 해지에 사용
		public static void close(Connection conn, PreparedStatement pstmt , ResultSet rs) {
			
			try {
				if ( pstmt != null ) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				} 
				if (rs != null) {
					rs.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// SELECT문 연결 해지에 사용
		public static void close(Connection conn, Statement stmt, ResultSet rs) {

			try {
				
				if (stmt != null) {
					stmt.close();
				} 
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void close(Connection conn, PreparedStatement pstmt) {
			// TODO Auto-generated method stub
			try {
				if (conn != null) {
					conn.close();
				}
				if ( pstmt != null ) {
					pstmt.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
