package com.revature.models;

import java.util.Objects;

public class Dog {
	private int id;
	private String name;
	private String gender;
	private String breed;
	private String size;
	private boolean akcRegistration;
	private int age;
	private String group;
	private String activityLevel;
	private String barkingAmount;
	private String coatType;
	private String sheddingFrequency;
	private String trainability;
	
	public Dog(int id, String name, String gender, String breed, String size,
			boolean akcRegistration, int age, String group, String activityLevel, 
			String barkingAmount, String coatType, String sheddingFrequency,
			String trainability) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.size = size;
		this.akcRegistration = akcRegistration;
		this.age = age;
		this.group = group;
		this.activityLevel = activityLevel;
		this.barkingAmount = barkingAmount;
		this.coatType = coatType;
		this.sheddingFrequency = sheddingFrequency;
		this.trainability = trainability;
	}

	public Dog(String name, String gender, String breed, String size, boolean akcRegistration, int age,
			String group, String activityLevel, String barkingAmount, String coatType, String sheddingFrequency,
			String trainability) {
		super();
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.size = size;
		this.akcRegistration = akcRegistration;
		this.age = age;
		this.group = group;
		this.activityLevel = activityLevel;
		this.barkingAmount = barkingAmount;
		this.coatType = coatType;
		this.sheddingFrequency = sheddingFrequency;
		this.trainability = trainability;
	}

	public Dog(int id) {
		super();
		this.id = id;
	}

	public Dog() {
		super();
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isAkcRegistration() {
		return akcRegistration;
	}

	public void setAkcRegistration(boolean akcRegistration) {
		this.akcRegistration = akcRegistration;
	}

	public double getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String getBarkingAmount() {
		return barkingAmount;
	}

	public void setBarkingAmount(String barkingAmount) {
		this.barkingAmount = barkingAmount;
	}

	public String getCoatType() {
		return coatType;
	}

	public void setCoatType(String coatType) {
		this.coatType = coatType;
	}

	public String getSheddingFrequency() {
		return sheddingFrequency;
	}

	public void setSheddingFrequency(String sheddingFrequency) {
		this.sheddingFrequency = sheddingFrequency;
	}

	public String getTrainability() {
		return trainability;
	}

	public void setTrainability(String trainability) {
		this.trainability = trainability;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", breed=" + breed + ", size=" + size
				+ ", akcRegistration=" + akcRegistration + ", age=" + age + ", group=" + group + ", activityLevel="
				+ activityLevel + ", barkingAmount=" + barkingAmount + ", coatType=" + coatType + ", sheddingFrequency="
				+ sheddingFrequency + ", trainability=" + trainability + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activityLevel, age, akcRegistration, barkingAmount, breed, coatType, group,
				id, gender, name, sheddingFrequency, size, trainability);
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
		return Objects.equals(activityLevel, other.activityLevel) && age == other.age
				&& akcRegistration == other.akcRegistration && Objects.equals(barkingAmount, other.barkingAmount)
				&& Objects.equals(breed, other.breed)
				&& Objects.equals(coatType, other.coatType) && Objects.equals(group, other.group) && id == other.id
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& Objects.equals(sheddingFrequency, other.sheddingFrequency) && Objects.equals(size, other.size)
				&& Objects.equals(trainability, other.trainability);
	}

	
	

}
