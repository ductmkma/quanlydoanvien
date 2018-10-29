package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.Roles;
import com.zent.util.ConnectionUtil;

public class ReportUnionistDAO {
	public int getSumUnionistByUnits(Long units_id) {
		String sql = "select count(*) as sum from unionist where units_id in(select id from units where parent_id = (select parent_id from units where id=?))";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("sum");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public int getNationUnionistByUnits(Long units_id) {
		String sql = "select COUNT(id) as sumnation from unionist where nation !='Kinh' and units_id in(select id from units where parent_id = (select parent_id from units where id=?))";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("sumnation");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public int getReligionUnionistByUnits(Long units_id) {
		String sql = "select COUNT(id) as sumreligion from unionist where religion!='Không' and units_id in(select id from units where parent_id = (select parent_id from units where id=?))";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("sumreligion");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public  int getPartyByUnits(Long units_id) {
		String sql = "select COUNT(id) as sumparty from unionist where day_on_party is not null and units_id in(select id from units where parent_id = (select parent_id from units where id=?))";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("sumparty");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public  int getCardUnionistByUnits(Long units_id) {
		String sql = "select COUNT(id) as sumcard from unionist where code_unionist is not null and units_id in(select id from units where parent_id = (select parent_id from units where id=?))";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("sumcard");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public  int getUnionistNewByUnits(Long units_id,int year) {
		String sql = "select COUNT(id) as sumcard from unionist where code_unionist is not null and units_id in(select id from units where parent_id = (select parent_id from units where id=?))";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(2, units_id);
			statement.setInt(1, year);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("sumcard");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}
	/*public static void main(String[] args) {
		System.out.println(getNationUnionistByUnits(5l));
	}*/
}
