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
import com.revature.models.Dog;
import com.revature.utils.ConnectionUtil;

public class DogPostgres implements DogDao {
	
	@Override
	public List<Dog> getAllDogs() throws NoDog.{
		String sql = "SELECT * FROM dogs ORDER BY id;";
		List<Dog> dogs = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				boolean maleYes = rs.getBoolean("male_yes");
				String breed = rs.getString("breed");
				String size = rs.getString("siz_");
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("ag_");
				String group = rs.getString("gr_up");
				String activityLevel = rs.getString("activity_lev");
				String barkingAmount = rs.getString("bark_amt");
				String coatType = rs.getString("coat_type");
				String sheddingFrequency = rs.getString("shedd");
				String trainability = rs.getString("trainability");
				
				Dog nwDg = new Dog(id, name, maleYes, breed, size, akcRegistration,
							 age, group, activityLevel, barkingAmount, coatType,
							sheddingFrequency, trainability);
				dogs.add(nwDg);
			}
		} catch (SQLException | IOException b) {
			b.printStackTrace();
		}
		return dogs;
	}

	@Override
	public int addADog(Dog dog) {
		int newId = -1;
		String sql = "INSERT INTO dogs (t_pe, color, m_f_config, speeds)"
				+ " VALUES ( ?, ?, ?, ? ) RETURNING id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			
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
