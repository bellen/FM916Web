package com.fm916web.user;

import java.sql.SQLException;

public interface IUserDao {
	/**
	 * create a new user
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean addUser(User user) throws SQLException;

	/**
	 * get the user instance cross the userid
	 * 
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	public User getUser(String userid) throws SQLException;

	/**
	 * update the password
	 * 
	 * @param userid
	 * @param newpass
	 * @param oldpass
	 * @return
	 * @throws SQLException
	 */
	public boolean setNewPassword(String userid, String newpass, String oldpass)
			throws SQLException;

	public boolean setNewUserId(String newUserid, String userid, String pass)
			throws SQLException;

	/**
	 * check the userid is used or not
	 * 
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	public boolean isUseridExist(String userid) throws SQLException;

	/**
	 * check the user password
	 * 
	 * @param userid
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean checkPassword(String userid, String password)
			throws SQLException;

	/**
	 * remove the user from the database
	 * 
	 * @param userid
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean removeUser(String userid, String password)
			throws SQLException;
}
