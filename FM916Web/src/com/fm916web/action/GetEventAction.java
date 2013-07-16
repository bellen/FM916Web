package com.fm916web.action;

import java.util.ArrayList;

import org.omg.PortableServer.Current;

import com.fm916web.bean.Event;
import com.opensymphony.xwork2.ActionSupport;

public class GetEventAction extends ActionSupport {

	private int totalPages;
	private boolean hasPre;
	private boolean hasNext;
	private int currentPage = 1;
	private ArrayList<Event> list;

	private ArrayList pageList = new ArrayList();
	private EventPage ep;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(currentPage<1){
			currentPage=1;
		}
		init(currentPage);
		return super.execute();
	}

	private void init(int currentPage) {
		// TODO Auto-generated method stub
		ep = new EventPage(5);
		this.setTotalPages(ep.getTotalPages());
		this.setHasPre(ep.isHasPre());
		this.setHasNext(ep.isHasNext());
		this.setList(ep.getList(currentPage));
		for (int i = 1; i <=getTotalPages(); i++) {
			Current c=new Current();
			c.setCurrentPage(i);
			pageList.add(c);
		}
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public ArrayList<Event> getList() {
		this.setList(ep.getList(currentPage));
		return list;
	}

	public void setList(ArrayList<Event> list) {
		this.list = list;
	}

	public ArrayList<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<Integer> pageList) {
		this.pageList = pageList;
	}

	public EventPage getEp() {
		return ep;
	}

	public void setEp(EventPage ep) {
		this.ep = ep;
	}

	public class Current {

		private int currentPage;

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		
	}
}
