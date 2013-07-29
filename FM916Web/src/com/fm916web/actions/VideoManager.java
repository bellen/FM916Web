package com.fm916web.actions;

import java.sql.SQLException;
import java.util.List;

import com.fm916web.managers.IVideoProgram;
import com.fm916web.managers.beans.Video;
import com.fm916web.managers.impl.VideoProgramImpl;
import com.opensymphony.xwork2.ActionSupport;

public class VideoManager extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titile;
	private String url;
	private String description;
	private List videos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List getVideos() {
		return videos;
	}

	public void setVideos(List videos) {
		this.videos = videos;
	}

	/**
	 * add a Video
	 * 
	 * @return
	 */
	public String addVideo() {
		IVideoProgram iv = VideoProgramImpl.getInstance();
		Video v = new Video();
		v.setId(this.getId());
		v.setTitile(this.getTitile());
		v.setUrl(this.getUrl());
		v.setDescription(this.getDescription());
		try {
			if (iv.addVideo(v))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * remove a video
	 * 
	 * @return
	 */
	public String removeVideo() {
		IVideoProgram iv = VideoProgramImpl.getInstance();

		try {
			if (iv.removeVideo(this.getId()))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * set a video
	 * 
	 * @return
	 */
	public String setVideo() {
		IVideoProgram iv = VideoProgramImpl.getInstance();
		Video v = new Video();
		v.setId(this.getId());
		v.setTitile(this.getTitile());
		v.setUrl(this.getUrl());
		v.setDescription(this.getDescription());
		try {
			if (iv.setVideo(v))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * query a video
	 * 
	 * @return
	 */
	public String getVideo() {
		IVideoProgram iv = VideoProgramImpl.getInstance();
		try {
			Video v = iv.getVideo(this.getId());
			this.setId(v.getId());
			this.setTitile(v.getTitile());
			this.setUrl(v.getUrl());
			this.setDescription(v.getDescription());
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return ERROR;
	}

	public String getAllVideos() {
		IVideoProgram iv = VideoProgramImpl.getInstance();
		try {
			this.setVideos(iv.getVideos());
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
