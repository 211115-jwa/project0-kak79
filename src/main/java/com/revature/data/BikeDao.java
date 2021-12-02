package com.revature.data;

import java.util.List;

import com.revature.models.Bike;

public interface BikeDao {
	List<Bike> getAllBikes(); //query DB and return a list of all Bikes in the DB
	
	int addABike(Bike bike); //given the paremeter of a Bike object, return a Bike id int

}
