package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.revature.exceptions.InvalidEntryException;
import com.revature.models.Breed;
import com.revature.models.Dog;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {
	
	@Mock
	private DogDao dd = new DogPostgres();
	
	@InjectMocks
	private DogService ds = new DogServImp();
	
	private static List<Dog> mockDogs = new ArrayList<>();
	private static List<Dog> mockGirls = new ArrayList<>();
	private static List<Dog> mockBoys = new ArrayList<>();
	private static List<Dog> mockSmall = new ArrayList<>();
	private static List<Dog> mockLarge = new ArrayList<>();
	private static List<Breed> mockBreeds = new ArrayList<>();
	
	static Breed testBreed1 = new Breed(1,"Akita", "L", "Working Group",
			"Regular Exercise", "When Necessary", "Double", "Medium", 
			"Regularly", "Agreeable");
	static Breed testBreed2 = new Breed(2,"Bichon Frise", "S", "Non-Sporting Group", "Regular Exercise", "Medium", "Double", "Long", "Infrequent", "Independent");
	
	static Dog testDog1 = new Dog(1, "Jack", "m", true, 1, false, testBreed1);
	static Dog testDog2 = new Dog(2, "Jill", "f", true, 1, false, testBreed1);
	static Dog testDog3 = new Dog(3, "Jack Frost", "m", true, 1, false, testBreed2);
	static Dog testDog4 = new Dog(4, "Jill Frost", "f", true, 1, false, testBreed2);
	
	@BeforeAll
	public static void mockDogsSetup() {
		mockBreeds.add(testBreed1);
		mockBreeds.add(testBreed2);
		mockDogs.add(testDog1);
		mockDogs.add(testDog2);
		mockDogs.add(testDog3);
		mockDogs.add(testDog4);
		mockGirls.add(testDog2);
		mockGirls.add(testDog4);
		mockBoys.add(testDog1);
		mockBoys.add(testDog3);
		mockSmall.add(testDog3);
		mockSmall.add(testDog4);
		mockLarge.add(testDog1);
		mockLarge.add(testDog2);
	}
	
	@Test
	public void getAllDogs() {
		when(dd.getAllDogs()).thenReturn(mockDogs);
		List<Dog> actual = ds.getAllDogs();
		assertEquals(mockDogs, actual);
	}
	
	
	@Test
	public void searchByGenderWrongEntry() throws InvalidEntryException 
	{
		assertThrows(InvalidEntryException.class, () -> 
			ds.getAllDogsWhereGenderIs("female"), 
			"Expected getAllDogsWhereGenderIs to "
			+ "have the Paremeter m or f");
	}	
	
	
	@Test
	public void searchByFemaleDogs() throws InvalidEntryException {
		String gender = "f";
		
		when(dd.getAllDogsWhereGenderIs(gender)).thenReturn(mockGirls);
		List<Dog> justGirls = ds.getAllDogsWhereGenderIs(gender);
		assertEquals(mockGirls, justGirls);	
	}


	@Test
	public void searchByMaleDogs() throws InvalidEntryException {
		String gender = "m";
		
		when(dd.getAllDogsWhereGenderIs(gender)).thenReturn(mockBoys);
		List<Dog> justBoys = ds.getAllDogsWhereGenderIs(gender);
		assertEquals(mockBoys, justBoys);	
	}
	
	
	@Test
	public void searchBySizeWrongEntry() throws InvalidEntryException 
	{
		assertThrows(InvalidEntryException.class, () -> 
			ds.getAllDogsWhereSizeIs("xl"), 
			"Expected getAllDogsWhereSizeIs to "
			+ "have the Paremeter XS, S, M, L, or XL");
	}	
	
	
	@Test
	public void searchBySDogs() throws InvalidEntryException {
		String size = "S";
		
		when(dd.getAllDogsWhereSizeIs(size)).thenReturn(mockSmall);
		List<Dog> justSmall = ds.getAllDogsWhereSizeIs(size);
		assertEquals(mockSmall, justSmall);	
	}


	@Test
	public void searchByLDogs() throws InvalidEntryException {
		String size = "L";
		
		when(dd.getAllDogsWhereSizeIs(size)).thenReturn(mockLarge);
		List<Dog> justLarge = ds.getAllDogsWhereSizeIs(size);
		assertEquals(mockLarge, justLarge);	
	}	
	
	
	
	
	
//	@Test
//	public void getNoDogs() throws NoDogsFoundException 
//	{
//		assertThrows(NoDogsFoundException.class, () -> 
//			bd.getAllDogs(), "Expected getAllDogs to have Dogs");
//	}	
	

}

