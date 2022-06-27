package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmpRepository employeeRepository; //we have to inject obj/bean to this ref hence we will use Constr DI
	
	//@Autowired is not required as whenver spring sees Service class with one const only then dependency inject automatically
	public EmployeeServiceImpl(EmpRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee=employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException();
		} 
			 
	}


	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmailId(employee.getEmailId());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	
	

}
