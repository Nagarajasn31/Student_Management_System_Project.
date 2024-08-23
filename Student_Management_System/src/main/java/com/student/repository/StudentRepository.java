package com.student.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.student.domain.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentByPhoneNumber(Long phoneNumber);
    Optional<Student> findStudentByBranch(String branch);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(Long phoneNumber);

}
