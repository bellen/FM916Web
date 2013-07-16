package com.fm916web.user.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fm916web.provider.IDbProvider;
import com.fm916web.provider.impl.MysqlProvider;
import com.fm916web.user.IUserDao;
import com.fm916web.user.User;

public class UserDaoImp implements IUserDao {
	private static UserDaoImp instance;

	public static IUserDao getInstance() {
		// TODO multi-thread
		if (instance == null)
			instance = new UserDaoImp();
		return instance;
	}

	public boolean addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(String userid) throws SQLException {
		String sql = "select username, password, permission, language"
				+ " from [user]" + " where userid = ?";
		IDbProvider ssp = null;
		User user = null;

		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new User(userid, rs.getString(1), rs.getString(2),
					rs.getInt(3), rs.getInt(4));
		} else
			return null;
		pstmt.getConnection().close();
		return user;
	}

	public boolean setNewPassword(String userid, String newpass, String oldpass)
			throws SQLException {
		if (!checkPassword(userid, oldpass))
			throw new SQLException("the user or password is not exist!");
		String sql = "update user set password = ? " + "where userid=?";
		IDbProvider ssp = null;

		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, newpass);
		pstmt.setString(2, userid);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		pstmt.getConnection().close();
		return true;
	}

	public boolean setNewUserId(String newUserid, String userid, String pass)
			throws SQLException {
		if (!checkPassword(userid, pass))
			throw new SQLException("the user or password is not exist!");
		String sql = "update user set userid = ? "
				+ "where userid=? and password=?";
		IDbProvider ssp = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, newUserid);
		pstmt.setString(2, userid);
		pstmt.setString(3, pass);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		pstmt.getConnection().close();
		return true;
	}

	public boolean isUseridExist(String userid) throws SQLException {
		String sql = "select userid" + " from [user]" + " where userid = ?";
		IDbProvider ssp = null;

		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			pstmt.getConnection().close();
			return true;
		}
		pstmt.getConnection().close();
		return false;
	}

	public boolean checkPassword(String userid, String password)
			throws SQLException {
		String sql = "select  password" + " from user" + " where userid = ?";
		IDbProvider ssp = null;

		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String databasepass = rs.getString(1);
			if (databasepass.equals(password)) {
				pstmt.getConnection().close();
				return true;
			}
		}
		pstmt.getConnection().close();
		return false;
	}

	public boolean removeUser(String userid, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
