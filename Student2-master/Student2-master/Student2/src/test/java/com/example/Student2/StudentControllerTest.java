package com.example.Student2;



import com.example.Student2.entity.Student;

import com.example.Student2.repo.StudentRepository;

import com.example.Student2.service.StudentService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 
import java.util.Arrays;

import java.util.Optional;
 
import static org.mockito.Mockito.*;
 
@SpringBootTest

@AutoConfigureMockMvc

public class StudentControllerTest {
 
    @Autowired

    private MockMvc mockMvc;
 
    @MockBean

    private StudentService studentService;
 
    @Test

    public void testGetAllStudents() throws Exception {

        when(studentService.getAllStudents()).thenReturn(Arrays.asList(

                new Student("John Doe", 50000, 20),

                new Student("Jane Smith", 60000, 22)

        ));
 
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"))

                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Jane Smith"));
 
        verify(studentService, times(1)).getAllStudents();

    }
 
    @Test

    public void testGetStudentById() throws Exception {

        long studentId = 1L;

        when(studentService.getStudentById(studentId)).thenReturn(

                Optional.of(new Student("John Doe", 50000, 20))

        );
 
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students/{id}", studentId))

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))

                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(50000))

                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(20));
 
        verify(studentService, times(1)).getStudentById(studentId);

    }
 
    // Additional test cases for addStudent, updateStudent, deleteStudent, etc.

}
