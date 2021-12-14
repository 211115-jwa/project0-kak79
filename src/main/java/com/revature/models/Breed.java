package com.revature.models;

import java.util.Objects;

public class Breed {
	
	private int id;
	private String name;
	private String size;
	private String group;
	private String activityLvl;
	private String barkingAmt;
	private String coatType;
	private String coatLength;
	private String shedding;
	private String trainability;
	
	public Breed(int id, String name, String size, String group, String activityLvl, String barkingAmt, String coatType,
			String coatLength, String shedding, String trainability) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.group = group;
		this.activityLvl = activityLvl;
		this.barkingAmt = barkingAmt;
		this.coatType = coatType;
		this.coatLength = coatLength;
		this.shedding = shedding;
		this.trainability = trainability;
	}
	
	public Breed(String name, String size, String group, String activityLvl, String barkingAmt, String coatType,
			String coatLength, String shedding, String trainability) {
		super();
		this.name = name;
		this.size = size;
		this.group = group;
		this.activityLvl = activityLvl;
		this.barkingAmt = barkingAmt;
		this.coatType = coatType;
		this.coatLength = coatLength;
		this.shedding = shedding;
		this.trainability = trainability;
	}

	public Breed(int id) {
		super();
		this.id = id;
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
		return "Breed [id=" + id + ", name=" + name + ", size=" + size + ", group=" + group + ", activityLvl="
				+ activityLvl + ", barkingAmt=" + barkingAmt + ", coatType=" + coatType + ", coatLength=" + coatLength
				+ ", shedding=" + shedding + ", trainability=" + trainability + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activityLvl, barkingAmt, coatLength, coatType, group, id, name, shedding, size,
				trainability);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Breed other = (Breed) obj;
		return Objects.equals(activityLvl, other.activityLvl) && Objects.equals(barkingAmt, other.barkingAmt)
				&& Objects.equals(coatLength, other.coatLength) && Objects.equals(coatType, other.coatType)
				&& Objects.equals(group, other.group) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(shedding, other.shedding) && Objects.equals(size, other.size)
				&& Objects.equals(trainability, other.trainability);
	}
	
	
	
}
