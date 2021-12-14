package com.revature.data;

import java.util.List;

import com.revature.models.Dog;

public interface DogDao {
	
	List<Dog> getAllDogs(); 
	
	List<Dog> getAllDogsWhereGenderIs(String dogGender);
	
	List<Dog> getAllDogsWhereSizeIs(String dogSize);
		
	Dog getOneById(int dogId);
	
	int createADog(Dog dog); //make a Dog

	Dog editADog(Dog dog); // update
	
	boolean deleteADog(int dogId);//delete
	
}
