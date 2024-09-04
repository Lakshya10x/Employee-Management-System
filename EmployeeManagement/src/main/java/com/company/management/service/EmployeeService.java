package com.company.management.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.custom.exception.BusinessException;
import com.company.management.entity.Employee;
import com.company.management.repsoitory.EmpRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee addEmp(Employee employee) {
		/** In BusinessException object it will take 2 things : errorCode & errorMessage
			What should be the errorCode be ?
			Dont put 404,201 etc :- These are the Http Status Code, which are already in use 
			you should not use them as a customized exception code
			Instead, use these :- 601 series.
		**/
		// You should not put "try" for validations because the 601 error message will be overwritten by Something went wrong
		// Use "try" only with the repository calls	
		if(employee.getEmpName().isEmpty() || employee.getEmpName().length()==0)
			{
				throw new BusinessException("601","Please send proper name, its blank");
			}
			try {
			Employee savedEmployee = empRepository.save(employee);
			return savedEmployee;
			
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602","Given Employee is null" + e.getMessage());
		}
		catch (Exception e) {
			throw new BusinessException("603","Something went wrong in service layer while saving the employees" + e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> empList = null;
		// After "try" you should not write anything
		try {
		 empList = empRepository.findAll();
		}
		catch (Exception e) {
			throw new BusinessException("605","Something went wrong in service layer while fetching all employees" + e.getMessage());
		}
		if(empList.isEmpty())
		{
			throw new BusinessException("604","Hey, List is empty we have nothing to retrieve");
		}
		return empList;
			
		} 
	

	@Override
	public Employee getEmpById(Long id) {
		
		try {
			
			Optional<Employee> retrivedEmployee = empRepository.findById(id);
			return retrivedEmployee.get();
			
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606","Given employee id is null, please provide ID to be searched" + e.getMessage());
		}
		catch(NoSuchElementException e) {
			throw new BusinessException("607","Given employee id doesn't exists in DB" + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("608","Something went wrong in service layer while fetching empployee details by ID" + e.getMessage());
		}
	}

	@Override
	public void deleteEmpById(Long id) {
		try {
			empRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("609","Given employee id is null, please provide ID to be deleted" + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("610","Something went wrong in  service layer while deleting employee data" + e.getMessage());
		}
	}
}
