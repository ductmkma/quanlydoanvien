package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.PayUnionist;
import com.zent.entity.Permission;
import com.zent.util.ConnectionUtil;

public class PermissionDAO {
	public List<Permission> getAll() {
		String sql = "SELECT * FROM permission";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Permission> listPermission = new ArrayList<Permission>();
			while (rs.next()) {
				Permission permission = new Permission();
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("name"));
				permission.setDisplay_name(rs.getString("display_name"));
				permission.setDescription(rs.getString("description"));
				permission.setCreated_at(rs.getString("created_at"));
				permission.setUpdate_at(rs.getString("updated_at"));
				permission.setDeleted_at(rs.getString("deleted_at"));
				listPermission.add(permission);
			}
			return listPermission;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
