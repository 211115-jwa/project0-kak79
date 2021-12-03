package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.NoDogsFoundException;
import com.revature.models.Dog;
import com.revature.utils.ConnectionUtil;

public class DogDaoTests {
	
	private DogDao bd = new DogPostgres();
	
	@BeforeEach
	public void setup() {
	bd = new DogPostgres();
	}
	
	public List<Dog> selectIdFromBikes() {
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
	public void getNoDogs() throws NoDogsFoundException 
	{
		assertThrows(NoDogsFoundException.class, () -> 
			bd.getAllDogs(), "Expected getAllDogs to have Dogs");
	}
}
