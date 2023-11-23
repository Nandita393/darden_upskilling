package com.example.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.bean.Student;

@RestController
public class StudentController {
	@GetMapping("/student")
	public Student newStudent() {
		Student student=new Student(1, "sai", "nandu");
		return student;
}
	@GetMapping("/students")
public List<Student> getstudents() {
	List<Student> students=new ArrayList<>();
	students.add(new Student(2,"veera","pinki"));
	students.add(new Student(3,"mani","pavithra"));
	students.add(new Student(4,"krishna","surya"));
	return students;
	
}
	  // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/sai/nandi
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }
 
    // Spring boot REST API with Request Param
    //  http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
}

