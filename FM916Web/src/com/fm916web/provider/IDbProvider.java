package com.fm916web.provider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbProvider {
	public Connection getConnection() throws SQLException;

	public String getConnectionString();

	public ResultSet executeQuery(String query) throws SQLException;

	public void execute(String text) throws SQLException;

	public void closeConnection() throws SQLException;
}
