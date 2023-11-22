package com.example.Student2.controller;
import com.example.Student2.entity.Student;
import com.example.Student2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api/students")
public class StudentController {
 
    @Autowired
    private StudentService studentService;
 
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Student is added: " + student.getName());
    }
 
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok("Student is updated");
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student is deleted");
    }
}

