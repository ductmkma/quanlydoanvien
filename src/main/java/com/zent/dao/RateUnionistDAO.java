package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zent.entity.RateUnionist;
import com.zent.util.ConnectionUtil;

public class RateUnionistDAO {
	public void insertRateUnionist(RateUnionist rateUnionist){
		String sql = "INSERT INTO rate(code_unionist,units_id,year,rate_id,created_at)VALUES (?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, rateUnionist.getCode_unionist());
			statement.setLong(2, rateUnionist.getUnits_id());
			statement.setString(3, rateUnionist.getYear());
			statement.setInt(4, rateUnionist.getRate_id());
			statement.setString(5, rateUnionist.getCreated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateRateUnionist(RateUnionist rateUnionist){
		String sql = "UPDATE rate SET rate_id=?, updated_at=? where code_unionist=? and year=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, rateUnionist.getRate_id());
			statement.setString(2, rateUnionist.getUpdated_at());
			statement.setString(3, rateUnionist.getCode_unionist());
			statement.setString(4, rateUnionist.getYear());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int checkRateExist(String code_unionist,String year) {
		String sql = "select count(*) as count from rate where code_unionist=? and year=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, code_unionist);
			statement.setString(2, year);
			ResultSet rs = statement.executeQuery();
 			if (rs.next()) {
 				return rs.getInt("count");
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
}
