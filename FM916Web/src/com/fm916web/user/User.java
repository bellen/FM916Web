package com.fm916web.user;

public class User {

	private String userid;
	private String username;
	private String password;

	public User() {

	}

	public User(String userid, String username, String password,
			int permission, int language) {
		this.userid = userid;
		this.username = username;
		this.password = password;

	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
