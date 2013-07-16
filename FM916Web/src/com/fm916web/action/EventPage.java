package com.fm916web.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fm916web.bean.Event;
import com.fm916web.jdbc.JdbcDao; 
import com.opensymphony.xwork2.ActionSupport;

public class EventPage extends ActionSupport {

 


	private int pageSize;
	private int totalRows;
	private int totalPages;
	private int currentpage=1;
	private boolean hasPre=false;
	private boolean hasNext=false;
	
	private List<Event> list=new ArrayList<Event>();
	private  JdbcDao dao;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public EventPage(int pageSize){
		dao=new JdbcDao();
		this.pageSize=pageSize;
		totalRows=getRowCount();
		totalPages=((totalRows+pageSize)-1)/pageSize;
		initList(1);
	}
		
	private void initList(int currentPage){
		list.removeAll(list);
		conn=dao.getConn();
		String sql="select * from event limit ?,20";
		try{
			ps=conn.prepareStatement(sql);
			int temp=(currentPage-1)*20;
			ps.setInt(1, temp);
			rs=ps.executeQuery();
			while(rs.next()){
				Event event=new Event();
				event.setIdEvent(rs.getInt(1));
				event.setTitle(rs.getString(2));
				event.setBanner(rs.getString(3));
				event.setContent(rs.getString(4));
				event.setTime(rs.getString(5));
				list.add(event);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dao.release(rs, ps, conn);
		}
	}

	private int getRowCount(){
		conn=dao.getConn();
		try{
			ps=conn.prepareStatement("select * from event");
			rs=ps.executeQuery();
			rs.last();
			int re=rs.getRow();
			rs.first();
			return re;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dao.release(rs, ps, conn);
		}
		return 0;
	}
	
	public ArrayList<Event> getList(int cp){
		initList(cp);
		ArrayList<Event> temp=new ArrayList<Event>();
		for(int i=0;i<list.size();i++){
			temp.add(list.get(i));
		}
		return temp;
	}

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHasPre() {
		return hasPre;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<Event> getList() {
		return list;
	}

	public void setList(List<Event> list) {
		this.list = list;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}


	 
}
