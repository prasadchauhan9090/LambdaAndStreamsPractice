# Java 8 Streams Collection Operations

This project demonstrates various **Java 8 Stream API operations** using a list of `Employee` objects.
It shows how to use **Collectors** to process collections efficiently.

## Features Demonstrated

* Iterating using Streams
* Joining values
* Partitioning data
* Grouping data
* Mapping values
* Counting elements
* Summing salaries
* Summarizing statistics
* Finding maximum values

---

# Project Structure

```
project
│
├── Employee.java
├── EmployeeData.java
└── StreamsCollectionDemo.java
```

* **Employee.java** → Employee model class
* **EmployeeData.java** → Provides employee list data
* **StreamsCollectionDemo.java** → Demonstrates Java Stream operations

---

# Stream Operations Explained

## 1. Print Employee Names and Salaries

```java
employees.stream()
.forEach(e -> System.out.println(e.getFirstname() + " --> " + e.getSalary()));
```

Prints each employee's **first name and salary** using Stream `forEach`.

---

# 2. Joining Employee Names

Concatenates all employee names into a single string.

```java
String empFirstNameJoined = employees.stream()
        .map(e -> e.getFirstname())
        .collect(Collectors.joining(", "));
```

Example Output:

```
chauhan, shanvi, mooni, pavani, prasad
```

---

# 3. Partitioning Employees by Salary

Splits employees into two groups:

* Salary > 25000
* Salary ≤ 25000

```java
Map<Boolean, List<Employee>> employeeListBySal25K =
employees.stream()
.collect(Collectors.partitioningBy(e -> e.getSalary() > 25000.0));
```

Example Output

```
{false=[Employee1, Employee2], true=[Employee3, Employee4]}
```

---

# 4. Counting Employees by Salary Partition

```java
Map<Boolean, Long> empsCountBySal25K =
employees.stream()
.collect(Collectors.partitioningBy(
        e -> e.getSalary() > 25000.0,
        Collectors.counting()));
```

Example Output

```
{false=2, true=6}
```

---

# 5. Group Employees by Department

```java
Map<String, List<Employee>> empByDept =
employees.stream()
.collect(Collectors.groupingBy(e -> e.getDepartment()));
```

Groups employees based on their **department**.

---

# 6. Count Employees by Department

```java
Map<String, Long> empsCountByDep =
employees.stream()
.collect(Collectors.groupingBy(
        e -> e.getDepartment(),
        Collectors.counting()));
```

Example Output

```
{IT=3, HR=2, CENTRAL=3}
```

---

# 7. List Employee Names by Department

```java
Map<Object, List<Object>> empByDept1 =
employees.stream()
.collect(Collectors.groupingBy(
        e -> e.getDepartment(),
        Collectors.mapping(e -> e.getFirstname(), Collectors.toList())
));
```

Example Output

```
IT : [Chauhan, Prasad]
HR : [Pavani, Shanvi]
```

---

# 8. Sum of Salaries by Department (Using Reducing)

```java
Map<String, Optional<Double>> sumOfSalaryByDept =
employees.stream()
.collect(Collectors.groupingBy(
        e -> e.getDepartment(),
        Collectors.mapping(
                e -> e.getSalary(),
                Collectors.reducing((a, b) -> a + b)
        )));
```

---

# 9. Sum of Salaries by Department (Using summingDouble)

```java
Map<String, Double> sumofemployeeDept =
employees.stream()
.collect(Collectors.groupingBy(
        e -> e.getDepartment(),
        Collectors.summingDouble(e -> e.getSalary())
));
```

Example Output

```
{IT=75000.0, HR=50000.0, CENTRAL=90000.0}
```

---

# 10. Salary Statistics by Department

Uses `DoubleSummaryStatistics` to calculate:

* Count
* Sum
* Minimum
* Maximum
* Average

```java
Map<Object, DoubleSummaryStatistics> summary =
employees.stream()
.collect(Collectors.groupingBy(
        e -> e.getDepartment(),
        Collectors.summarizingDouble(e -> e.getSalary())
));
```

Example Output

```
{IT=DoubleSummaryStatistics{count=3, sum=75000, min=20000, average=25000, max=30000}}
```

---

# 11. Filter and Summarize Specific Department

```java
DoubleSummaryStatistics sumar =
employees.stream()
.collect(Collectors.filtering(
        e -> e.getDepartment().equals("CENTRAL"),
        Collectors.summarizingDouble(e -> e.getSalary())
));
```

Calculates salary statistics only for **CENTRAL department**.

---

# 12. Find Employee with Maximum Age

```java
Optional<Employee> eldestemployee =
employees.stream()
.collect(Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge()));
```

Example Output

```
Prasad
```

---

# Technologies Used

* Java 8
* Stream API
* Collectors
* Optional
* DoubleSummaryStatistics

---

# Key Concepts Covered

* Functional Programming in Java
* Lambda Expressions
* Stream Pipelines
* Collectors Utility Methods
* Data Aggregation
