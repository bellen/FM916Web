package com.fm916web.managers.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fm916web.managers.IAudioProgram;
import com.fm916web.managers.IHosterProgram;
import com.fm916web.managers.beans.Hoster;
import com.fm916web.provider.IDbProvider;
import com.fm916web.provider.impl.MysqlProvider;
import com.fm916web.user.User;

public class HosterProgramImpl implements IHosterProgram {
	private static HosterProgramImpl instance;
	static String TABLE_NAME = "Hoster";

	public static IHosterProgram getInstance() {
		// TODO multi-thread
		if (instance == null)
			instance = new HosterProgramImpl();
		return instance;
	}

	public boolean addHoster(Hoster hoster) throws SQLException {
		String sql = "insert into " + TABLE_NAME
				+ " name, icon, description, audio" + "value( ?, ?, ?, ?)";
		IDbProvider ssp = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setString(1, hoster.getName());
		pstmt.setString(2, hoster.getIcon());
		pstmt.setString(3, hoster.getDescription());
		pstmt.setString(4, hoster.getAudio());
		pstmt.executeUpdate();
		pstmt.getConnection().close();
		return true;
	}

	public Hoster getHoster(int hosterid) throws SQLException {
		String sql = "select name, icon, description, audio" + " from ["
				+ TABLE_NAME + "]" + " where hosterid = ?";
		IDbProvider ssp = null;
		Hoster hoster = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setInt(1, hosterid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			hoster = new Hoster();
			hoster.setId(hosterid);
			hoster.setName(rs.getString("name"));
			hoster.setIcon(rs.getString("icon"));
			hoster.setDescription(rs.getString("description"));
			hoster.setAudio(rs.getString("audio"));
		} else
			return null;
		pstmt.getConnection().close();
		return hoster;
	}

	public List<Hoster> getHosters() throws SQLException {
		String sql = "select id, name, icon, description, audio" + " from ["
				+ TABLE_NAME + "]" + " where hosterid = ?";
		IDbProvider ssp = null;
		List<Hoster> hosters = new ArrayList<Hoster>();
		Hoster hoster = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			hoster = new Hoster();
			hoster.setId(rs.getInt("id"));
			hoster.setName(rs.getString("name"));
			hoster.setIcon(rs.getString("icon"));
			hoster.setDescription(rs.getString("description"));
			hoster.setAudio(rs.getString("audio"));
			hosters.add(hoster);
		}
		pstmt.getConnection().close();
		return hosters;
	}

	public boolean isHosteridExist(int hosterid) throws SQLException {
		String sql = "select id" + " from [" + TABLE_NAME + "]"
				+ " where id = ?";
		IDbProvider ssp = null;

		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setInt(1, hosterid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			pstmt.getConnection().close();
			return true;
		}
		pstmt.getConnection().close();
		return false;
	}

	public boolean removeHoster(Hoster hoster) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setHoster(Hoster hoster) throws SQLException {
		if (!isHosteridExist(hoster.getId()))
			throw new SQLException("the user or password is not exist!");
		String sql = "update user set name=?, icon=?, description=?, audio=? "
				+ "where id=? ";
		IDbProvider ssp = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, hoster.getName());
		pstmt.setString(2, hoster.getIcon());
		pstmt.setString(3, hoster.getDescription());
		pstmt.setString(4, hoster.getAudio());
		pstmt.setInt(5, hoster.getId());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		pstmt.getConnection().close();
		return true;
	}

}
