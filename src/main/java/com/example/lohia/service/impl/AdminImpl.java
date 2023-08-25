package com.example.lohia.service.impl;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lohia.dto.AdminDTO;
import com.example.lohia.dto.LoginDto;
import com.example.lohia.entity.Admin;
import com.example.lohia.payloadresponse.LoginMessage;
import com.example.lohia.repo.AdminRepo;
import com.example.lohia.service.AdminService;

@Service
public class AdminImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addAdmin(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setUsername(adminDTO.getUsername());
		admin.setEmail(adminDTO.getEmail());
		admin.setStatus(1);
		String encodedPassword = passwordEncoder.encode(adminDTO.getPassword());
		admin.setPassword(encodedPassword); // Set the encoded password
		//admin.setPassword(adminDTO.getPassword());
		//this.passwordEncoder.encode(adminDTO.getPassword());
		adminRepo.save(admin);
		return "User Register Sucessfully";
	}

	@Override
	public LoginMessage loginAdmin(LoginDto loginDto) {
		// TODO Auto-generated method stub
		String msg ="";
		
		Admin userLogin = adminRepo.findByUsername(loginDto.getUsername());
		
		if(userLogin != null) {
			String enteredPassword = loginDto.getPassword();
			String encodedPassword = userLogin.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(enteredPassword, encodedPassword);
			
			if(isPwdRight) {
				Optional<Admin> admin = adminRepo.findByUsernameAndPassword(loginDto.getUsername(), encodedPassword);
				
               if (admin.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Username does not exits", false);
        }
    }
}