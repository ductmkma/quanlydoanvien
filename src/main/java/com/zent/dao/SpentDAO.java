package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.Roles;
import com.zent.entity.Spent;
import com.zent.util.ConnectionUtil;

public class SpentDAO {
	public List<Spent> getAll(Long units_id) {
		String sql = "SELECT * FROM spent where deleted_at is null and units_id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<Spent> listSpent = new ArrayList<Spent>();
			while (rs.next()) {
				Spent spent = new Spent();
				spent.setId(rs.getLong("id"));
				spent.setCode(rs.getString("code"));
				spent.setContent(rs.getString("content"));
				spent.setMoney(rs.getLong("money"));
				spent.setReceiver(rs.getString("receiver"));
				spent.setDate(rs.getString("date"));
				spent.setCreated_at(rs.getString("created_at"));
				spent.setUpdated_at(rs.getString("updated_at"));
				spent.setDeleted_at(rs.getString("deleted_at"));
				spent.setUnits_id(rs.getLong("units_id"));
				listSpent.add(spent);
			}
			return listSpent;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Spent> getById(Long id) {
		String sql = "SELECT * from spent where id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			List<Spent> listSpentById = new ArrayList<Spent>();
			if (rs.next()) {
				Spent spent = new Spent();
				spent.setId(rs.getLong("id"));
				spent.setCode(rs.getString("code"));
				spent.setContent(rs.getString("content"));
				spent.setMoney(rs.getLong("money"));
				spent.setReceiver(rs.getString("receiver"));
				spent.setDate(rs.getString("date"));
				spent.setCreated_at(rs.getString("created_at"));
				spent.setUpdated_at(rs.getString("updated_at"));
				spent.setDeleted_at(rs.getString("deleted_at"));
				spent.setUnits_id(rs.getLong("units_id"));
				listSpentById.add(spent);
			}
			return listSpentById;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(Spent spent) {
		String sql = "INSERT spent (code,content,money,receiver,date,units_id,created_at) values (?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, spent.getCode());
			statement.setString(2, spent.getContent());
			statement.setLong(3, spent.getMoney());
			statement.setString(4, spent.getReceiver());
			statement.setString(5, spent.getDate());
			statement.setLong(6, spent.getUnits_id());
			statement.setString(7, spent.getCreated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void edit(Spent spent) {
		String sql = "UPDATE spent SET content=?,money=?,receiver=?,date=?,updated_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(6, spent.getId());
			statement.setString(1, spent.getContent());
			statement.setLong(2, spent.getMoney());
			statement.setString(3, spent.getReceiver());
			statement.setString(4, spent.getDate());
			statement.setString(5, spent.getUpdated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(Spent spent) {
		String sql = "UPDATE spent SET deleted_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(2, spent.getId());
			statement.setString(1, spent.getDeleted_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
