package com.student.mapper;

import com.student.domain.Student;
import com.student.dto.StudentDTO;

public class StudentMapper {

	public static Student mapToStudent(StudentDTO studentDTO) {
		if(studentDTO==null) {
			return null;
		}
		
		Student student = new Student();
		student.setId(studentDTO.getId());
		student.setUsn(studentDTO.getUsn());
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPhoneNumber(studentDTO.getPhoneNumber());
		student.setCollegeName(studentDTO.getCollegeName());
		student.setBranch(studentDTO.getBranch());
		student.setAddress(studentDTO.getAddress());
		student.setCgpa(studentDTO.getCgpa());
		student.setEnrollmentDate(studentDTO.getEnrollmentDate());
		student.setCollegeLogo(studentDTO.getCollegeLogo());
		
		return student;		
	}
	
	public static StudentDTO mapStudentDTO(Student student) {
		if(student==null) {
			return null;
		}
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setUsn(student.getUsn());
		studentDTO.setName(student.getName());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setPhoneNumber(student.getPhoneNumber());
		studentDTO.setCollegeName(student.getCollegeName());
		studentDTO.setBranch(student.getBranch());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setCgpa(student.getCgpa());
		studentDTO.setEnrollmentDate(student.getEnrollmentDate());
		studentDTO.setCollegeLogo(student.getCollegeLogo());
	
		return studentDTO;
	}
}
