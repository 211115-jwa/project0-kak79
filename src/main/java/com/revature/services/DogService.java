package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.data.DogPostgres;
import com.revature.exceptions.invalidEntryException;
import com.revature.models.Dog;

public class DogService {
	
	DogPostgres dp = new DogPostgres();

	public List<Dog> getAllDogs() {
		
		List<Dog> dog = new ArrayList<>();
		dog = dp.getAllDogs();
		return dog;
		
	}

	public List<Dog> getAllDogsWhereGenderIs(String dogGender) throws invalidEntryException {
		List<Dog> dog = new ArrayList<>();
		if (dogGender != "f" || dogGender != "m") 
		{
			try  
			{
				throw new invalidEntryException("Your Entry Must Be m or f!");
			}
			catch (invalidEntryException i)
			{	
				i.printStackTrace();
			}
		}
		else 
		{
			dog = dp.getAllDogsWhereGenderIs(dogGender);
			return dog;		
		}
		return dog;

	}

	public List<Dog> getAllDogsWhereSizeIs(String dogSize) {
		
		List<Dog> dog = new ArrayList<>();
		dog = dp.getAllDogsWhereSizeIs(dogSize);
		return dog;
		
	}
	
	

}
