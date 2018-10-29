package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.PRGroupByRoleId;
import com.zent.entity.PayUnionist;
import com.zent.entity.PermissionRole;
import com.zent.entity.Unionist;
import com.zent.util.ConnectionUtil;

public class PermissionRoleDAO {
	
	public List<Unionist> getRoleId() {
		String sql = "select id,role_id from unionist";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Unionist> listRoleId = new ArrayList<Unionist>();
			while (rs.next()) {
				Unionist unionist = new Unionist();
				unionist.setId(rs.getLong("id"));
				unionist.setRole_id(rs.getLong("role_id"));
				listRoleId.add(unionist);
			}
			return listRoleId;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<PermissionRole> getAll() {
		String sql = "SELECT * FROM permission_role";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<PermissionRole> listPerRole = new ArrayList<PermissionRole>();
			while (rs.next()) {
				PermissionRole perRole = new PermissionRole();
				perRole.setRole_id(rs.getLong("role_id"));
				perRole.setPermission_id(rs.getLong("permission_id"));
				perRole.setStatus(rs.getInt("status"));
				listPerRole.add(perRole);
			}
			return listPerRole;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<PRGroupByRoleId> getAllGroupByRoleId() {
		String sql = "select pr.role_id,r.`display_name`,r.description from permission_role pr, role r WHERE pr.role_id = r.id and r.deleted_at is null  GROUP BY pr.role_id";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<PRGroupByRoleId> listPRGoupByRoleId = new ArrayList<PRGroupByRoleId>();
			while (rs.next()) {
				PRGroupByRoleId perRole = new PRGroupByRoleId();
				perRole.setRole_id(rs.getLong("pr.role_id"));
				perRole.setrole_display_name(rs.getString("r.display_name"));
				perRole.setRole_descrition(rs.getString("r.description"));
				listPRGoupByRoleId.add(perRole);
			}
			return listPRGoupByRoleId;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void insert(PermissionRole permissionRole) {
		String sql = "INSERT permission_role (permission_id,role_id,status,created_at) values (?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, permissionRole.getPermission_id());
			statement.setLong(2, permissionRole.getRole_id());
			statement.setInt(3, permissionRole.getStatus());
			statement.setString(4, permissionRole.getCreated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(PermissionRole perRole) {
		String sql = "Update permission_role set status = ?,updated_at=? where role_id=? and permission_id=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, perRole.getStatus());
			statement.setString(2, perRole.getUpdated_at());
			statement.setLong(3, perRole.getRole_id());
			statement.setLong(4, perRole.getPermission_id());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean check(PermissionRole permissionRole) {
		String sql = "Select COUNT(*) from permission_role where role_id=? and permission_id=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, permissionRole.getRole_id());
			statement.setLong(2, permissionRole.getPermission_id());
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
