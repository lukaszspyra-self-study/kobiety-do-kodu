package pl.kobietydokodu.learningjavapart1.cats;

import java.util.Date;

public class Cat {
	private String catName;
	private Date dateOfBirth;
	private Float weight;
	private String ownerName;
	
	public String introduceYourself() {
		return ("Hi I am cat, my name is "+catName+", I was born on "+dateOfBirth+", my weigth is "+weight+",my owner's name is "+ownerName);
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
}

