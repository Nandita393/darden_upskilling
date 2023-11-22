package com.example.Student2.service;
import com.example.Student2.entity.Student;

import java.util.List;
import java.util.Optional;
 
public interface StudentService {
 
    void addStudent(Student student);
 
    List<Student> getAllStudents();
 
    Optional<Student> getStudentById(Long id);
 
    void updateStudent(Long id, Student updatedStudent);
 
    void deleteStudent(Long id);
}