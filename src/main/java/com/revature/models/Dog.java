package com.revature.models;

import java.util.Objects;

public class Dog {
	private int id;
	private String name;
	private String gender;
	private boolean akcReg;
	private int age;
	private boolean fixed;
	private int breedId;
	
	Breed breed = new Breed(breedId);

	public Dog(int id, String name, String gender, boolean akcReg, int age, boolean fixed, Breed breed) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.akcReg = akcReg;
		this.age = age;
		this.fixed = fixed;
		this.breed = breed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAkcReg() {
		return akcReg;
	}

	public void setAkcReg(boolean akcReg) {
		this.akcReg = akcReg;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", akcReg=" + akcReg + ", age=" + age
				+ ", fixed=" + fixed + ", breed=" + breed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, akcReg, breed, fixed, gender, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return age == other.age && akcReg == other.akcReg && Objects.equals(breed, other.breed) && fixed == other.fixed
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name);
	}



}
