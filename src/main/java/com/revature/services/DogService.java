package com.revature.services;

import com.revature.models.Dog;

public interface DogService {
	
	int addNewDog(Dog dog);
	Dog editDog(Dog dog);
	Dog getDogById(int dogID);
}
