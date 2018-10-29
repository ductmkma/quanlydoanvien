package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.Permission;
import com.zent.entity.Roles;
import com.zent.entity.Units;
import com.zent.util.ConnectionUtil;

public class RolesDAO {
	public List<Roles> getAll() {
		String sql = "SELECT * FROM role where deleted_at is null";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Roles> listRole = new ArrayList<Roles>();
			while (rs.next()) {
				Roles role = new Roles();
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("name"));
				role.setDisplay_name(rs.getString("display_name"));
				role.setDescription(rs.getString("description"));
				role.setCreated_at(rs.getString("created_at"));
				role.setUpdated_at(rs.getString("updated_at"));
				role.setDeleted_at(rs.getString("deleted_at"));
				listRole.add(role);
			}
			return listRole;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Roles> getRolesIdAndName() {
		String sql = "select id,display_name from role where role.deleted_at is null";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Roles> listRole = new ArrayList<Roles>();
			while (rs.next()) {
				Roles role = new Roles();
				role.setId(rs.getLong("id"));
				role.setDisplay_name(rs.getString("display_name"));
				listRole.add(role);
			}
			return listRole;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Roles> getById(Long id) {
		String sql = "SELECT * from role where id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			List<Roles> listById = new ArrayList<Roles>();
 			if (rs.next()) {
				Roles role = new Roles();
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("name"));
				role.setDisplay_name(rs.getString("display_name"));
				role.setDescription(rs.getString("description"));
				listById.add(role);
			}
			return listById;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void delete(Roles role) {
		String sql = "UPDATE role SET deleted_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(2, role.getId());
			statement.setString(1, role.getDeleted_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void edit(Roles role) {
		String sql = "UPDATE role SET name=?,display_name=?,description=?,updated_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(5, role.getId());
			statement.setString(1, role.getName());
			statement.setString(2, role.getDisplay_name());
			statement.setString(3, role.getDescription());
			statement.setString(4, role.getUpdated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(Roles role) {
		String sql = "INSERT role (name,display_name,created_at,description) values (?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDisplay_name());
			statement.setString(3, role.getCreated_at());
			statement.setString(4, role.getDescription());
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
