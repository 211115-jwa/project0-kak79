package com.revature.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Dog;
import com.revature.utils.ConnectionUtil;

public class DogPostgres implements DogDao 
{
	

	
	@Override
	public List<Dog> getAllDogs()
	{
		String sql = "SELECT"
				+ "	dog.id,"
				+ "	dog.n_me AS dog_name,"
				+ "	dog.gender,"
				+ "	dog.breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ "	breed.breed_size,"
				+ "	breed.breed_group,"
				+ "	breed.active_lvl,"
				+ "	breed.bark_amt,"
				+ "	breed.coat_tp,"
				+ "	breed.coat_lngth,"
				+ "	breed.shedd,"
				+ "	breed.train"
				+ "	FROM dog"
				+ "	FULL OUTER JOIN breed"
				+ " ON breed.breed_name = dog.breed"
				+ " ORDER BY dog.id;";
		List<Dog> dogs = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
		{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("dog_name");
				String gender = rs.getString("gender");
				String breed = rs.getString("breed");
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Dog nwDg = new Dog(id, name, gender, breed, akcRegistration,
							 age,fixed, size, group, activityLvl, barkingAmt,
							 coatType, coatLength, shedding, trainability);
				dogs.add(nwDg);
			}
		} 
		catch (SQLException | IOException b) 
		{
			b.printStackTrace();
		}
		return dogs;
	}

	@Override
	public List<Dog> getAllDogsWhereGenderIs(String dogGender)
	{
		String sql = "SELECT"
				+ "	dog.id,"
				+ "	dog.n_me AS dog_name,"
				+ "	dog.gender,"
				+ "	dog.breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ "	breed.breed_size,"
				+ "	breed.breed_group,"
				+ "	breed.active_lvl,"
				+ "	breed.bark_amt,"
				+ "	breed.coat_tp,"
				+ "	breed.coat_lngth,"
				+ "	breed.shedd,"
				+ "	breed.train"
				+ "	FROM dog"
				+ "	FULL OUTER JOIN breed"
				+ " ON breed.breed_name = dog.breed"
				+ " WHERE dog.gender = ?"
				+ " ORDER BY dog.id;";
				
		List<Dog> dogs = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
		{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dogGender);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("dog_name");
				String gender = rs.getString("gender");
				String breed = rs.getString("breed");
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Dog nwDg = new Dog(id, name, gender, breed, akcRegistration,
							 age,fixed, size, group, activityLvl, barkingAmt,
							 coatType, coatLength, shedding, trainability);
				dogs.add(nwDg);
			}
		} 
		catch (SQLException | IOException b) 
		{
			b.printStackTrace();
		}
		return dogs;
	}
	
	@Override
	public List<Dog> getAllDogsWhereSizeIs(String dogSize)
	{
		String sql = "SELECT"
				+ "	dog.id,"
				+ "	dog.n_me AS dog_name,"
				+ "	dog.gender,"
				+ "	dog.breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ "	breed.breed_size,"
				+ "	breed.breed_group,"
				+ "	breed.active_lvl,"
				+ "	breed.bark_amt,"
				+ "	breed.coat_tp,"
				+ "	breed.coat_lngth,"
				+ "	breed.shedd,"
				+ "	breed.train"
				+ "	FROM dog"
				+ "	FULL OUTER JOIN breed"
				+ " ON breed.breed_name = dog.breed"
				+ " WHERE breed.breed_size = ?"
				+ " ORDER BY dog.id;";
				
		List<Dog> dogs = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
		{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dogSize);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) 
			{
				
				int id = rs.getInt("id");
				String name = rs.getString("dog_name");
				String gender = rs.getString("gender");
				String breed = rs.getString("breed");
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Dog nwDg = new Dog(id, name, gender, breed, akcRegistration,
							 age,fixed, size, group, activityLvl, barkingAmt,
							 coatType, coatLength, shedding, trainability);
				dogs.add(nwDg);
			}
		} 
		catch (SQLException | IOException b) 
		{
			b.printStackTrace();
		}
		
		return dogs;
	}
	
	@Override
	public int addADog(Dog dog) {
		int newId = -1;
//		String sql = "INSERT INTO dog (n_me, gender, breed, siz_, akc_reg"
//				+ " ag_, gr_up, activity_lev, bark_amt, coat_type, shedd"
//				+ " trainability)"
//				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) RETURNING id;";
//		
//		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
//		{
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setString(1, dog.getName());
//			ps.setString(2, dog.getGender());
//			ps.setString(3, dog.getBreed());
//			ps.setString(4, dog.getSize());
//			ps.setBoolean(5, dog.isAkcRegistration());
//			ps.setInt(6, dog.getAge());
//			ps.setString(7, dog.getGroup());
//			ps.setString(8, dog.getActivityLevel());
//			ps.setString(9, dog.getBarkingAmount());
//			ps.setString(10, dog.getCoatType());
//			ps.setString(11, dog.getSheddingFrequency());
//			ps.setString(12, dog.getTrainability());
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) 
//			{
//				int id = rs.getInt("id");
//				
//				newId = id;
//			}
//		} 
//		catch (SQLException | IOException b) 
//		{
//			b.printStackTrace();
//		}
//		
		return newId;
	}

}