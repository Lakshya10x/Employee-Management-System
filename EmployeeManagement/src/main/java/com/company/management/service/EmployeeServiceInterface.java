package com.company.management.service;

import java.util.List;

import com.company.management.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmp(Employee employee);

	public List<Employee> getAllEmp();

	public Employee getEmpById(Long id);

	public void deleteEmpById(Long id);

}
