package com.in;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {

		
		List<Employee> employee = EmployeeData.get();
		
		//list of all employee
//		employee.stream()
//		.forEach(e->System.out.println(e));
		
		//salary > 20k and lastname starts with "p"
//		employee.stream()
//		.filter(e->e.getSalary() > 7000.0)
//		.filter(e->e.getFirstname().startsWith("p"))
//		.forEach(e->System.out.println(e));
		
		
		//sort by first name
//		employee.stream()
//		.sorted((e1,e2)->e1.getFirstname().compareTo(e2.getFirstname()))
//		.forEach(e->System.out.println(e));
		
		
		
		//only first name in sorted order
//		employee.stream()
//		.map(e->e.getFirstname())
//		.distinct()
//		.sorted()
//		.forEach(e->System.out.println(e));
		
		
//		//count employees in IT department
//		System.out.println(
//		employee.stream()
//		.filter(e->e.getDepartment().equals("IT"))
//		.count());
	
		//sum of salaries of employees in IT department
//				System.out.println(
//				employee.stream()
//				.filter(e->e.getDepartment().equals("IT"))
//				.mapToDouble(e->e.getSalary())
//				.sum());
		
		//Max salaries of employees
//		System.out.println(
//				employee.stream()
//				.mapToDouble(e->e.getSalary())
//				.min()
//				);
		        
		
		//List of employee first name
		List<String> empNames= employee.stream()
		.map(e->e.getFirstname())
		.distinct()
		.collect(Collectors.toList());   
		System.out.println(empNames);
		
		System.out.println(empNames.getClass());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
