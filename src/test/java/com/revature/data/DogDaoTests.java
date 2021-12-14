package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Breed;
import com.revature.models.Dog;

public class DogDaoTests 
{
	TestUtils tu = new TestUtils();
	private DogDao dd = new DogPostgres();
	
	@BeforeEach
	public void setup() 
	{
	dd = new DogPostgres();
	}
	
	@Test
	public void getAllNotNull() 
	{
		List<Dog> actual = dd.getAllDogs();
		assertNotEquals(null, actual);
	}


  	@Test
  	public void getAllDogs() 
  	{
		List<Dog> dogList = new ArrayList<>();
		dogList = tu.selectAllDogs();
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogs();
  		assertEquals(expected, actual);
 	}
  	
  	@Test
  	public void getAllGirlDogs()
  	{
		List<Dog> dogList = new ArrayList<>();
		String girlDogs = "f";
		dogList = tu.selectAllDogsWhereGenderIs(girlDogs);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereGenderIs(girlDogs);
  		assertEquals(expected, actual);
  	}
 
 	@Test
  	public void getAllBoyDogs()
  	{
		List<Dog> dogList = new ArrayList<>();
		String boyDogs = "m";
		dogList = tu.selectAllDogsWhereGenderIs(boyDogs);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereGenderIs(boyDogs);
  		assertEquals(expected, actual);
  	}
 	
 	@Test
 	public void getAllXSDogs()
 	{
		List<Dog> dogList = new ArrayList<>();
		String dogSize = "XS";
		dogList = tu.getAllDogsWhereSizeIs(dogSize);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereSizeIs(dogSize);
  		assertEquals(expected, actual);
 	}
	
	@Test
 	public void getAllSDogs()
 	{
		List<Dog> dogList = new ArrayList<>();
		String dogSize = "S";
		dogList = tu.getAllDogsWhereSizeIs(dogSize);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereSizeIs(dogSize);
  		assertEquals(expected, actual);
 	}
	
	@Test
 	public void getAllMDogs()
 	{
		List<Dog> dogList = new ArrayList<>();
		String dogSize = "M";
		dogList = tu.getAllDogsWhereSizeIs(dogSize);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereSizeIs(dogSize);
  		assertEquals(expected, actual);
 	}
	
	@Test
 	public void getAllLDogs()
 	{
		List<Dog> dogList = new ArrayList<>();
		String dogSize = "L";
		dogList = tu.getAllDogsWhereSizeIs(dogSize);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereSizeIs(dogSize);
  		assertEquals(expected, actual);
 	}
	
	@Test
 	public void getAllXLDogs()
 	{
		List<Dog> dogList = new ArrayList<>();
		String dogSize = "XL";
		dogList = tu.getAllDogsWhereSizeIs(dogSize);
		List<Dog> expected = dogList;
  		List<Dog> actual = dd.getAllDogsWhereSizeIs(dogSize);
  		assertEquals(expected, actual);
 	}
	
	@Test
	public void getADogById()
	{
		Dog testDog = new Dog();
		int tstDg = 3;
		testDog = tu.selectOneById(tstDg);
		Dog expected = testDog;
		Dog actual = dd.getOneById(tstDg);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void createADog()
	{
		Breed akita = new Breed(1);
		Dog testDog = new Dog("TestName", "f" , false, 0, false, akita);
		int expected = -1;
  		int actual = dd.createADog(testDog);
  		assertNotEquals(expected, actual);
	}
	
	
//	String name, String gender, String breed, boolean akcReg, int age, boolean fixed
	
	
//	@Test
//	public void getNoDogs() throws NoDogsFoundException 
//	{
//		assertThrows(NoDogsFoundException.class, () -> 
//			bd.getAllDogs(), "Expected getAllDogs to have Dogs");
//	}
}
