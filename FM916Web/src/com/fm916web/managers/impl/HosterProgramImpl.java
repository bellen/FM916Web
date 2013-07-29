package com.fm916web.managers.impl;

import java.sql.SQLException;
import java.util.List;

import com.fm916web.managers.IAudioProgram;
import com.fm916web.managers.IHosterProgram;
import com.fm916web.managers.beans.Hoster;

public class HosterProgramImpl implements IHosterProgram {
	private static HosterProgramImpl instance;

	public static IHosterProgram getInstance() {
		// TODO multi-thread
		if (instance == null)
			instance = new HosterProgramImpl();
		return instance;
	}

	public boolean addHoster(Hoster hoster) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Hoster getHoster(String hosterid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Hoster> getHosters() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isHosteridExist(String hosterid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeHoster(String hosterid, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
