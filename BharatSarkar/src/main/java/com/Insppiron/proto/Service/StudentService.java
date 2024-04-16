package com.Insppiron.proto.Service;

import com.Insppiron.proto.Model.Student;
import com.Insppiron.proto.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;
    public Student save(Student student){

       return studentRepository.save(student);
    }
    public List<Student> getAllStudent(){
        List<Student> all = studentRepository.findAll();
        return all;
    }
    public Student getStudentById(int id){
        Optional<Student> byId = studentRepository.findById(id);
        Student student = byId.get();
        return student;
    }
    public Student deleteStudent(int id){

        Optional<Student> byId = studentRepository.findById(id);
        if(byId.isPresent()){
            studentRepository.delete(getStudentById(id));
            return byId.get();
        }
        else return null;


    }


}
