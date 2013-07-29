package com.fm916web.actions;

import com.fm916web.provider.IDbProvider;
import com.fm916web.provider.impl.MysqlProvider;
import com.fm916web.user.IUserDao;
import com.fm916web.user.impl.UserDaoImp;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserManager extends ActionSupport {
	private String userId;
	private String password;
	private String newPassword;
	private String newUserId;

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

	public String resetPassword() throws Exception {
		IUserDao iu = UserDaoImp.getInstance();
		if (iu.setNewPassword(userId, newPassword, password)) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String resetUserId() throws Exception {
		IUserDao iu = UserDaoImp.getInstance();
		if (iu.setNewUserId(newUserId, userId, password)) {
			return SUCCESS;
		}
		return ERROR;
	}

	public static void main(String ybz[]) {
		UserManager um = new UserManager();
		um.setUserId("admin1");
		um.setPassword("admin");
		um.setNewUserId("admin");
		um.setNewPassword("admin");
		try {
			System.out.print(um.resetUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
