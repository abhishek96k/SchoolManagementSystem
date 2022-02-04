package com.lths.schoolmanagement.entity;

public class Student extends Person
{
	int rollNo;
	int standard;
	String areaOfInterest;
	
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public Student(String name, int age, String address, int rollNo, int standard, String areaOfInterest) {
		
		super(name, age, address);
		this.rollNo = rollNo;
		this.standard = standard;
		this.areaOfInterest = areaOfInterest;
		
	}

	@Override 
	public void work(){
		System.out.println("Work as Student...");
	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Student [rollNo=" + rollNo + ", standard=" + standard + ", areaOfInterest=" + areaOfInterest + "]";
	}

}
