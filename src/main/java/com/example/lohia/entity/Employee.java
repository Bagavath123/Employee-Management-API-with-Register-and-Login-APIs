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
@Table(name = "empDetails")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String empCode;
	
	private String empName;
	
	private String designation;
	
	private String gender;
	
	private String dob;
	
	private String email;
	
	private String qualification;
	
	private String mobileNo;
	
	private String address;
	
	private String jobLocation;
	
	private String password;
	
	@Column(name = "status_id", columnDefinition = "INT NOT NULL DEFAULT 1")
	private int status;
	
	@CreationTimestamp
	@Column(name = "created_ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp createdTs;

	@Column(name = "created_by", columnDefinition = "INT NOT NULL DEFAULT 1")
	private int createdBy;

	public Employee() {
		
	}

	public Employee(int id, String empCode, String empName, String designation, String gender, String dob, String email,
			String qualification, String mobileNo, String address, String jobLocation, String password, int status,
			Timestamp createdTs, int createdBy) {
		super();
		this.id = id;
		this.empCode = empCode;
		this.empName = empName;
		this.designation = designation;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.qualification = qualification;
		this.mobileNo = mobileNo;
		this.address = address;
		this.jobLocation = jobLocation;
		this.password = password;
		this.status = status;
		this.createdTs = createdTs;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
}
