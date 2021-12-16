package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.data.DogDao;
import com.revature.data.DogPostgres;
import com.revature.exceptions.InvalidEntryException;
import com.revature.models.Dog;

public class DogServImp implements DogService {
	
	DogDao dd = new DogPostgres();

	@Override
	public List<Dog> getAllDogs() 
	{
		List<Dog> dog = new ArrayList<>();
		dog = dd.getAllDogs();
		return dog;
	}

	@Override
	public List<Dog> getAllDogsWhereGenderIs(String dogGender) throws InvalidEntryException 
	{
		if (!dogGender.equals("f") && !dogGender.equals("m")) 
		{
			
			throw new InvalidEntryException(
					"Dog Gender Must be Either m OR f!! \n"
					+ "https://httpstatusdogs.com/img/400.jpg");
		}
		else 
		{
			List<Dog> dog = new ArrayList<>();
			dog = dd.getAllDogsWhereGenderIs(dogGender);
			return dog;
				
		}
	}

	@Override
	public List<Dog> getAllDogsWhereSizeIs(String dogSize) throws InvalidEntryException
	{
		if (!dogSize.equals("XS") && !dogSize.equals("S") && !dogSize.equals("M") && !dogSize.equals("L") && !dogSize.equals("XL")) 
		{
			throw new InvalidEntryException(
					"Dog Size Must be Either XS, S, M, L or XL!! \n"
					+ "https://httpstatusdogs.com/img/400.jpg");
		}
		else 
		{
			List<Dog> dog = new ArrayList<>();
			dog = dd.getAllDogsWhereSizeIs(dogSize);
			return dog;
		}
	}

	@Override
	public Dog getOneById(int dogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createADog(Dog dog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dog editADog(Dog dog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteADog(int dogId) {
		// TODO Auto-generated method stub
		return false;
	}

}
