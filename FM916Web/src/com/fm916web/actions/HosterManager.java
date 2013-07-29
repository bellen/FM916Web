package com.fm916web.actions;

import java.sql.SQLException;
import java.util.List;

import com.fm916web.managers.IHosterProgram;
import com.fm916web.managers.beans.Hoster;
import com.fm916web.managers.impl.HosterProgramImpl;
import com.opensymphony.xwork2.ActionSupport;

public class HosterManager extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7858195809127813069L;
	private Hoster hoster;
	private List hosters;

	public Hoster getHoster() {
		return hoster;
	}

	public void setHoster(Hoster hoster) {
		this.hoster = hoster;
	}

	public List getHosters() {
		return hosters;
	}

	public void setHosters(List hosters) {
		this.hosters = hosters;
	}

	public String addHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		try {
			if (ih.addHoster(this.getHoster()))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String removeHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		try {
			if (ih.removeHoster(this.getHoster()))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String setHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		try {
			if (ih.setHoster(this.getHoster()))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getAHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		try {
			int id = this.getHoster().getId();
			this.setHoster(ih.getHoster(id));
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getAllHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		try {
			this.setHosters(ih.getHosters());
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
