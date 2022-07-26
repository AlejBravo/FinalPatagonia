package com.demo.subjectservice.controller;

import com.demo.subjectservice.entity.Subject;
import com.demo.subjectservice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> subjects = subjectService.getAll();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Subject>> getById(@PathVariable("id") Long id) {
        Optional<Subject> subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping()
    public ResponseEntity<Subject> save(@RequestBody Subject subject) {
        Subject subjectNew = subjectService.save(subject);
        return ResponseEntity.ok(subjectNew);
    }

    @GetMapping("/bystudent/{studentId}")
    public ResponseEntity<List<Subject>> getByStudentId(@PathVariable("studentId") Long studentId) {
        List<Subject> subjects = subjectService.byStudentId(studentId);
        return ResponseEntity.ok(subjects);
    }

}
