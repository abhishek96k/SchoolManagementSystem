package com.lths.schoolmanagement.entity;

public abstract class Person {
	
	private String name;
	
	private int age;
	
	private String address;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void printDetails(Person p) 
	{
		System.out.println("Person details.");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getAddress());
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	public abstract void work();
	
}
