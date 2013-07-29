package com.fm916web.managers.impl;

import java.sql.SQLException;
import java.util.List;

import com.fm916web.managers.IHosterProgram;
import com.fm916web.managers.IVideoProgram;
import com.fm916web.managers.beans.Video;

public class VideoProgramImpl implements IVideoProgram {
	private static VideoProgramImpl instance;

	public static IVideoProgram getInstance() {
		// TODO multi-thread
		if (instance == null)
			instance = new VideoProgramImpl();
		return instance;
	}

	public boolean addVideo(Video video) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Video getVideo(int videoid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Video> getVideos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isVideoidExist(String videoid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeVideo(int videoid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setVideo(Video video) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
