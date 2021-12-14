package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.data.DogDao;
import com.revature.data.DogPostgres;
import com.revature.models.Breed;
import com.revature.models.Dog;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {
	
	@Mock
	private DogDao dd = new DogPostgres();
	
	@InjectMocks
	private DogService ds = new DogServImp();
	
	private static List<Dog> mockDogs = new ArrayList<>();
	private static List<Breed> mockBreeds = new ArrayList<>();
	
	Breed testBreed = new Breed(1,"Akita", "L", "Working Group", "Regular Exercise", "When Necessary", "Double", "Medium", "Regularly", "Agreeable");
	
	Dog testDog1 = new Dog(1, "Jack", "m", true, 1, false, testBreed);
	Dog testDog2 = new Dog(1, "Jill", "f", true, 1, false, testBreed);
	
	@BeforeAll
	public void mockDogsSetup() {
		mockBreeds.add(testBreed);
		mockDogs.add(testDog1);
		mockDogs.add(testDog2);
	}
	
	@Test
	public void getAllDogs() {
		
		when(dd.getAllDogs()).thenReturn(mockDogs);
		List<Dog> actual = ds.getAllDogs();
		
		assertEquals(mockDogs, actual);
		
	}

}

