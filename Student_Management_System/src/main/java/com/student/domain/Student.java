package com.student.domain;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private static final AtomicInteger counter = new AtomicInteger(1);

    public void generateUSN() {
        if (this.usn == null || this.usn.isEmpty()) {
            String collegeCode = "1EW"; // Fixed college code
            String year = String.format("%02d", LocalDate.now().getYear() % 100); // Last two digits of current year
            String branchCode = this.branch != null ? this.branch.toUpperCase() : "CS"; // Branch code (default to "CS" if null)
            String uniqueNumber = String.format("%03d", counter.getAndIncrement()); // Unique number with leading zeros

            this.usn = String.format("%s%s%s%s", collegeCode, year, branchCode, uniqueNumber);
        }
    }

    // Constructors, getters, setters

    public Student() {
        super();
    }

    public Student(Long id, String usn, String name, String email, Long phoneNumber, String collegeName, String branch,
                   String address, Double cgpa, LocalDate enrollmentDate, String collegeLogo) {
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

	public static AtomicInteger getCounter() {
		return counter;
	}


}
