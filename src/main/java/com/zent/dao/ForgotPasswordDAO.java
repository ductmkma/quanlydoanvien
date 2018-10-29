package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zent.entity.PayUnionist;
import com.zent.util.ConnectionUtil;



public class ForgotPasswordDAO {
	public void updatePassword(String email,String password,String updated_at){
		String sql = "UPDATE unionist SET password=?,updated_at=? where email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, updated_at);
			statement.setString(3, email);			
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkEmail(String email) {
		String sql = "Select COUNT(*) from unionist where email=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.execute();
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Long count = rs.getLong(1);
				if (count > 0) {
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
