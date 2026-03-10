package com.in;

public class Employee {
	
	
	private int id;
	private String firstname;
	private String lastname;
	private String department;
	private String jobtitle;
	private double salary;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", department="
				+ department + ", jobtitle=" + jobtitle + ", salary=" + salary + ", age=" + age + "]";
	}
	public Employee(int id, String firstname, String lastname, String department, String jobtitle, double salary,
			int age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.jobtitle = jobtitle;
		this.salary = salary;
		this.age = age;
	}
	
	
	public Employee()
	{
		
	}
}
