package com.java8.features.java8;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	private String userName;
	private long id;
	private String firstName;
	private String lastName;
	private int salary;
	private int age;
	private List<String> phoneNumbers;
	
	public UserModel(long id, String userName, int salary, int age, List<String> phoneNumbers)
	{
		this.id = id;
		this.userName = userName;
		this.salary = salary;
		this.age = age;
		this.phoneNumbers = phoneNumbers;
		
	}
	
	public UserModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return "userName : " + userName + " id : " + id + " salary : " + salary + " age : " + age + "phoneNumbers : " + phoneNumbers;
	}
}
