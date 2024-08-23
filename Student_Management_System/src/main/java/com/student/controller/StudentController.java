package com.student.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDTO;
import com.student.exception.ResourceNotFoundException;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createStudent(@RequestBody StudentDTO studentDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            StudentDTO savedStudent = studentService.saveStudent(studentDTO);
            response.put("data", savedStudent);
            response.put("message", "Student saved successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("error", "Failed to create student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllStudents() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<StudentDTO> students = studentService.getAllStudents();
            response.put("data", students);
            response.put("message", "Students retrieved successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to retrieve students: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getById/{id}")
    public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            StudentDTO student = studentService.getStudentById(id);
            response.put("data", student);
            response.put("message", "Student retrieved successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Student not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to retrieve student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<Map<String, Object>> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
            response.put("data", updatedStudent);
            response.put("message", "Student updated successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Student not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to update student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteById/{id}")
    public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            studentService.deleteStudent(id);
            response.put("message", "Student deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Student not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to delete student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getStudentByEmail/{email}")
    public ResponseEntity<Map<String, Object>> getStudentByEmail(@PathVariable("email") String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<StudentDTO> student = studentService.getStudentByEmail(email);
            if (student.isPresent()) {
                response.put("data", student.get());
                response.put("message", "Student retrieved by email");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("error", "Student not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("error", "Failed to retrieve student by email: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getStudentByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Map<String, Object>> getStudentByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<StudentDTO> student = studentService.getStudentByPhoneNumber(phoneNumber);
            if (student.isPresent()) {
                response.put("data", student.get());
                response.put("message", "Student retrieved by phone number");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("error", "Student not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("error", "Failed to retrieve student by phone number: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getStudentByBranch/{branch}")
    public ResponseEntity<Map<String, Object>> getStudentByBranch(@PathVariable("branch") String branch) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<StudentDTO> student = studentService.getStudentByBranch(branch);
            if (student.isPresent()) {
                response.put("data", student.get());
                response.put("message", "Student retrieved by branch");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("error", "Student not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("error", "Failed to retrieve student by branch: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/existsByEmail/{email}")
    public ResponseEntity<Map<String, Object>> studentExistsByEmail(@PathVariable("email") String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean exists = studentService.existsByEmail(email);
            response.put("data", exists);
            response.put("message", "Student existence status by email retrieved");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to check student existence status by email: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/existsByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Map<String, Object>> studentExistsByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean exists = studentService.existsByPhoneNumber(phoneNumber);
            response.put("data", exists);
            response.put("message", "Student existence status by phone number retrieved");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to check student existence status by phone number: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
