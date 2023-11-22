package com.example.Student2.service;
import com.example.Student2.entity.Student;
import com.example.Student2.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class StudentServiceImpl implements StudentService {
 
    @Autowired
    private StudentRepository studentRepository;
 
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
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
    public void updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        existingStudent.ifPresent(student -> {
            student.setName(updatedStudent.getName());
            student.setSalary(updatedStudent.getSalary());
            student.setAge(updatedStudent.getAge());
            studentRepository.save(student);
        });
    }
 
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}