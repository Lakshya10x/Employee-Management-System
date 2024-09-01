package com.company.management.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Long>{

}
