package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zent.util.ConnectionUtil;

public class ReportRateDAO {
	public Long getSumRated(Long units_id) {
		String sql = "select count(*) as sumrated from unionist where units_id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getLong("sumrated");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0l;
	}
	public Long getSumExcellent(Long units_id,String year) {
		String sql = "select count(*) as xuatsac from rate where units_id = ? and year = ? and rate_id =1";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			statement.setString(2, year);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getLong("xuatsac");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0l;
	}
	public Long getSumRather(Long units_id,String year) {
		String sql = "select count(*) as kha from rate where units_id = ? and year = ? and rate_id =2";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			statement.setString(2, year);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getLong("kha");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0l;
	}
	public Long getSumMedium(Long units_id,String year) {
		String sql = "select count(*) as trungbinh from rate where units_id = ? and year = ? and rate_id =3";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			statement.setString(2, year);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getLong("trungbinh");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0l;
	}
	public Long getSumWeak(Long units_id,String year) {
		String sql = "select count(*) as yeu from rate where units_id = ? and year = ? and rate_id =4";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			statement.setString(2, year);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getLong("yeu");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0l;
	}
	
	
	
}
