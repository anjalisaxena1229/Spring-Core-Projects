package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	Employee updateEmployee(Employee employee , int id);
			
}
