package com.fm916web.provider.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fm916web.provider.IDbProvider;

public class MysqlProvider implements IDbProvider {
	public static String URL = "jdbc:mysql://localhost:3306/";
	private String connString;
	private String user;
	private String password;
	private Connection conn;

	public static IDbProvider getInstance() {
		return new MysqlProvider("fm916web", "root", "root");
	}

	private MysqlProvider(String dbName, String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.connString = URL + dbName;
		this.user = user;
		this.password = pass;
	}

	public Connection getConnection() throws SQLException {
		if (this.conn == null || this.conn.isClosed())
			this.conn = DriverManager.getConnection(this.connString, this.user,
					this.password);
		return this.conn;

	}

	public String getConnectionString() {
		return this.connString;
	}

	public ResultSet executeQuery(String query) throws SQLException {

		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public void execute(String text) throws SQLException {
		Statement stmt;
		try {
			stmt = this.getConnection().createStatement();
			stmt.executeUpdate(text);
			System.out.println("Excute:" + text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConnection() throws SQLException {
		this.conn.close();

	}

}
