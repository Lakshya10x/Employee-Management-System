package com.company.management.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.custom.exception.BusinessException;
import com.company.management.custom.exception.EmptyInputException;
import com.company.management.entity.Employee;
import com.company.management.repsoitory.EmpRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee addEmp(Employee employee) {
		if(employee.getEmpName().isEmpty() || employee.getEmpName().length()==0)
			{
				throw new EmptyInputException("601","Input fields are empty !!");
			}
			
			Employee savedEmployee = empRepository.save(employee);
			return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> empList = empRepository.findAll();
	
		if(empList.isEmpty())
		{
			throw new BusinessException("604","Hey, List is empty we have nothing to retrieve");
		}
		return empList;
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
