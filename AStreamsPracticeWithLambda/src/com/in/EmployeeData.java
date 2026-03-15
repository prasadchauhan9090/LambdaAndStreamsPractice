package com.in;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeData {
	
	public static ArrayList<Employee> get()
	{
		return new ArrayList<Employee>(Arrays.asList(
				
				new Employee(1, "chauhan","prasad","SOFTWARE","Developer", 89000,26),
				new Employee(2, "shanvi","korra","GOVT","Tester",99000,21),
				new Employee(3, "mooni","rathod","IT","Dev",67000,24),
				new Employee(4, "pavani","rathod","CENTRAL","Developer",8540,23),
				new Employee(5, "prasad","chauhan","STATE","QA",69000,28),
				new Employee(3, "mooni","rathod","IT","Dev",67000,24),
				new Employee(4, "pavani","rathod","CENTRAL","Developer",90504,23),
				new Employee(5, "prasad","chauhan","STATE","QA",169000,28)
				
				));
		
	}

}
