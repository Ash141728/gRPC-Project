package com.Insppiron.proto.Controller;

import com.Insppiron.proto.Model.Student;
import com.Insppiron.proto.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController

public class StudentController {
    StudentController(){
        System.out.println("hi");
    }

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Student student){

      return new  ResponseEntity(HttpStatus.OK);

    }
    @GetMapping("/getById")
    public Student getById(@RequestParam int id){
return studentService.getStudentById(id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam int id){
         studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/update")
    public void update(){

    }
    @GetMapping("/getAll")
    public void getAll(){

    }
}
