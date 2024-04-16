package com.Insppiron.proto;

import com.Insppiron.proto.Controller.StudentController;
import com.Insppiron.proto.Model.Student;
import com.Insppiron.proto.Service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class Controller_Test {

    @MockBean
    private StudentService studentService;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentController userController;


    @Test
    public void test_saveContact() throws Exception {

        Student mockstudent= Mockito.mock(Student.class);
        System.out.println(mockstudent);
        Student student=new Student(9,"mahesh",21);
        when(studentService.save(student)).thenReturn(student);

        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student) ))
                .andExpect(status().isOk());

    }
    @Test
    public void test_deleteStudent() throws Exception {

        Student student = new Student(123, "ashish", 22);

        mockMvc.perform(delete("/delete")
                .param("id", String.valueOf(student.getStudentId())) // Pass id as request parameter
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student.getStudentId())));
        verify(userController, times(1)).delete(student.getStudentId());


    }
    @Test
    public void test_getStudentByID() throws Exception {

        Student student = new Student(123, "ashish", 22);

        // Mocking the behavior of your service method
//        when(userController.getById(student.getStudentId())).thenReturn(student);

        mockMvc.perform(get("/getById")
                        .param("id", String.valueOf(student.getStudentId())));


                 // Assuming you expect a 200 OK status

        // Verifying that the controller method was called once with the correct id
        verify(userController, times(1)).getById(student.getStudentId());
    }
}
