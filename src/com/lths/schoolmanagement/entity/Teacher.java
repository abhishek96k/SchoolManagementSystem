package com.lths.schoolmanagement.entity;

public class Teacher extends Person {
	int id;
	String qualification;
	String subject;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Teacher(String name, int age, String address, int id, String qualification, String subject) 
	{
		super(name,age,address);
		this.id = id;
		this.qualification = qualification;
		this.subject = subject;	
	}
	@Override
	public void work() {
		System.out.println("Works as Teacher...");
	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Teacher [id=" + id + ", qualification=" + qualification + ", subject=" + subject + "]";
	}
	
}
