package com.fm916web.managers;

import java.sql.SQLException;
import java.util.List;

import com.fm916web.managers.beans.Video;

public interface IVideoProgram {
	/**
	 * create a new video
	 * 
	 * @param video
	 * @return
	 * @throws SQLException
	 */
	public boolean addVideo(Video video) throws SQLException;

	/**
	 * get the video instance cross the videoid
	 * 
	 * @param videoid
	 * @return
	 * @throws SQLException
	 */
	public Video getVideo(String videoid) throws SQLException;

	/**
	 * get the video instance cross the videoid
	 * 
	 * @param videoid
	 * @return
	 * @throws SQLException
	 */
	public List<Video> getVideos() throws SQLException;

	/**
	 * check the videoid is used or not
	 * 
	 * @param videoid
	 * @return
	 * @throws SQLException
	 */
	public boolean isVideoidExist(String videoid) throws SQLException;

	/**
	 * remove the video from the database
	 * 
	 * @param videoid
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean removeVideo(String videoid, String password)
			throws SQLException;
}
