package com.fm916web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

import com.fm916web.bean.Event;

public class JdbcDao {

	public String TAG=this.getClass().getName();
	public static String URL = "jdbc:mysql://localhost:3306/";
	public static String DATABASENAME = "fm916web";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		System.out.println("getConn start");
		try {
			return DriverManager.getConnection(URL + DATABASENAME, "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public  void release(ResultSet rs, Statement ps, Connection conn) {
		try {
			if (null != rs) {

				rs.close();
			}
			if (null != ps) {
				ps.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Event getEventById(int id) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "select * from event where id=?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Event event = new Event();
				event.setIdEvent(id);
				event.setTitle(rs.getString("title"));
				event.setBanner(rs.getString("banner"));
				event.setContent(rs.getString("content"));
				event.setTime(rs.getString("time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.release(rs, ps, conn);
		}
		return null;
	}

	public List<Event> getAllEvent() {
		List<Event> list = new ArrayList<Event>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "select * from event";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Event event = new Event();
				event.setIdEvent(rs.getInt("idEvent"));
				event.setTitle(rs.getString("title"));
				event.setBanner(rs.getString("banner"));
				event.setContent(rs.getString("content"));
				event.setTime(rs.getString("time"));
				list.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.release(rs, ps, conn);
		}
		return list;
	}

	public Event updateEvent(Event event) {
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "update event set title=?,banner=?,content=?time=?";
		System.out.println("updateEvent start");
		try {
			conn = this.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, event.getTitle());
			ps.setString(2, event.getBanner());
			ps.setString(3, event.getContent());
			ps.setString(4, event.getTime());
			int rst = ps.executeUpdate();
			conn.commit();
			if (rst > 0)
				return event;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			this.release(null, ps, conn);
		}
		return null;
	}

	public boolean deleteEvent(int id) {
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from event where idEvent=?";
		try {
			conn = this.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rst = ps.executeUpdate();
			conn.commit();
			if (rst > 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			this.release(null, ps, conn);
		}
		return false;
	}

	public boolean insertEvent(Event event) {
		System.out.println("insertEvent start");
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "insert into event(title,banner,content,time)values(?,?,?,?)";
		try {
			conn = this.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, event.getTitle());
			ps.setString(2, event.getBanner());
			ps.setString(3, event.getContent());
			ps.setString(4, event.getTime());
			System.out.println("------executeUpdate");
			int rst = ps.executeUpdate();
			
			conn.commit();
			if (rst > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			this.release(null, ps, conn);
			System.out.println("insertEvent end");
		}
		return false;
	}
}
