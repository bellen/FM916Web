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

	private int id;
	private String name;
	private String icon;
	private String audio;
	private String description;
	private List hosters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
			Hoster h = new Hoster();
			h.setName(this.getName());
			h.setAudio(this.getAudio());
			h.setIcon(this.getIcon());
			h.setDescription(this.getDescription());
			if (ih.addHoster(h))
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
			if (ih.removeHoster(this.getId()))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String setHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		Hoster h = new Hoster();
		h.setId(this.getId());
		h.setName(this.getName());
		h.setAudio(this.getAudio());
		h.setIcon(this.getIcon());
		h.setDescription(this.getDescription());
		try {
			if (ih.setHoster(h))
				return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getHoster() {
		IHosterProgram ih = HosterProgramImpl.getInstance();
		try {
			int id = this.getId();
			Hoster h = ih.getHoster(id);
			this.setId(h.getId());
			this.setAudio(h.getAudio());
			this.setIcon(h.getIcon());
			this.setDescription(h.getDescription());
			this.setName(h.getName());
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

	public static void main(String arg[]) {
		HosterManager hm = new HosterManager();
		hm.setId(1);
		// hm.setName("aaa2");
		// hm.setIcon("a.com2");
		// hm.setAudio("a1.com2");
		// hm.setDescription("aaa12");
		System.out.println(hm.removeHoster());
//		System.out.print(hm.hosters.size());
		// System.out.println(hm.getAudio());
		// System.out.println(hm.getId());
		// System.out.println(hm.getName());
		// System.out.println(hm.getIcon());
		// System.out.println(hm.getDescription());
	}
}
