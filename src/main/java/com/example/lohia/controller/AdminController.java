package com.example.lohia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lohia.dto.AdminDTO;
import com.example.lohia.dto.LoginDto;
import com.example.lohia.payloadresponse.LoginMessage;
import com.example.lohia.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("api/lohia")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody AdminDTO adminDTO){
		String saveAdmin = adminService.addAdmin(adminDTO);
		return ResponseEntity.ok(saveAdmin);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
		LoginMessage loginMessage = adminService.loginAdmin(loginDto);
		return ResponseEntity.ok(loginMessage);
	}
}
