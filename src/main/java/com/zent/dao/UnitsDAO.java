package com.zent.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zent.entity.Units;
import com.zent.util.ConnectionUtil;

public class UnitsDAO {
	private PreparedStatement ps;
	public List<Units> getAll() {
		String sql = "SELECT * FROM units";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Units> listUnits = new ArrayList<Units>();
			while (rs.next()) {
				Units units = new Units();
				units.setId(rs.getLong("id"));
				units.setName(rs.getString("name"));
				units.setAddress(rs.getString("address"));
				units.setPhone(rs.getString("phone"));
				units.setEmail(rs.getString("email"));
				units.setCreatedAt(String.valueOf(rs.getDate("created_at")));
				units.setUpdatedAt(String.valueOf(rs.getDate("updated_at")));
				units.setDeletedAt(String.valueOf(rs.getDate("deleted_at")));
				units.setParentId(rs.getLong("parent_id"));
				listUnits.add(units);
			}
			return listUnits;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Units> getAllUnitsUnder(Long units_id) {
		String sql = "select * from units where parent_id = (select parent_id from units where units.id=?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<Units> listUnitsUnder = new ArrayList<Units>();
			while (rs.next()) {
				Units units = new Units();
				units.setId(rs.getLong("id"));
				units.setName(rs.getString("name"));
				units.setAddress(rs.getString("address"));
				units.setPhone(rs.getString("phone"));
				units.setEmail(rs.getString("email"));
				units.setCreatedAt(String.valueOf(rs.getDate("created_at")));
				units.setUpdatedAt(String.valueOf(rs.getDate("updated_at")));
				units.setDeletedAt(String.valueOf(rs.getDate("deleted_at")));
				units.setParentId(rs.getLong("parent_id"));
				listUnitsUnder.add(units);
			}
			return listUnitsUnder;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Units> getAllExceptDeleted(Long parent_id) {
		String sql = "SELECT * FROM units where deleted_at is null and parent_id=? ";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, parent_id);
			ResultSet rs = statement.executeQuery();
			List<Units> listUnits = new ArrayList<Units>();
			while (rs.next()) {
				Units units = new Units();
				units.setId(rs.getLong("id"));
				units.setName(rs.getString("name"));
				units.setAddress(rs.getString("address"));
				units.setPhone(rs.getString("phone"));
				units.setEmail(rs.getString("email"));
				units.setCreatedAt(String.valueOf(rs.getDate("created_at")));
				units.setUpdatedAt(String.valueOf(rs.getDate("updated_at")));
				units.setDeletedAt(String.valueOf(rs.getDate("deleted_at")));
				units.setParentId(rs.getLong("parent_id"));
				units.setTypeUnit(rs.getInt("type_unit"));
				listUnits.add(units);
			}
			return listUnits;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Units units) {
		String sql = "INSERT INTO units(name,address,phone,email,created_at,updated_at,deleted_at,parent_id,type_unit)VALUES (?,?,?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, units.getName());
			statement.setString(2, units.getAddress());
			statement.setString(3, units.getPhone());
			statement.setString(4, units.getEmail());
			statement.setString(5, units.getCreatedAt());
			statement.setString(6, units.getUpdatedAt());
			statement.setString(7, units.getDeletedAt());
			statement.setLong(8, units.getParentId());
			statement.setInt(9, units.getTypeUnit());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public void insertListUnits(List<Units> listUnits) {
		 	Connection conn;
	        try {
	            conn = ConnectionUtil.open();
	            // Sét tự động commit false, để chủ động điều khiển
	            conn.setAutoCommit(false);
	             
	            String sql = "INSERT INTO units(name,address,phone,email,created_at,updated_at,deleted_at,parent_id,type_unit)VALUES (?,?,?,?,?,?,?,?,?)";
	          
	            ps = conn.prepareStatement(sql);
	             
	            for (Units units : listUnits) {
	            	ps.setString(1, units.getName());
	    			ps.setString(2, units.getAddress());
	    			ps.setString(3, units.getPhone());
	    			ps.setString(4, units.getEmail());
	    			ps.setString(5, units.getCreatedAt());
	    			ps.setString(6, units.getUpdatedAt());
	    			ps.setString(7, units.getDeletedAt());
	    			ps.setLong(8, units.getParentId());
	    			ps.setInt(9, units.getTypeUnit());
	                ps.addBatch();
	            }
	            ps.executeBatch();
	             
	            // Gọi commit() để commit giao dịch với DB
	            conn.commit();
	            
	             
	            System.out.println("Record is inserted into Units table!");
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	           // MySQLConnectionUtils.rollbackQuietly(conn);
	             
	        } finally {
	             
	            try {
	                if (ps != null)
	                    ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	             
	           // ConnectionUtil.disconnect(conn);
	        }
	    }

	public void update(Units units) {
		String sql = "UPDATE units SET name=?,address=?,phone=?,email=?,updated_at=?,type_unit=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(7, units.getId());
			statement.setString(1, units.getName());
			statement.setString(2, units.getAddress());
			statement.setString(3, units.getPhone());
			statement.setString(4, units.getEmail());
			statement.setString(5, units.getUpdatedAt());
			statement.setInt(6, units.getTypeUnit());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Units units) {
		String sql = "UPDATE units SET deleted_at=? WHERE id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(2, units.getId());
			statement.setString(1, units.getDeletedAt());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Boolean checkParentId(Long parentId) {
		String sql = "SELECT COUNT(*) from units where deleted_at is null and id = ?";
		try {
			Connection conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql); 
			statement.setLong(1, parentId );
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
	//Trả về mảng các giá trị các đơn vị có type unit=4
	public List<Units> getListByTypeUnits(Long units_id) {
		String sql = "select * from units where type_unit = 4 and units.id!=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, units_id);
			ResultSet rs = statement.executeQuery();
			List<Units> listUnitsByTypeId = new ArrayList<Units>();
			while (rs.next()) {
				Units units = new Units();
				units.setId(rs.getLong("id"));
				units.setName(rs.getString("name"));
				units.setAddress(rs.getString("address"));
				units.setPhone(rs.getString("phone"));
				units.setEmail(rs.getString("email"));
				units.setCreatedAt(String.valueOf(rs.getDate("created_at")));
				units.setUpdatedAt(String.valueOf(rs.getDate("updated_at")));
				units.setDeletedAt(String.valueOf(rs.getDate("deleted_at")));
				units.setParentId(rs.getLong("parent_id"));
				units.setTypeUnit(rs.getInt("type_unit"));
				listUnitsByTypeId.add(units);
			}
			return listUnitsByTypeId;
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
