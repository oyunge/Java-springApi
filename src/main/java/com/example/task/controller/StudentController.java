package com.example.task.controller;

import com.example.task.model.Student;
import com.example.task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public Student addStudent( @RequestBody Student student1 ){
       return studentRepository.save(student1);
    }

    @GetMapping
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Integer studentId){
        studentRepository.deleteById(studentId);
        return "entry Deleted";
    }

}
