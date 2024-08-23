package com.student.dto;

import java.time.LocalDate;

public class StudentDTO {


	private Long id;

	private String usn;
	private String name;
	private String email;
	private Long phoneNumber;
	private String collegeName;
	private String branch;
	private String address;
	private Double cgpa;
	private LocalDate enrollmentDate;
	private String collegeLogo;
	public StudentDTO() {
		super();
	}
	public StudentDTO(Long id, String usn, String name, String email, Long phoneNumber, String collegeName,
			String branch, String address, Double cgpa, LocalDate enrollmentDate, String collegeLogo) {
		super();
		this.id = id;
		this.usn = usn;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.collegeName = collegeName;
		this.branch = branch;
		this.address = address;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.collegeLogo = collegeLogo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public String getCollegeLogo() {
		return collegeLogo;
	}
	public void setCollegeLogo(String collegeLogo) {
		this.collegeLogo = collegeLogo;
	}


}
