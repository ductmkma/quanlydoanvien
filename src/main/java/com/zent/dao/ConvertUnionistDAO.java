package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.ConvertUnionist;
import com.zent.entity.Roles;
import com.zent.entity.Unionist;
import com.zent.entity.Units;
import com.zent.util.ConnectionUtil;

public class ConvertUnionistDAO {
	public List<ConvertUnionist> getAllWattingConfirmofUnitsId(Long units_id) {
		String sql = "select units_unionist.id,units_unionist.code_unionist,unionist.`name`,units.`name`,units_unionist.units_name_new,units_unionist.created_at from units_unionist,units,unionist where units_unionist.units_id_old in (select id from units where parent_id = (select parent_id from units where units.id=?)) and status=2 and units.id = units_id_old and units_unionist.code_unionist = unionist.`code`";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<ConvertUnionist> listWattingConfirm = new ArrayList<ConvertUnionist>();
			while (rs.next()) {
				ConvertUnionist convertUnionist = new ConvertUnionist();
				convertUnionist.setId(rs.getLong("units_unionist.id"));
				convertUnionist.setCode_unionist(rs.getString("units_unionist.code_unionist"));
				convertUnionist.setName_unionist(rs.getString("unionist.name"));
				convertUnionist.setUnits_name_old(rs.getString("units.name"));
				convertUnionist.setUnits_name_new(rs.getString("units_unionist.units_name_new"));
				convertUnionist.setCreated_at(rs.getString("units_unionist.created_at"));
				listWattingConfirm.add(convertUnionist);
			}
			return listWattingConfirm;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<ConvertUnionist> getAllWattingConfirmReceiver(Long units_id) {
		String sql = "select units_unionist.id,units_unionist.code_unionist,unionist.`name`,units.`name`,units_unionist.units_name_new,units_unionist.updated_at from units_unionist,units,unionist where units_unionist.units_id_new=(select parent_id from units where units.id=?) and status=3 and units.id = units_id_old and units_unionist.code_unionist = unionist.`code`";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<ConvertUnionist> listWattingConfirmReceiver = new ArrayList<ConvertUnionist>();
			while (rs.next()) {
				ConvertUnionist convertUnionist = new ConvertUnionist();
				convertUnionist.setId(rs.getLong("units_unionist.id"));
				convertUnionist.setCode_unionist(rs.getString("units_unionist.code_unionist"));
				convertUnionist.setName_unionist(rs.getString("unionist.name"));
				convertUnionist.setUnits_name_old(rs.getString("units.name"));
				convertUnionist.setUpdated_at(rs.getString("units_unionist.updated_at"));
				listWattingConfirmReceiver.add(convertUnionist);
			}
			return listWattingConfirmReceiver;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void insert(ConvertUnionist convertUnionist) {
		String sql = "INSERT INTO units_unionist(code_unionist,units_id_old,units_id_new,units_name_new,created_at,status)VALUES (?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, convertUnionist.getCode_unionist());
			statement.setLong(2, convertUnionist.getUnits_id_old());
			statement.setLong(3, convertUnionist.getUnits_id_new());
			statement.setString(4, convertUnionist.getUnits_name_new());
			statement.setString(5, convertUnionist.getCreated_at());
			statement.setInt(6, convertUnionist.getStatus());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void edit(ConvertUnionist convertUnionist) {
		String sql = "UPDATE units_unionist SET status=?,updated_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(3, convertUnionist.getId());
			statement.setInt(1, convertUnionist.getStatus());
			statement.setString(2, convertUnionist.getUpdated_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Update unit-unionist 
	public void updateStatusOld(ConvertUnionist convertUnionist){ //Update bản ghi của đơn vị chi đoàn giới thiệu
		String sql = "UPDATE units_unionist SET date_out=?, status=?,updated_at=? WHERE code_unionist=? and status=1";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, convertUnionist.getDate_out());
			statement.setInt(2, convertUnionist.getStatus());
			statement.setString(3, convertUnionist.getUpdated_at());
			statement.setString(4, convertUnionist.getCode_unionist());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateStatusNew(ConvertUnionist convertUnionist){ //Update bản ghi khi ĐX 2 xác nhận rồi :D
		String sql = "UPDATE units_unionist SET date_in=?,units_id_new=?,units_name_new=?, status=?,updated_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, convertUnionist.getDate_in());
			statement.setLong(2, convertUnionist.getUnits_id_new());
			statement.setString(3, convertUnionist.getUnits_name_new());
			statement.setInt(4, convertUnionist.getStatus());
			statement.setString(5, convertUnionist.getUpdated_at());
			statement.setLong(6,convertUnionist.getId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateUnitAfterConvert(ConvertUnionist convertUnionist){ //Update bản ghi khi ĐX 2 xác nhận rồi :D
		String sql = "UPDATE unionist SET units_id=?,updated_at=? WHERE code=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, convertUnionist.getUnits_id_new());
			statement.setString(2, convertUnionist.getUpdated_at());
			statement.setString(3, convertUnionist.getCode_unionist());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//insert table Unionist
	public void insertUnionist(ConvertUnionist convertUnionist) {
		String sql = "INSERT INTO units_unionist(code_unionist,units_id_old,units_id_new,units_name_new,created_at,status,date_in)VALUES (?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, convertUnionist.getCode_unionist());
			statement.setLong(2, convertUnionist.getUnits_id_old());
			statement.setLong(3, convertUnionist.getUnits_id_new());
			statement.setString(4, convertUnionist.getUnits_name_new());
			statement.setString(5, convertUnionist.getCreated_at());
			statement.setInt(6, convertUnionist.getStatus());
			statement.setString(7, convertUnionist.getDate_in());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getNameUnits(Long units_id) {
		String sql = "select `name` from units WHERE units.id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<ConvertUnionist> listWattingConfirm = new ArrayList<ConvertUnionist>();
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
