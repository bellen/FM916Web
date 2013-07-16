package com.fm916web.action.user;

import com.fm916web.provider.IDbProvider;
import com.fm916web.provider.impl.MysqlProvider;
import com.fm916web.user.IUserDao;
import com.fm916web.user.impl.UserDaoImp;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserManager extends ActionSupport {
	String userId;
	String password;
	String newPassword;
	String newUserId;

	public String getNewUserId() {
		return newUserId;
	}

	public void setNewUserId(String newUserId) {
		this.newUserId = newUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userid) {
		this.userId = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String login() throws Exception {
		IUserDao iu = UserDaoImp.getInstance();
		if (iu.checkPassword(userId, password))
			return SUCCESS;
		return ERROR;
	}

	public String setNewPassword() throws Exception {
		IUserDao iu = UserDaoImp.getInstance();
		if (iu.setNewPassword(userId, newPassword, password)) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String setNewUserId() throws Exception {
		IUserDao iu = UserDaoImp.getInstance();
		if (iu.setNewUserId(newUserId, userId, password)) {
			return SUCCESS;
		}
		return ERROR;
	}
}
