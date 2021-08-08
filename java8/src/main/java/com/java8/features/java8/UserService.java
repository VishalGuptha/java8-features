package com.java8.features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {

	UserModel user1 = new UserModel(1L, "vchoudar1", 10000, 21, Arrays.asList("1","2"));
	UserModel user2 = new UserModel(2L, "vchoudar2", 9000, 23, Arrays.asList("3","4"));
	UserModel user3 = new UserModel(3L, "vchoudar3", 12000, 35, Arrays.asList("5","6"));
	UserModel user4 = new UserModel(4L, "vchoudar4", 15000, 35, Arrays.asList("7","8"));
	UserModel user5 = new UserModel(5L, "vchoudar5", 16000, 38, Arrays.asList("9","10"));
	UserModel user6 = new UserModel(6L, "vchoudar6", 1000, 40, Arrays.asList("1","2"));
	UserModel user7 = new UserModel(7L, "vchoudar7", 9000, 20, Arrays.asList("3","4"));
	UserModel user8 = new UserModel(8L, "vchoudar8", 8000, 27, Arrays.asList("5","6"));
	UserModel user9 = new UserModel(9L, "vchoudar9", 50000, 26, Arrays.asList("7","8"));
	UserModel user10 = new UserModel(10L, "vchoudar10", 50000, 36, Arrays.asList("9","10"));
	UserModel user11 = new UserModel(11L, "vchoudar11", 40000, 38, Arrays.asList("1","2"));
	UserModel user12 = new UserModel(12L, "vchoudar12", 4000, 35, Arrays.asList("2","3"));
	UserModel user13 = new UserModel(13L, "vchoudar13", 9000, 21, Arrays.asList("4","5"));
	UserModel user14 = new UserModel(14L, "vchoudar14", 7000, 24, Arrays.asList("6","7"));
	
	List<UserModel> list = Arrays.asList(user1, user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12,user13,user14);
	
	
	//java 8 operations on a ArrayList
	public void userServiceWithFilter()
	{
		
		//for collecting after filtering
		List<UserModel> listResponse = list.stream().filter(u-> (u.getAge() > 30) && (u.getSalary() > 10000)).collect(Collectors.toList());
		
		//by passing method reference
		listResponse.forEach(System.out::println);
		
		System.out.println("\n");
		
		//by passing lambda expression
		listResponse.forEach(userModel -> System.out.println(userModel));
		System.out.println(listResponse.size());
		
		
		//use stream().filter() and print in the same step without collecting
		list.stream().filter(u-> (u.getAge() > 30) && (u.getSalary() > 10000)).forEach(System.out::println);
		
		
		System.out.println("\n");
		
	}
	
	
	public void userServiceWithMap()
	{
		System.out.println("\n");
		
		//want to modify current list
		//list.forEach(u -> u.setAge(u.getAge()+1));
		
		//want to store updated records in new list
		List<UserModel> updatedList = list.stream().map(u -> new UserModel(u.getId(), u.getUserName(), u.getSalary(), u.getAge()+1, u.getPhoneNumbers())).collect(Collectors.toList());
		updatedList.stream().filter(u-> (u.getAge() > 30) && (u.getSalary() > 10000)).forEach(System.out::println);
		
		System.out.println("\n");
		
		
	}
	
	
	public void userServiceWithMapToInt()
	{
		int totalSalaryBudget = list.stream().mapToInt(UserModel:: getSalary).sum();
		
		System.out.println(totalSalaryBudget);
		
		System.out.println("\n");
	}
	
	
	//to Iterate list inside a list and filter with conditions
	public void userServiceWithFlatMapAndOptional()
	{
		Optional<String> matchingResultsWithPhoneNumbers = list.stream().map(u -> u.getPhoneNumbers().stream())
				.flatMap(phoneNumbers -> phoneNumbers.filter(phoneNumber -> phoneNumber.equals("6"))).findAny();

		matchingResultsWithPhoneNumbers.ifPresent(phoneNumber -> System.out.println(phoneNumber));

		System.out.println("\n");

		List<UserModel> updatedList = list.stream().filter(u -> u.getPhoneNumbers().stream().anyMatch(phoneNumber -> phoneNumber.equals("6"))).collect(Collectors.toList());

		updatedList.forEach(System.out::println);

		System.out.println("\n");
	}
	
	
	
	
}
