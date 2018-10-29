package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zent.entity.District;
import com.zent.entity.Province;
import com.zent.entity.Town;
import com.zent.entity.Unionist;
import com.zent.entity.Units;
import com.zent.util.ConnectionUtil;

public class UnionistDAO {
	private PreparedStatement ps;
	public List<Unionist> getAllByUnit(Long unit_id) {
		String sql = "SELECT * FROM unionist uni, units  u,province p,district d,town t where uni.units_id = u.id and uni.deleted_at is null and uni.province_id = p.provinceid and uni.district_id = d.districtid and uni.town_id = t.townid and uni.code_unionist is not null and uni.units_id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, unit_id);
			ResultSet rs = statement.executeQuery();
			List<Unionist> listUnionists = new ArrayList<Unionist>();
			while (rs.next()) {
				Unionist unionist = new Unionist();
				unionist.setId(rs.getLong("id"));
				unionist.setCode(rs.getString("code"));
				unionist.setAvata(rs.getString("avata"));
				unionist.setName(rs.getString("name"));
				unionist.setBirthday(String.valueOf(rs.getDate("birthday")));
				unionist.setGender(rs.getString("gender"));
				unionist.setEmail(rs.getString("email"));
				unionist.setPhone(rs.getString("phone"));
				unionist.setPassword(rs.getString("password"));
				unionist.setHome_town(rs.getString("home_town"));
				unionist.setProvinceId(rs.getString("province_id"));
				unionist.setProvinceName(rs.getString("p.name"));
				unionist.setDistrictId(rs.getString("district_id"));
				unionist.setDistrictName(rs.getString("d.name"));
				unionist.setTownId(rs.getString("town_id"));
				unionist.setTownName(rs.getString("t.name"));
				unionist.setVillage(rs.getString("village"));
				unionist.setNation(rs.getString("nation"));
				unionist.setReligion(rs.getString("religion"));
				unionist.setAcademic_level(rs.getString("academic_level"));
				unionist.setQualification(rs.getString("qualification"));
				unionist.setPolitical_theory(rs.getString("political_theory"));
				unionist.setCode_unionist(rs.getString("code_unionist"));
				unionist.setDay_on_unionist(String.valueOf(rs.getDate("day_on_unionist")));
				unionist.setAddress_on_unionist(rs.getString("address_on_unionist"));
				unionist.setCompetence(rs.getString("competence"));
				unionist.setDay_on_party(String.valueOf(rs.getDate("day_on_party")));
				unionist.setCreated_at(String.valueOf(rs.getDate("created_at")));
				unionist.setUpdated_at(String.valueOf(rs.getDate("updated_at")));
				unionist.setDeleted_at(String.valueOf(rs.getDate("deleted_at")));
				unionist.setUnits_id(rs.getLong("units_id"));
				unionist.setUnits_name(rs.getString("u.name"));
				unionist.setRole_id(rs.getLong("role_id"));
				listUnionists.add(unionist);
			}
			return listUnionists;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void insert(Unionist unionist) {
		String sql = "INSERT INTO unionist(code,avata,name,birthday,gender,email,phone,home_town,province_id,district_id,town_id,village,nation,religion,academic_level,qualification,political_theory,code_unionist,day_on_unionist,address_on_unionist,competence,day_on_party,created_at,units_id,role_id)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,unionist.getCode());
			statement.setString(2,unionist.getAvata());
			statement.setString(3,unionist.getName());
			statement.setString(4,unionist.getBirthday());
			statement.setString(5,unionist.getGender());
			statement.setString(6,unionist.getEmail());
			statement.setString(7,unionist.getPhone());
			statement.setString(8,unionist.getHome_town());
			statement.setString(9,unionist.getProvinceId());
			statement.setString(10,unionist.getDistrictId());
			statement.setString(11,unionist.getTownId());
			statement.setString(12,unionist.getVillage());
			statement.setString(13,unionist.getNation());
			statement.setString(14,unionist.getReligion());
			statement.setString(15,unionist.getAcademic_level());
			statement.setString(16,unionist.getQualification());
			statement.setString(17,unionist.getPolitical_theory());
			statement.setString(18,unionist.getCode_unionist());
			statement.setString(19,unionist.getDay_on_unionist());
			statement.setString(20,unionist.getAddress_on_unionist());
			statement.setString(21,unionist.getCompetence());
			statement.setString(22,unionist.getDay_on_party());
			statement.setString(23,unionist.getCreated_at());
			statement.setLong(24,unionist.getUnits_id());
			statement.setLong(25,unionist.getRole_id());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Unionist unionist) {
		String sql = "UPDATE unionist SET avata=?,name=?,birthday=?,gender=?,email=?,phone=?,home_town=?,province_id=?,district_id=?,town_id=?,village=?,nation=?,religion=?,academic_level=?,qualification=?,political_theory=?,day_on_unionist=?,address_on_unionist=?,competence=?,day_on_party=?,updated_at=? where code=?";
		Connection conn;

		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,unionist.getAvata());
			statement.setString(2,unionist.getName());
			statement.setString(3,unionist.getBirthday());
			statement.setString(4,unionist.getGender());
			statement.setString(5,unionist.getEmail());
			statement.setString(6,unionist.getPhone());
			statement.setString(7,unionist.getHome_town());
			statement.setString(8,unionist.getProvinceId());
			statement.setString(9,unionist.getDistrictId());
			statement.setString(10,unionist.getTownId());
			statement.setString(11,unionist.getVillage());
			statement.setString(12,unionist.getNation());
			statement.setString(13,unionist.getReligion());
			statement.setString(14,unionist.getAcademic_level());
			statement.setString(15,unionist.getQualification());
			statement.setString(16,unionist.getPolitical_theory());
			statement.setString(17,unionist.getDay_on_unionist());
			statement.setString(18,unionist.getAddress_on_unionist());
			statement.setString(19,unionist.getCompetence());
			statement.setString(20,unionist.getDay_on_party());
			statement.setString(21,unionist.getCreated_at());
			statement.setString(22, unionist.getCode());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public void insertListUnionistByExcel(List<Unionist> listUnionist) {
		 	Connection conn=null;
	        try {
	            conn = ConnectionUtil.open();
	            // Sét tự động commit false, để chủ động điều khiển
	            conn.setAutoCommit(false);
	             
	            String sql = "INSERT INTO unionist(code,name,birthday,gender,email,phone,home_town,province_id,district_id,town_id,village,nation,religion,academic_level,qualification,political_theory,code_unionist,day_on_unionist,address_on_unionist,competence,day_on_party,created_at,updated_at,deleted_at,units_id,role_id)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	          
	            ps = conn.prepareStatement(sql);
	             
	            for (Unionist unionist : listUnionist) {
	            	ps.setString(1,unionist.getCode());
	    			ps.setString(2,unionist.getName());
	    			ps.setString(3,unionist.getBirthday());
	    			ps.setString(4,unionist.getGender());
	    			ps.setString(5,unionist.getEmail());
	    			ps.setString(6,unionist.getPhone());
	    			ps.setString(7,unionist.getHome_town());
	    			ps.setString(8,unionist.getProvinceId().replace(".0",""));
	    			ps.setString(9,unionist.getDistrictId().replace(".0",""));
	    			ps.setString(10,unionist.getTownId().replace(".0",""));
	    			ps.setString(11,unionist.getVillage());
	    			ps.setString(12,unionist.getNation());
	    			ps.setString(13,unionist.getReligion());
	    			ps.setString(14,unionist.getAcademic_level());
	    			ps.setString(15,unionist.getQualification());
	    			ps.setString(16,unionist.getPolitical_theory());
	    			ps.setString(17,unionist.getCode_unionist());
	    			ps.setString(18,unionist.getDay_on_unionist());
	    			ps.setString(19,unionist.getAddress_on_unionist());
	    			ps.setString(20,unionist.getCompetence());
	    			ps.setString(21,unionist.getDay_on_party());
	    			ps.setString(22,unionist.getCreated_at());
	    			ps.setString(23,unionist.getUpdated_at());
	    			ps.setString(24,unionist.getDeleted_at());
	    			ps.setLong(25,unionist.getUnits_id());
	    			ps.setLong(26,unionist.getRole_id());
	                ps.addBatch();
	            }
	            ps.executeBatch();
	            // Gọi commit() để commit giao dịch với DB
	            conn.commit();
	            System.out.println("Record is inserted into Unionist table!");
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	           try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	             
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
	public void delete(Unionist unionist) {
		String sql = "UPDATE unionist SET deleted_at=? WHERE code=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, unionist.getCode());
			statement.setString(1, unionist.getDeleted_at());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Province> getAllProvince() {
		String sql = "SELECT * FROM province";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Province> listProvince = new ArrayList<Province>();
			while (rs.next()) {
				Province province = new Province();
				province.setProvinceId(rs.getString("provinceid"));
				province.setName(rs.getString("name"));
				province.setType(rs.getString("type"));
				listProvince.add(province);
			}
			return listProvince;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<District> getDistrictByProvinceId(String provinceId) {
		String sql = "SELECT * FROM district where provinceid=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, provinceId);
			ResultSet rs = statement.executeQuery();
			List<District> listDistrict = new ArrayList<District>();
			while (rs.next()) {
				District district = new District();
				district.setDistrictId(rs.getString("districtid"));
				district.setName(rs.getString("name"));
				district.setType(rs.getString("type"));
				district.setLocation(rs.getString("location"));
				district.setProvinceId(rs.getString("provinceid"));
				listDistrict.add(district);
			}
			return listDistrict;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Town> getTownByDistrictId(String districId) {
		String sql = "SELECT * FROM town where districtid=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, districId);
			ResultSet rs = statement.executeQuery();
			List<Town> listTown = new ArrayList<Town>();
			while (rs.next()) {
				Town town = new Town();
				town.setTownId(rs.getString("townid"));
				town.setName(rs.getString("name"));
				town.setType(rs.getString("type"));
				town.setLocation(rs.getString("location"));
				town.setDistrictId(rs.getString("districtid"));
				listTown.add(town);
			}
			return listTown;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//Trả về 1 số để check đóng đoàn phí hay chưa ?
	public int checkPayUnionist(int year,Long unionist_id ){
		String sql = "select COUNT(*) as countmonth from pay_unionist where unionist_id = ? and `status` = 1 and `year`=?";
		Connection conn;
		int countMonth;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, unionist_id);
			statement.setInt(2, year);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				countMonth=rs.getInt("countmonth");
				return countMonth;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int checkExistEmail(String email){
		String sql = "select COUNT(*) as checkemail from unionist where email = ?";
		Connection conn;
		int countMonth;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getInt("checkemail");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int checkExistCodeUnionist(String code_unionist){
		String sql = "select COUNT(*) as checkcodeunionist from unionist where code_unionist=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, code_unionist);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getInt("checkcodeunionist");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void updateRoleId(Unionist unionist){ 
		String sql = "UPDATE unionist SET role_id=?,updated_at=? WHERE code=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, unionist.getRole_id());
			statement.setString(2, unionist.getUpdated_at());
			statement.setString(3, unionist.getCode_unionist());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int checkPassword(String email,String password){
		String sql = "select COUNT(*) as checkpass from unionist where email = ? and password=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getInt("checkpass");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void updatePassword(String email,String passnew,String updated_at){ 
		String sql = "UPDATE unionist SET password=?,updated_at=? WHERE email=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, passnew);
			statement.setString(2, updated_at);
			statement.setString(3, email);
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
