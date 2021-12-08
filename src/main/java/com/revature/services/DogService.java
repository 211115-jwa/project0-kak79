package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.data.DogPostgres;
import com.revature.models.Dog;

public class DogService {
	
	DogPostgres dp = new DogPostgres();

	public List<Dog> getAllDogs() {
		
		List<Dog> dog = new ArrayList<>();
		dog = dp.getAllDogs();
		return dog;
		
	}

	public List<Dog> getAllDogsWhereGenderIs(String dogGender) {
		
		List<Dog> dog = new ArrayList<>();
		dog = dp.getAllDogsWhereGenderIs(dogGender);
		return dog;
		
	}

	public List<Dog> getAllDogsWhereSizeIs(String dogSize) {
		
		List<Dog> dog = new ArrayList<>();
		dog = dp.getAllDogsWhereSizeIs(dogSize);
		return dog;
		
	}
	
	

}
