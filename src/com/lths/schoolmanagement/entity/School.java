package com.lths.schoolmanagement.entity;

public class School {

	private int schoolID;
	private String name;
	private String yearOfOpening;
	private String medium;
	
	
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYearOfOpening() {
		return yearOfOpening;
	}
	public void setYearOfOpening(String yearOfOpening) {
		this.yearOfOpening = yearOfOpening;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	public School(){
		
	}
	
	@Override
	public String toString() {
		return "School [schoolID=" + schoolID + ", name=" + name + ", yearOfOpening=" + yearOfOpening + ", medium="
				+ medium + "]";
	}
	public School(String name, String year, String medium, int schoolID){
		this.name = name;
		this.yearOfOpening = year;
		this.medium = medium;
		this.schoolID = schoolID;
		
	}
}
