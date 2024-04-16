package com.Insppiron.proto;

import com.Insppiron.proto.Controller.StudentController;
import com.Insppiron.proto.Model.Student;
import com.Insppiron.proto.Repository.StudentRepository;
import com.Insppiron.proto.Service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeopleTest {

    @Mock
    private StudentService studentService;
    private StudentRepository studentRepository;


    @InjectMocks
    private StudentController userController;
    private MockMvc mockMvc=MockMvcBuilders.standaloneSetup(userController).build();;

    @Test
    public void getStudentTest() {
        when(studentRepository.findAll()).thenReturn(Stream.of(new Student(1, "ashish", 28), new Student(2, "mahesh", 29), new Student(3, "smita", 25), new Student(4, "raj", 39)).collect(Collectors.toList()));
        assertEquals(4, studentService.getAllStudent().size());
    }
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }

    @Test
    public void saveStudent() {
        Student student = new Student(8, "ram", 29);
        when(studentRepository.save(student)).thenReturn(student);
        assertEquals(student, studentService.save(student));
    }

    @Test
    public void deleteStudent() {
        Student student= new Student(8,"ram",29);
        studentService.deleteStudent(student.getStudentId());
        verify(studentRepository,times(1)).deleteById(student.getStudentId());

    }
    @Test
    public void testCreateUser() throws Exception {

        // Creating a new user object
        Student student = new Student(2, "Alice",28);

        // Performing POST request to "/api/users"
        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(student)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        // Verifying that userService.createUser() method was called with the new user object
        Mockito.verify(studentService, Mockito.times(1)).save(student);
    }
    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
