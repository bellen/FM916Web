package com.fm916web.managers.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fm916web.managers.IHosterProgram;
import com.fm916web.managers.IVideoProgram;
import com.fm916web.managers.beans.Hoster;
import com.fm916web.managers.beans.Video;
import com.fm916web.provider.IDbProvider;
import com.fm916web.provider.impl.MysqlProvider;

public class VideoProgramImpl implements IVideoProgram {
	private static VideoProgramImpl instance;
	private static String TABLE_NAME = "Video";

	public static IVideoProgram getInstance() {
		// TODO multi-thread
		if (instance == null)
			instance = new VideoProgramImpl();
		return instance;
	}

	public boolean addVideo(Video video) throws SQLException {
		String sql = "insert into " + TABLE_NAME
				+ " (title, url, description) " + "value( ?, ?, ?)";
		IDbProvider ssp = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setString(1, video.getTitle());
		pstmt.setString(2, video.getUrl());
		pstmt.setString(3, video.getDescription());
		pstmt.executeUpdate();
		pstmt.getConnection().close();
		return true;
	}

	public Video getVideo(int videoid) throws SQLException {
		String sql = "select title, url, description " + " from " + TABLE_NAME
				+ " where id = ?";
		IDbProvider ssp = null;
		Video video = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setInt(1, videoid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			video = new Video();
			video.setId(videoid);
			video.setTitle(rs.getString("title"));
			video.setUrl(rs.getString("url"));
			video.setDescription(rs.getString("description"));
		} else
			return null;
		pstmt.getConnection().close();
		return video;
	}

	public List<Video> getVideos() throws SQLException {
		String sql = "select id, title, url, description " + " from "
				+ TABLE_NAME;
		IDbProvider ssp = null;
		List<Video> videos = new ArrayList<Video>();
		Video video = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			video = new Video();
			video.setId(rs.getInt("id"));
			video.setTitle(rs.getString("title"));
			video.setUrl(rs.getString("url"));
			video.setDescription(rs.getString("description"));
			videos.add(video);
		}
		pstmt.getConnection().close();
		return videos;
	}

	private boolean isVideoidExist(int videoid) throws SQLException {
		String sql = "select title" + " from " + TABLE_NAME + " where id = ?";
		IDbProvider ssp = null;

		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql);
		pstmt.setInt(1, videoid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			pstmt.getConnection().close();
			return true;
		}
		pstmt.getConnection().close();
		return false;
	}

	public boolean removeVideo(int videoid) throws SQLException {
		// DELETE FROM 表名称 WHERE 列名称 = 值
		if (!isVideoidExist(videoid))
			throw new SQLException("the video is aleardy exists!");
		String sql = "delete from " + TABLE_NAME + " where id = ? ";
		IDbProvider ssp = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);

		pstmt.setInt(1, videoid);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		pstmt.getConnection().close();
		return true;

	}

	public boolean setVideo(Video video) throws SQLException {
		if (!isVideoidExist(video.getId()))
			throw new SQLException("the video is aleardy exists!");
		String sql = "update " + TABLE_NAME
				+ " set title = ?, url = ?, description = ? " + "where id = ? ";
		IDbProvider ssp = null;
		ssp = MysqlProvider.getInstance();
		PreparedStatement pstmt = ssp.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, video.getTitle());
		pstmt.setString(2, video.getUrl());
		pstmt.setString(3, video.getDescription());
		pstmt.setInt(4, video.getId());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		pstmt.getConnection().close();
		return true;
	}

}
