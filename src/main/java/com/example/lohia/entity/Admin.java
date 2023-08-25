package com.example.lohia.entity;

import java.sql.Timestamp;


import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userLogin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	@Column(name = "status_id", columnDefinition = "INT NOT NULL DEFAULT 1")
	private int status;
	
	@CreationTimestamp
	@Column(name = "created_ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp createdTs;

	public Admin() {
		
	}

	public Admin(int id, String username, String email, String password, int status, Timestamp createdTs) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.createdTs = createdTs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}
	
	

}
