package com.revature.data;

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
	
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
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
		
		try (Connection con = cu.getConnection()) 
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
		catch (SQLException d) 
		{
			d.printStackTrace();
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
		
		try (Connection con = cu.getConnection()) 
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
		catch (SQLException d) 
		{
			d.printStackTrace();
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
		
		try (Connection con = cu.getConnection()) 
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
		catch (SQLException d) 
		{
			d.printStackTrace();
		}
		
		return dogs;
	}
	
	@Override
	public int getId(Dog dog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dog getOneById(int dogId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int createADog(Dog dog) {
		int newId = -1;
		String sql = "INSERT INTO dog "
				+ " (n_me, gender, breed, akc_reg, ag_, fixed)"
				+ " VALUES"
				+ " (?, ?, ?, ?, ?, ?)"
				+ " RETURNING id;";
		
		try (Connection con = cu.getConnection()) 
		{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dog.getName());
			ps.setString(2, dog.getGender());
			ps.setString(3, dog.getBreed());
			ps.setBoolean(4, dog.isAkcReg());
			ps.setInt(5, dog.getAge());
			ps.setBoolean(6, dog.isFixed());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) 
			{
				int id = rs.getInt("id");
				
				newId = id;
			}
		} 
		catch (SQLException d) 
		{
			d.printStackTrace();
		}
		
		return newId;
	}

	@Override
	public Dog editADog(Dog dog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteADog(int dogId) {
		// TODO Auto-generated method stub
		return false;
	}

}
