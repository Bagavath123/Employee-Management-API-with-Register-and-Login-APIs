package com.example.lohia.service;

import java.util.List;

import com.example.lohia.dto.EmployeeDTO;
import com.example.lohia.entity.Employee;


public interface EmployeeService {

	String addEmp(EmployeeDTO employeeDTO);
	
	List<Employee>getAllEmployee();
	
	Employee getByEmpCode(String empcode);
	
	String updateEmployee(String empcode, EmployeeDTO employeeDTO);
	
	void deleteByEmpCode(String empcode);
}
