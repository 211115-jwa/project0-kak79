package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Breed;
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
				+ "	breed.breed_name AS breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ " breed.id AS breed_id,"
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
				+ " ON breed.id = dog.breed_id"
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
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				int brd_id = rs.getInt("breed_id");
				String brd_name = rs.getString("breed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Breed breed = new Breed(brd_id, brd_name, size, group, activityLvl, 
					barkingAmt, coatType, coatLength, shedding, trainability);
				Dog nwDg = new Dog(id, name, gender, akcRegistration,
							 age, fixed, breed);
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
				+ "	breed.breed_name AS breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ " breed.id AS breed_id,"
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
				+ " ON breed.id = dog.breed_id"
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
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				int brd_id = rs.getInt("breed_id");
				String brd_name = rs.getString("breed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Breed breed = new Breed(brd_id, brd_name, size, group, activityLvl, 
					barkingAmt, coatType, coatLength, shedding, trainability);
				Dog nwDg = new Dog(id, name, gender, akcRegistration,
							 age, fixed, breed);
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
				+ "	breed.breed_name AS breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ " breed.id AS breed_id,"
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
				+ " ON breed.id = dog.breed_id"
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
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				int brd_id = rs.getInt("breed_id");
				String brd_name = rs.getString("breed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Breed breed = new Breed(brd_id, brd_name, size, group, activityLvl, 
					barkingAmt, coatType, coatLength, shedding, trainability);
				Dog nwDg = new Dog(id, name, gender, akcRegistration,
							 age, fixed, breed);
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
	public Dog getOneById(int dogId) {
		String sql = "SELECT"
				+ "	dog.id,"
				+ "	dog.n_me AS dog_name,"
				+ "	dog.gender,"
				+ "	breed.breed_name AS breed,"
				+ "	dog.akc_reg,"
				+ "	dog.ag_ AS dog_age,"
				+ "	dog.fixed,"
				+ " breed.id AS breed_id,"
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
				+ " ON breed.id = dog.breed_id"
				+ " WHERE dog.id = ?;";
				
		Dog dog = new Dog();
		
		try (Connection con = cu.getConnection()) 
		{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, dogId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("dog_name");
				String gender = rs.getString("gender");
				boolean akcRegistration = rs.getBoolean("akc_reg");
				int age = rs.getInt("dog_age");
				boolean fixed = rs.getBoolean("fixed");
				int brd_id = rs.getInt("breed_id");
				String brd_name = rs.getString("breed");
				String size = rs.getString("breed_size");
				String group = rs.getString("breed_group");
				String activityLvl = rs.getString("active_lvl");
				String barkingAmt = rs.getString("bark_amt");
				String coatType = rs.getString("coat_tp");
				String coatLength = rs.getString("coat_lngth");
				String shedding = rs.getString("shedd");
				String trainability = rs.getString("train");
				
				Breed breed = new Breed(brd_id, brd_name, size, group, activityLvl, 
					barkingAmt, coatType, coatLength, shedding, trainability);
				dog = new Dog(id, name, gender, akcRegistration,
							 age, fixed, breed);
				
			}
		} 
		catch (SQLException d) 
		{
			d.printStackTrace();
		}
		
		return dog;
	}
	
	@Override
	public int createADog(Dog dog) {
		int id = -1;
		String sql = "INSERT INTO dog "
				+ " (n_me, gender, breed_id, akc_reg, ag_, fixed)"
				+ " VALUES"
				+ " (?, ?, ?, ?, ?, ?)"
				+ " RETURNING id;";
		
		try (Connection con = cu.getConnection()) 
		{
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dog.getName());
			ps.setString(2, dog.getGender());
			ps.setInt(3, dog.getBreed().getId());
			ps.setBoolean(4, dog.isAkcReg());
			ps.setInt(5, dog.getAge());
			ps.setBoolean(6, dog.isFixed());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) 
			{ 
				id = rs.getInt("id");
				con.commit();
			} 
			else 
			{
				con.rollback();
			}

		} 
		catch (SQLException d) 
		{
			d.printStackTrace();
		}
		
		return id;
	}

	@Override
	public void editADog(Dog dog) {
		String sql = "UPDATE dog SET"
				+ " n_me = ?,"
				+ " gender = ?,"
				+ " breed_id = ?,"
				+ " akc_reg = ?,"
				+ " ag_ = ?,"
				+ " fixed = ?"
				+ " WHERE id = ?;";
		
		try (Connection con = cu.getConnection()) 
		{
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dog.getName());
			ps.setString(2, dog.getGender());
			ps.setInt(3, dog.getBreed().getId());
			ps.setBoolean(4, dog.isAkcReg());
			ps.setInt(5, dog.getAge());
			ps.setBoolean(6, dog.isFixed());
			ps.setInt(7, dog.getId());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected==1) 
			{ 
				con.commit();
			} 
			else 
			{
				con.rollback();
			}

		} 
		catch (SQLException d) 
		{
			d.printStackTrace();
		}
	}

}
