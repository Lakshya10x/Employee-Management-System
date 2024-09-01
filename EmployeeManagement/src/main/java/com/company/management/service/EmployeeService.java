package com.company.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.entity.Employee;
import com.company.management.repsoitory.EmpRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee addEmp(Employee employee) {
		Employee savedEmployee = empRepository.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepository.findAll();
	}

	@Override
	public Employee getEmpById(Long id) {
		Optional<Employee> retrivedEmployee = empRepository.findById(id);
		return retrivedEmployee.get();
	}

	@Override
	public void deleteEmpById(Long id) {
		empRepository.deleteById(id);
	}
	
	
}
