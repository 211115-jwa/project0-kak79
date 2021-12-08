package com.revature.data;

import java.util.List;

import com.revature.models.Dog;

public interface DogDao {
	

	
	List<Dog> getAllDogs(); //query DB and return a list of all Bikes in the DB
	
	List<Dog> getAllDogsWhereGenderIs(String dogGender);
	
	List<Dog> getAllDogsWhereSizeIs(String dogSize);
	
	int addADog(Dog dog); //given the paremeter of a Bike object, return a Bike id int

	

}
