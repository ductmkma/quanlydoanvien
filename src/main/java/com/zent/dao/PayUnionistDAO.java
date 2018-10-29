package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.PayUnionist;
import com.zent.util.ConnectionUtil;

public class PayUnionistDAO {
	public List<PayUnionist> getAll() {
		String sql = "SELECT * FROM pay_unionist";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<PayUnionist> listPayUnionist = new ArrayList<PayUnionist>();
			while (rs.next()) {
				PayUnionist PayUnionist = new PayUnionist();
				PayUnionist.setUnionist_id(rs.getLong("unionist_id"));
				PayUnionist.setMonth(rs.getInt("month"));
				PayUnionist.setYear(rs.getInt("year"));
				PayUnionist.setStatus(rs.getInt("status"));
				listPayUnionist.add(PayUnionist);
			}
			return listPayUnionist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void insert(PayUnionist payUnionist) {
		String sql = "INSERT INTO pay_unionist(unionist_id,year,month,status,created_at)VALUES (?,?,?,?,?)";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, payUnionist.getUnionist_id());
			statement.setInt(2, payUnionist.getYear());
			statement.setInt(3, payUnionist.getMonth());
			statement.setInt(4, payUnionist.getStatus());
			statement.setString(5, payUnionist.getCreated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(PayUnionist payUnionist) {
		String sql = "Update pay_unionist set status = ?,updated_at=? where unionist_id=? and month=? and year=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, payUnionist.getStatus());
			statement.setString(2, payUnionist.getUpdated_at());
			statement.setString(3, String.valueOf(payUnionist.getUnionist_id()));
			statement.setInt(4, payUnionist.getMonth());
			statement.setInt(5, payUnionist.getYear());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean check(PayUnionist payUnionist) {
		String sql = "Select COUNT(*) from pay_unionist where unionist_id=? and month=? and year=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, payUnionist.getUnionist_id());
			statement.setString(3, String.valueOf(payUnionist.getYear()));
			statement.setString(2, String.valueOf(payUnionist.getMonth()));
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
