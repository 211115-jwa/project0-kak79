package com.revature.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.NoBikesFoundException;

public class BikeDaoTests {
	
	private BikeDao bd = new BikePostgres();
	
	@BeforeEach
	public void setup() {
	bd = new BikePostgres();
	}
	
	@Test
	public void getNoBikes() throws NoBikesFoundException {
		String sql = "SELECT id FROM bikes";
		String[] ids = new
	}

}
