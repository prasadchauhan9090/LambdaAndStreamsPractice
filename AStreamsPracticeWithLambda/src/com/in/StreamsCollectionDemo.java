package com.in;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsCollectionDemo {
	

	public static void main(String args[])
	{
	List<Employee> employees = EmployeeData.get();
	
	
	employees.stream()
	.forEach(e->System.out.println(e.getFirstname()+" -->  "+e.getSalary()));
	 
	//joining the data
	//concat the firstnames of all the employees
	//staticf Collector<CharSequence,?,String> joining(charSequence delimiter)
	
	String empFirdtNameJoined =employees.stream()
	.map(e->e.getFirstname())
	.collect(Collectors.joining(", "));
	
	System.out.println(empFirdtNameJoined);
	
	//partitioning the data
	//split the list based on salary > 25000.0
	//static <T> Collector<T,?,Map<Boolean,List<T>> partitiomimgBy(Predicates<? super T> predicate)
//	   Map<Boolean, List<Employee>> employeeListBySal25K = employees.stream()
//			  .collect(Collectors.partitioningBy(e->e.getSalary()> 25000.0));
//	   System.out.println(employeeListBySal25K);
	//output: chauhan, shanvi, mooni, pavani, prasad, mooni, pavani, prasad
	  
	
//	Map<Boolean, Long> empsCountBySal25K = employees.stream()
//			  .collect(Collectors.partitioningBy(e->e.getSalary()> 25000.0, Collectors.counting()));
//	   System.out.println(empsCountBySal25K);
	   //output : {false=2, true=6}
	
	
	   //Grouping the data
	//Group the employee by their departement
	//Statis<T,K> Collector<T,?,Map<K,List<T>> groupingBy(Function<? super T,? extends K> classifier)
	Map<String, List<Employee>> empByDept=employees.stream()
	.collect(Collectors.groupingBy(e->e.getDepartment()));
	System.out.println(empByDept); 
	
	//group the employee by their department - count the employees by each department
	//static<T,K,A,D> Collectors<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier, Collector<?Super
	Map<String,Long> empsCountByDep = employees.stream()
	.collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting()));
	System.out.println(empsCountByDep);
	
	   
	   //group the employees by their department - List the employee name by each department
	employees.stream()
	.collect(Collectors.groupingBy(e->e.getDepartment(),
			Collectors.mapping(e->e.getFirstname(), Collectors.toList())));
	
	Map<Object, List<Object>> empByDept1 = employees.stream()
	        .collect(Collectors.groupingBy(
	                e -> e.getDepartment(),
	                Collectors.mapping(e -> e.getFirstname(), Collectors.toList())
	        ));

	empByDept1.forEach((dept, names) -> {
	    System.out.println(dept + " : " + names);
	});
	
	
	//GROUP THE EMPLOYEE BY THE THIER DEPARTMENT - SUM THE SALARIES OF EMPLOYEES BY EACH DEPARTMENT
	//STATIC<T> cOLLECTORS<T,?, OPTIONAL<T>> REDUCING(bINARYOPERATOR<T> OP)
	Map<String, Optional<Double>> sumOfSalaryByDept =employees.stream()
	.collect(Collectors.groupingBy(e->e.getDepartment(),
			Collectors.mapping(e->e.getSalary(), Collectors.reducing((a,b)->a+b))
			));
	
	System.out.println(sumOfSalaryByDept);
	
	
	
	
	System.out.println("-------------------------------------------------------------");
	
	Map<String, Double> sumofemployeeDept = employees.stream()
	.collect(Collectors.groupingBy(e->e.getDepartment(),
			Collectors.summingDouble(e->e.getSalary())
			));
	System.out.println("summing double of the employees: "+sumofemployeeDept);
	
	
	
	System.out.println("-------------------------------------------------------------"); 
	
	Map<Object, DoubleSummaryStatistics> sumarizingDoubleodEmployeeSal = employees.stream()
			.collect(Collectors.groupingBy(e->e.getDepartment(),
					Collectors.summarizingDouble(e->e.getSalary())
					));
			System.out.println("sumarizing double of the employees: "+sumarizingDoubleodEmployeeSal);

			System.out.println("-------------------------------------------------------------"); 
	   //only particular summary
		DoubleSummaryStatistics	sumar=employees.stream()
			.collect(Collectors.filtering(e->e.getDepartment().equals("CENTRAL"), 
					Collectors.summarizingDouble(e->e.getSalary())
					));
			System.out.println("sumarizing double of the employees: "+sumar);
			
			
			System.out.println("-------------------------------------------------------------"); 
			  
		//EMPLOYEE HIGHEST SALARY
		Optional<Employee> eldestemployee=employees.stream()
			.collect(Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge()));
			
			
			System.out.println(eldestemployee.get().getFirstname());
			
	
	}
}
