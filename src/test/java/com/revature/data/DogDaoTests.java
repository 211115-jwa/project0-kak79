package com.revature.data;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Dog;
import com.revature.utils.ConnectionUtil;

public class DogDaoTests {
	
	private DogDao dd = new DogPostgres();
	
	@BeforeEach
	public void setup() {
	dd = new DogPostgres();
	}
	
	public List<Dog> selectIdFromDogs() {
		String sql = "SELECT id FROM dogs";
		List<Dog> ids = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
		{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				
				Dog nwDg = new Dog(id);
				ids.add(nwDg);
			}
			} catch (SQLException | IOException b) 
			{
				b.printStackTrace();
			}
		return ids;
	}
	
	@Test
	public void getAllDogs() {
		List<Dog> ids = new ArrayList<>();
		ids = selectIdFromDogs();
		List<Dog> expected = ids;
		List<Dog> actual = dd.getAllDogIds();
		assertEquals(expected, actual);
	}
	
	
	
//	@Test
//	public void getNoDogs() throws NoDogsFoundException 
//	{
//		assertThrows(NoDogsFoundException.class, () -> 
//			bd.getAllDogs(), "Expected getAllDogs to have Dogs");
//	}
}
