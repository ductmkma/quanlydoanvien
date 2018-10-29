package com.zent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zent.entity.BonuosDiscipline;
import com.zent.util.ConnectionUtil;

public class BonuosDisciplineDAO {
	public void insertBonuosDiscipline(BonuosDiscipline bonuosDiscipline){
		String sql = "INSERT INTO bonous_discepline(type,code_unionist,units_id,content,date,number_decision,created_at)VALUES (?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, bonuosDiscipline.getType());
			statement.setString(2, bonuosDiscipline.getCode_unionist());
			statement.setLong(3, bonuosDiscipline.getUnits_id());
			statement.setString(4, bonuosDiscipline.getContent());
			statement.setString(5, bonuosDiscipline.getDate());
			statement.setString(6, bonuosDiscipline.getNumber_decision());
			statement.setString(7, bonuosDiscipline.getCreated_at());
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
