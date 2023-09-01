package com.example.lohia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lohia.dto.EmployeeDTO;
import com.example.lohia.entity.Employee;
import com.example.lohia.exception.EmpNotFoundException;
import com.example.lohia.repo.EmployeeRepo;
import com.example.lohia.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addEmp(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmpCode(employeeDTO.getEmpCode());
		employee.setEmpName(employeeDTO.getEmpName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setGender(employeeDTO.getGender());
		employee.setDob(employeeDTO.getDob());
		employee.setDesignation(employeeDTO.getDesignation());
		employee.setAddress(employeeDTO.getAddress());
		employee.setJobLocation(employeeDTO.getJobLocation());
		employee.setMobileNo(employeeDTO.getMobileNo());
		employee.setQualification(employeeDTO.getQualification());
		employee.setCreatedBy(1);
		
		String encodedPassword = passwordEncoder.encode(employeeDTO.getPassword());
		employee.setPassword(encodedPassword);
		
		employeeRepo.save(employee);
		
		return "Employee register sucessfully";
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee getByEmpCode(String empcode) {
		// TODO Auto-generated method stub
		return employeeRepo.findByEmpCode(empcode);
	}

	@Override
	public String updateEmployee(String empcode, EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Employee exisitingEmp = employeeRepo.findByEmpCode(empcode);
		
		if(exisitingEmp != null) {
			exisitingEmp.setEmpName(employeeDTO.getEmpName());
			//upadate other fields
			exisitingEmp.setMobileNo(employeeDTO.getMobileNo());
			
			employeeRepo.save(exisitingEmp);
			return "Employee Updated sucessfully";
		}
		return "Employee not found";
		
	}

	@Override
	public void deleteByEmpCode(String empcode) {
		// TODO Auto-generated method stub
		Employee deleteEmp = employeeRepo.findByEmpCode(empcode);
		
		if(deleteEmp != null) {
			employeeRepo.delete(deleteEmp);
			 
		}else {
			throw new EmpNotFoundException("Employee with code" +empcode+"not found");
		}
		
	}
}
