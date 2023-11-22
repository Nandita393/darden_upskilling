package com.example.Student2;

import com.example.Student2.entity.Student;
import com.example.Student2.repo.StudentRepository;
import com.example.Student2.service.StudentService;
import com.example.Student2.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class Student2ApplicationTests {
        @MockBean
		private StudentRepository studentRepo;
	    @Autowired
		private StudentService studentService;


		@Test
		public void addStudentTest(){
		Student student = new Student("Maha", 22, 30000);
		studentService.addStudent(student);
		verify(studentRepo,times(1)).save(student);
     }


}
