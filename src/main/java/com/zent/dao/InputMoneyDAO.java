package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.InputMoney;
import com.zent.util.ConnectionUtil;

public class InputMoneyDAO {
	public List<InputMoney> getAll(Long units_id) {
		String sql = "SELECT * FROM input_money where deleted_at is null and units_id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<InputMoney> listInputMoney = new ArrayList<InputMoney>();
			while (rs.next()) {
				InputMoney inputMoney = new InputMoney();
				inputMoney.setId(rs.getLong("id"));
				inputMoney.setCode(rs.getString("code"));
				inputMoney.setContent(rs.getString("content"));
				inputMoney.setMoney(rs.getLong("money"));
				inputMoney.setSender(rs.getString("sender"));
				inputMoney.setDate(rs.getString("date"));
				inputMoney.setCreated_at(rs.getString("created_at"));
				inputMoney.setUpdated_at(rs.getString("updated_at"));
				inputMoney.setDeleted_at(rs.getString("deleted_at"));
				inputMoney.setUnits_id(rs.getLong("units_id"));
				listInputMoney.add(inputMoney);
			}
			return listInputMoney;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<InputMoney> getById(Long id) {
		String sql = "SELECT * from input_money where id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			List<InputMoney> listInputMoneyById = new ArrayList<InputMoney>();
			if (rs.next()) {
				InputMoney inputMoney = new InputMoney();
				inputMoney.setId(rs.getLong("id"));
				inputMoney.setCode(rs.getString("code"));
				inputMoney.setContent(rs.getString("content"));
				inputMoney.setMoney(rs.getLong("money"));
				inputMoney.setSender(rs.getString("sender"));
				inputMoney.setDate(rs.getString("date"));
				inputMoney.setCreated_at(rs.getString("created_at"));
				inputMoney.setUpdated_at(rs.getString("updated_at"));
				inputMoney.setDeleted_at(rs.getString("deleted_at"));
				inputMoney.setUnits_id(rs.getLong("units_id"));
				listInputMoneyById.add(inputMoney);
			}
			return listInputMoneyById;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(InputMoney inputMoney) {
		String sql = "INSERT input_money (code,content,money,sender,date,units_id,created_at) values (?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, inputMoney.getCode());
			statement.setString(2, inputMoney.getContent());
			statement.setLong(3, inputMoney.getMoney());
			statement.setString(4, inputMoney.getSender());
			statement.setString(5, inputMoney.getDate());
			statement.setLong(6, inputMoney.getUnits_id());
			statement.setString(7, inputMoney.getCreated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void edit(InputMoney inputMoney) {
		String sql = "UPDATE input_money SET content=?,money=?,sender=?,date=?,updated_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(6, inputMoney.getId());
			statement.setString(1, inputMoney.getContent());
			statement.setLong(2, inputMoney.getMoney());
			statement.setString(3, inputMoney.getSender());
			statement.setString(4, inputMoney.getDate());
			statement.setString(5, inputMoney.getUpdated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(InputMoney inputMoney) {
		String sql = "UPDATE input_money SET deleted_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(2, inputMoney.getId());
			statement.setString(1, inputMoney.getDeleted_at());
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
