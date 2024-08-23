package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.dto.StudentDTO;

public interface StudentService {

    StudentDTO saveStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);

    Optional<StudentDTO> getStudentByEmail(String email);
    Optional<StudentDTO> getStudentByPhoneNumber(Long phoneNumber);
    Optional<StudentDTO> getStudentByBranch(String branch);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(Long phoneNumber);
}
