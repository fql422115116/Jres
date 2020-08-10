package com.oracle.hrb.maven.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 新版的MySQL的JDBC驱动包多了一个cj
				String driver = "com.mysql.cj.jdbc.Driver";
				// 新版的MySQL的JDBC驱动的URL需要指定时区
				String url = "jdbc:mysql://localhost:3306/java1915?serverTimezone=Asia/Shanghai";
				String username = "root";
				String password = "root";
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, username, password);
				System.out.println(conn);
			}
	}

