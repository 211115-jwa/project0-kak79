package com.revature.models;

import java.util.Objects;

public class Dog {
	private int id;
	private String name;
	private String gender;
	private String breed;
	private boolean akcReg;
	private int age;
	private boolean fixed;
	private String size;
	private String group;
	private String activityLvl;
	private String barkingAmt;
	private String coatType;
	private String coatLength;
	private String shedding;
	private String trainability;
	
	public Dog(int id, String name, String gender, String breed, boolean akcReg, int age, boolean fixed, String size,
			String group, String activityLvl, String barkingAmt, String coatType, String coatLength, String shedding,
			String trainability) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.akcReg = akcReg;
		this.age = age;
		this.fixed = fixed;
		this.size = size;
		this.group = group;
		this.activityLvl = activityLvl;
		this.barkingAmt = barkingAmt;
		this.coatType = coatType;
		this.coatLength = coatLength;
		this.shedding = shedding;
		this.trainability = trainability;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getActivityLvl() {
		return activityLvl;
	}

	public void setActivityLvl(String activityLvl) {
		this.activityLvl = activityLvl;
	}

	public String getBarkingAmt() {
		return barkingAmt;
	}

	public void setBarkingAmt(String barkingAmt) {
		this.barkingAmt = barkingAmt;
	}

	public String getCoatType() {
		return coatType;
	}

	public void setCoatType(String coatType) {
		this.coatType = coatType;
	}

	public String getCoatLength() {
		return coatLength;
	}

	public void setCoatLength(String coatLength) {
		this.coatLength = coatLength;
	}

	public String getShedding() {
		return shedding;
	}

	public void setShedding(String shedding) {
		this.shedding = shedding;
	}

	public String getTrainability() {
		return trainability;
	}

	public void setTrainability(String trainability) {
		this.trainability = trainability;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", breed=" + breed + ", akcReg=" + akcReg
				+ ", age=" + age + ", fixed=" + fixed + ", size=" + size + ", group=" + group + ", activityLvl="
				+ activityLvl + ", barkingAmt=" + barkingAmt + ", coatType=" + coatType + ", coatLength=" + coatLength
				+ ", shedding=" + shedding + ", trainability=" + trainability + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activityLvl, age, akcReg, barkingAmt, breed, coatLength, coatType, fixed, gender, group, id,
				name, shedding, size, trainability);
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
		return Objects.equals(activityLvl, other.activityLvl) && age == other.age && akcReg == other.akcReg
				&& Objects.equals(barkingAmt, other.barkingAmt) && Objects.equals(breed, other.breed)
				&& Objects.equals(coatLength, other.coatLength) && Objects.equals(coatType, other.coatType)
				&& fixed == other.fixed && Objects.equals(gender, other.gender) && Objects.equals(group, other.group)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(shedding, other.shedding)
				&& Objects.equals(size, other.size) && Objects.equals(trainability, other.trainability);
	}
}
