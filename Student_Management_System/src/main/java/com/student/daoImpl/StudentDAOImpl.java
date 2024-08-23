package com.student.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.dao.StudentDAO;
import com.student.domain.Student;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.StudentRepository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        throw new ResourceNotFoundException("Student", "Id", id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    @Override
    public Optional<Student> findStudentByPhoneNumber(Long phoneNumber) {
        return studentRepository.findStudentByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Student> findStudentByBranch(String branch) {
        return studentRepository.findStudentByBranch(branch);
    }

    @Override
    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhoneNumber(Long phoneNumber) {
        return studentRepository.existsByPhoneNumber(phoneNumber);
    }
}
