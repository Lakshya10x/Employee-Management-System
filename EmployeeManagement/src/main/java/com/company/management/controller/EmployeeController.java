package com.company.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.management.custom.exception.BusinessException;
import com.company.management.custom.exception.ControllerException;
import com.company.management.entity.Employee;
import com.company.management.service.EmployeeServiceInterface;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		try {
			Employee savedEmployee = employeeServiceInterface.addEmp(employee);
			return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);			
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getDescription());
			// More specifically, you need to mention HttpStatus according to the errorCode, like - NOT FOUND, FORBIDDEN etc 
			// Here we are simply generalized
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> empList = employeeServiceInterface.getAllEmp();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id)
	{
		try {
			Employee emp = employeeServiceInterface.getEmpById(id);
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
			
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getDescription());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException("612","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id)
	{
		try {
			employeeServiceInterface.deleteEmpById(id);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getDescription());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException("613","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<?> updateEmployeeById(@RequestBody Employee employee)
	{
		try {
			Employee updatedEmployee = employeeServiceInterface.addEmp(employee);
			return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.CREATED);
			
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getDescription());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException("614","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
}
