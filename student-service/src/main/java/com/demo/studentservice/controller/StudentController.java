package com.demo.studentservice.controller;

import com.demo.studentservice.entity.Student;

import com.demo.studentservice.model.Subject;
import com.demo.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/subjects/{studentId}")
    public ResponseEntity<Map<String, Object>> getSubjectsByStudent(@PathVariable("studentId") Long studentId){
        return ResponseEntity.ok(studentService.getSubjectsByStudentId(studentId));
    }


}
