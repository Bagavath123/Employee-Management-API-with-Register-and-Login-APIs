package com.example.lohia.service;

import com.example.lohia.dto.AdminDTO;
import com.example.lohia.dto.LoginDto;
import com.example.lohia.payloadresponse.LoginMessage;

public interface AdminService {

	String addAdmin(AdminDTO adminDTO);
	 
	LoginMessage loginAdmin(LoginDto loginDto);
}
