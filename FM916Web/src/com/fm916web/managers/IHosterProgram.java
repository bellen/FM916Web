package com.fm916web.managers;

import java.sql.SQLException;
import java.util.List;

import com.fm916web.managers.beans.Hoster;

public interface IHosterProgram {
	/**
	 * create a new hoster
	 * 
	 * @param hoster
	 * @return
	 * @throws SQLException
	 */
	public boolean addHoster(Hoster hoster) throws SQLException;

	/**
	 * get the hoster instance cross the hosterid
	 * 
	 * @param hosterid
	 * @return
	 * @throws SQLException
	 */
	public Hoster getHoster(String hosterid) throws SQLException;

	/**
	 * get the hoster instance cross the hosterid
	 * 
	 * @param hosterid
	 * @return
	 * @throws SQLException
	 */
	public List<Hoster> getHosters() throws SQLException;

	/**
	 * check the hosterid is used or not
	 * 
	 * @param hosterid
	 * @return
	 * @throws SQLException
	 */
	public boolean isHosteridExist(String hosterid) throws SQLException;

	/**
	 * remove the hoster from the database
	 * 
	 * @param hosterid
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean removeHoster(String hosterid, String password)
			throws SQLException;
}
