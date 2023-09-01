package com.example.lohia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lohia.dto.EmployeeDTO;
import com.example.lohia.entity.Employee;
import com.example.lohia.service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//register Employee
	@PostMapping("/register")
	public ResponseEntity<String> registerEmp(@RequestBody EmployeeDTO employeeDTO){
		String addEmp = employeeService.addEmp(employeeDTO);
		return ResponseEntity.ok(addEmp);
	}
	
	//get all employee
	@GetMapping("/allemployee")
	public List<Employee> getallEmp(){
		return employeeService.getAllEmployee();
		
	}
	
	//get employee by empcode
	@GetMapping("/employeecode/{empcode}")
	public Employee getEmployeeByCode(@PathVariable String empcode) {
		return employeeService.getByEmpCode(empcode);
	}
	
	//update empoyee
	@PostMapping("/updateEmp/{empcode}")
	public String updateEmployee(@PathVariable String empcode, @RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(empcode, employeeDTO);
	}
	
	//delete employee
	@DeleteMapping("/deleletEmp/{empcode}")
	public void deleteEmp(@PathVariable String empcode) {
		employeeService.deleteByEmpCode(empcode);
	}
}
