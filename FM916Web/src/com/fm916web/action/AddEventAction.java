package com.fm916web.action;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fm916web.bean.Event;
import com.fm916web.jdbc.JdbcDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddEventAction extends ActionSupport {
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String title;
	private String editor;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 System.out.print("begin   filename"+getFileFileName()+"\n");  
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String realpath = request.getSession().getServletContext().getRealPath("/").toString()+"photo";
	        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
	    // System.out.println("realpath: "+realpath+"\n");
	        if (file != null) {
	            File savefile = new File(new File(realpath), fileFileName);
	            if (!savefile.getParentFile().exists())
	                savefile.getParentFile().mkdirs();
	            FileUtils.copyFile(file, savefile);
	            ActionContext.getContext().put("message", "文件上传成功");
	        }
          System.out.print("filename"+getFileFileName());  
          
          Event event=new Event(); 
          event.setTitle(getTitle());
          event.setBanner(request.getContextPath()+"/photo/"+getFileFileName());
          event.setContent(getEditor());
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String ly_time = sdf.format(new java.util.Date());
          event.setTime(ly_time);
          JdbcDao dao=new JdbcDao();
          dao.insertEvent(event);
		 return SUCCESS;
		
		
		
	}

}
