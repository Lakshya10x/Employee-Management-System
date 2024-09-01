package com.company.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.management.entity.Employee;
import com.company.management.service.EmployeeServiceInterface;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee savedEmployee = employeeServiceInterface.addEmp(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> empList = employeeServiceInterface.getAllEmp();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
	{
		Employee emp = employeeServiceInterface.getEmpById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id)
	{
		employeeServiceInterface.deleteEmpById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee)
	{
		Employee updatedEmployee = employeeServiceInterface.addEmp(employee);
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.CREATED);
	}
}
