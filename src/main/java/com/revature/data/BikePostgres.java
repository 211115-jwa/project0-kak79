package com.revature.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bike;
import com.revature.utils.ConnectionUtil;

public class BikePostgres implements BikeDao {
	
	@Override
	public List<Bike> getAllBikes() {
		String sql = "SELECT * FROM bikes ORDER BY id;";
		List<Bike> bikes = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("t_pe");
				String color = rs.getString("color");
				String m_f_config = rs.getString("m_f_config");		
				int speeds = rs.getInt("speeds");
				
				Bike nwBk = new Bike(id, type, color, m_f_config, speeds);
				bikes.add(nwBk);
			}
		} catch (SQLException | IOException b) {
			b.printStackTrace();
		}
		return bikes;
	}

	@Override
	public int addABike(Bike bike) {
		int newId = -1;
		String sql = "INSERT INTO bikes (t_pe, color, m_f_config, speeds)"
				+ " VALUES ( ?, ?, ?, ? ) RETURNING id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, bike.getType());
			ps.setString(2, bike.getColor());
			ps.setString(3, bike.getM_f_config());
			ps.setInt(4, bike.getSpeeds());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				newId = rs.getInt("id");
			}
			
		} catch (SQLException | IOException b) {
			b.printStackTrace();
		}
		
		return newId;
	}


}
