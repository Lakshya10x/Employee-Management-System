package com.company.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name="empl_table")
@ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String empName;
	
	//JPA or Hibernate requires a no-arguments contructor to instantiate an entity.
	//Because these frameworks use reflection to create instances of entity classes when fetching data from the database
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	public Employee(Long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
	
	
	
	
}
