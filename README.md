# Java 8 Interview Coding Questions

This repository contains a collection of Java 8 coding questions and their solutions, aimed at preparing for Java developer interviews. Topics covered include:

- Streams API
- Lambdas
- Functional Interfaces
- Default and Static Methods in Interfaces
- Optional Class
- Method References

## Table of Contents

| No. | Questions                                                                                                                                                         |
| --- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | [Find list of employees whose name starts with alphabet A](#find-list-of-employees-whose-name-starts-with-alphabet-A)                                         |
| 2   | [Group The employees By Department Names](#group-the-employees-by-department-names)                                                         |
| 3   | [Find the total count of employees using stream](#find-the-total-count-of-employees-using-stream)                                                         |
| 4   | [Find the max age of employees](#find-the-max-age-of-employees)                                                         |
| 5   | [Find all department names](#find-all-department-names)                                                         |
| 6   | [Find the count of employee in each department](#find-the-count-of-employee-in-each-department)                                                         |
| 7   | [Find the list of employees whose age is less than 30](#find-the-list-of-employees-whose-age-is-less-than-30)                                                         |
| 8   | [Find the list of employees whose age is in between 26 and 31](#find-the-list-of-employees-whose-age-is-in-between-26-and-31)                                                         |
| 9   | [Find the average age of male and female employee](#find-the-average-age-of-male-and-female-employee)|
| 10   | [Find the department who is having maximum number of employee](#find-the-department-who-is-having-maximum-number-of-employee)|
| 11   | [Find the Employee who stays in Delhi and sort them by their names](#find-the-employee-who-stays-in-delhi-and-sort-them-by-their-names)|
| 12   | [Find the average salary in all departments](#find-the-average-salary-in-all-departments)|
| 13   | [Find the highest salary in each department](#find-the-highest-salary-in-each-department)|
| 14   | [Find the list of employee and sort them by their salary](#find-the-list-of-employee-and-sort-them-by-their-salary)|
| 15   | [Find the employee who has second highest salary](#find-the-employee-who-has-second-highest-salary)|

1. ### Find list of employees whose name starts with alphabet A


      ```java
      List<Employee> aEmp = empList.stream()
			.filter(emp -> emp.getName().startsWith("A"))
						.collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**
