package com.fm916web.managers.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fm916web.managers.IAudioProgram;
import com.fm916web.user.IUserDao;
import com.fm916web.user.impl.UserDaoImp;
import com.opensymphony.xwork2.ActionContext;

public class AudioProgramImp implements IAudioProgram {

	private static AudioProgramImp instance;

	public static IAudioProgram getInstance() {
		// TODO multi-thread
		if (instance == null)
			instance = new AudioProgramImp();
		return instance;
	}

	public boolean UploadBackground(File file, String fileName) {
		try {
			ServletContext sc = ServletActionContext.getServletContext();
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos;
			fos = new FileOutputStream(new File(sc.getRealPath("/")
					.concat("photo/").concat("audiobackground/")));
			byte[] b = new byte[1];
			while (fis.read(b) != -1) {
				fos.write(b);
				fos.flush();
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
