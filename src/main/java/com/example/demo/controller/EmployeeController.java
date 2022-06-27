package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController // Controller+ResponseBody making this class a RestControllers, we can have
				// methods here which maps to our url
@RequestMapping("/api/Employees") // whenevr there is request with this matching url pattern this class will
									// execute
public class EmployeeController {

	private EmployeeService employeeService; // controller layer depends on service layer

	public EmployeeController(EmployeeService employeeService) { // injecting bean of EmployeeService class
		super();
		this.employeeService = employeeService;
	}

	// build create employee Rest api
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// build get all employee rest api
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// build get employee by empcode
	// http://localhost:8080/api/Employees/2 where 2 is dynamic variable hence we
	// put {}
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empcode) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(empcode), HttpStatus.OK);
	}

	
	  //build update employee Rest API
	  @PutMapping({"id"}) 
	  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee){
	   
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);

		  
	  }
	 
}
