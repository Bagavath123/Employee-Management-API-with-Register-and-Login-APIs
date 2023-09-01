package com.example.lohia.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lohia.entity.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmpCodeAndEmpName(String empCode, String empName);
	
	Employee findByEmpCode(String empCode);
}
