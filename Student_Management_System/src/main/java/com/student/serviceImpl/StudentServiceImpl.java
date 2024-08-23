package com.student.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDAO;
import com.student.domain.Student;
import com.student.dto.StudentDTO;
import com.student.exception.ResourceNotFoundException;
import com.student.mapper.StudentMapper;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        // Check if the email or phone number already exists
        if(studentDAO.existsByEmail(studentDTO.getEmail())) {
            throw new RuntimeException("Email already exists..!!");
        }

        if(studentDAO.existsByPhoneNumber(studentDTO.getPhoneNumber())) {
            throw new RuntimeException("Phone Number already exists..!!");
        }

        // Map DTO to entity
        Student student = StudentMapper.mapToStudent(studentDTO);

        // Generate USN and set enrollment date before saving
        student.generateUSN(); // Ensure this method sets the USN
        student.setEnrollmentDate(LocalDate.now()); // Set the enrollment date

        // Save the student entity
        Student savedStudent = studentDAO.saveStudent(student);

        // Map the saved entity back to DTO and return
        return StudentMapper.mapStudentDTO(savedStudent);
    }


    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        return students.stream()
                .map(StudentMapper::mapStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentDAO.getStudentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
        return StudentMapper.mapStudentDTO(student);
    }
    @Override
	public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
		Student student = studentDAO.getStudentById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", id));
		if(student.getName()!=null) {
			student.setName(studentDTO.getName());
		}
		if(student.getEmail()!=null) {
			student.setEmail(studentDTO.getEmail());

		}
		if(student.getPhoneNumber()!=null) {
			student.setPhoneNumber(studentDTO.getPhoneNumber());
		}
		if(student.getCollegeName()!=null) {
			student.setCollegeName(studentDTO.getCollegeName());
		}
		if(student.getBranch()!=null) {
			student.setBranch(studentDTO.getBranch());
		}
		if(student.getAddress()!=null) {
			student.setAddress(studentDTO.getAddress());
		}

		if(student.getCgpa()!=null) {
			student.setCgpa(studentDTO.getCgpa());
		}

		if(student.getCollegeLogo()!=null) {
			student.setCollegeLogo(studentDTO.getCollegeLogo());
		}

		Student updateStudent=studentDAO.updateStudent(id, student);
		return StudentMapper.mapStudentDTO(updateStudent);

	}

    @Override
    public void deleteStudent(Long id) {
        studentDAO.getStudentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
        studentDAO.deleteStudent(id);
        System.out.println("Student deleted successfully");
    }

    @Override
    public Optional<StudentDTO> getStudentByEmail(String email) {
        return studentDAO.findStudentByEmail(email)
                .map(StudentMapper::mapStudentDTO);
    }

    @Override
    public Optional<StudentDTO> getStudentByPhoneNumber(Long phoneNumber) {
        return studentDAO.findStudentByPhoneNumber(phoneNumber)
                .map(StudentMapper::mapStudentDTO);
    }

    @Override
    public Optional<StudentDTO> getStudentByBranch(String branch) {
        return studentDAO.findStudentByBranch(branch)
                .map(StudentMapper::mapStudentDTO);
    }

    @Override
    public boolean existsByEmail(String email) {
        return studentDAO.existsByEmail(email);
    }

    @Override
    public boolean existsByPhoneNumber(Long phoneNumber) {
        return studentDAO.existsByPhoneNumber(phoneNumber);
    }

}
