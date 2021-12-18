package com.revature.services;

import java.util.List;

import com.revature.exceptions.InvalidEntryException;
import com.revature.models.Dog;

public interface DogService {
	
	List<Dog> getAllDogs(); 
	
	List<Dog> getAllDogsWhereGenderIs(String dogGender) throws InvalidEntryException;
	
	List<Dog> getAllDogsWhereSizeIs(String dogSize) throws InvalidEntryException;
		
	Dog getOneById(int dogId);
	
	int createADog(Dog dog); //make a Dog

	Dog editADog(Dog dog); // update
	
}
