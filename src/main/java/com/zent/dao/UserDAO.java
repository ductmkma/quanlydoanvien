package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.zent.entity.PRGroupByRoleId;
import com.zent.entity.RoleUser;
import com.zent.entity.Roles;
import com.zent.entity.Unionist;
import com.zent.util.ConnectionUtil;

public class UserDAO {
	public List<Unionist> getAll() {
		String sql = "select  uni.`id`,uni.`code`,uni.`name`,uni.email,role.id,role.display_name,uni.created_at from unionist as uni join role as role on uni.role_id = role.id where uni.deleted_at is null";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Unionist> listUser = new ArrayList<Unionist>();
			while (rs.next()) {
				Unionist unionist = new Unionist();
				unionist.setId(rs.getLong("uni.id"));
				unionist.setCode(rs.getString("uni.code"));;
				unionist.setName(rs.getString("uni.name"));
				unionist.setEmail(rs.getString("uni.email"));
				unionist.setRole_id(rs.getLong("role.id"));
				unionist.setRole_display_name(rs.getString("role.display_name"));
				unionist.setCreated_at(rs.getString("created_at"));
				listUser.add(unionist);
			}
			return listUser;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<RoleUser> getAllRoleUser() {
		String sql = "SELECT r.id,r.`name`,r.description,p.`name` as pername from permission p,role r, permission_role pr where p.id=pr.permission_id and r.id=pr.role_id";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<RoleUser> listRoleUser = new ArrayList<RoleUser>();
			while (rs.next()) {
				RoleUser roleUser = new RoleUser();
				roleUser.setRole_id(rs.getLong("r.id"));
				roleUser.setRole_name(rs.getString("r.name"));
				roleUser.setRole_description(rs.getString("r.description"));
				roleUser.setPermission_name(rs.getString("pername"));
				listRoleUser.add(roleUser);
			}
			return listRoleUser;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void update(Long unionist_id,Long role_id,String updated_at) {
		String sql = "UPDATE unionist SET role_id=?,updated_at=? where id=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1,role_id);
			statement.setString(2, updated_at);
			statement.setLong(3,unionist_id);
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
