package com.student.dao;

import java.util.List;
import java.util.Optional;

import com.student.domain.Student;

public interface StudentDAO {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);

    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentByPhoneNumber(Long phoneNumber);
    Optional<Student> findStudentByBranch(String branch);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(Long phoneNumber);
}
