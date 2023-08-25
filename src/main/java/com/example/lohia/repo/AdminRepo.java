package com.example.lohia.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lohia.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	Optional<Admin> findByUsernameAndPassword(String username, String password);
	Admin findByUsername(String username); 
}
