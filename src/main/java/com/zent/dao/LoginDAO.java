package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.PermissionRoleUnitonist;
import com.zent.entity.Unionist;
import com.zent.entity.Units;
import com.zent.util.ConnectionUtil;

public class LoginDAO {
	public List<PermissionRoleUnitonist> getPermissionRoleByUnionistId(Long unionist_id) {
		String sql = "select u.id,u.role_id,pr.permission_id from unionist u, permission_role pr where pr.status=1 and pr.role_id = u.role_id and u.id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, unionist_id);
			ResultSet rs = statement.executeQuery();
			List<PermissionRoleUnitonist> listPerRoleUni = new ArrayList<PermissionRoleUnitonist>();
			while (rs.next()) {
				PermissionRoleUnitonist perRoleUni = new PermissionRoleUnitonist();
				perRoleUni.setId(rs.getLong("u.id"));
				perRoleUni.setRole_id(rs.getLong("u.role_id"));
				perRoleUni.setPermission_id(rs.getLong("permission_id"));
				
				listPerRoleUni.add(perRoleUni);
			}
			return listPerRoleUni;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Boolean checkLogin(Unionist unionist) {
		String sql = "SELECT COUNT(*) FROM unionist WHERE email =? AND password=?";
		try {
			Connection conn = ConnectionUtil.open(); 
			PreparedStatement statement = conn.prepareStatement(sql); 
			statement.setString(1, unionist.getEmail());
			statement.setString(2, unionist.getPassword());
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
	public static String getNameUser(String email) {
		String sql = "SELECT name FROM unionist where email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("name");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Units getParentIdAndTypeId(String email) {
		String sql = "SELECT unit.parent_id,unit.type_unit from unionist uni, units unit where uni.units_id = unit.id and uni.email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Units unit = new Units(rs.getLong("unit.parent_id"), rs.getInt("unit.type_unit"));
				return unit;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getUnitsId(String email) {
		String sql = "SELECT units_id FROM unionist where email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("units_id");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getAvataUser(String email) {
		String sql = "SELECT avata FROM unionist where email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Má»Ÿ káº¿t ná»‘i
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("avata");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getIdByEmail(String email) {
		String sql = "SELECT id FROM unionist where email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Má»Ÿ káº¿t ná»‘i
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("id");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getNameUnits(String unit_id) {
		String sql = "SELECT name FROM units where id=? ";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Má»Ÿ káº¿t ná»‘i
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, unit_id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("name");
			}

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
