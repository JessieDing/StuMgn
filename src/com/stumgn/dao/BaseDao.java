package com.stumgn.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class BaseDao {
	private static String url;
	private static String driver;
	private static String user;
	private static String password;
	
	static{
		Properties properties = new Properties();
		try {
			properties.load(BaseDao.class.getResourceAsStream("/jdbc.properties"));
			url = properties.getProperty("jdbc.url");
			driver = properties.getProperty("jdbc.driver");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
			
			Class.forName(driver);//jdk 1.7 以上可省略
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	protected void openConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void closeConnection(){
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}	
