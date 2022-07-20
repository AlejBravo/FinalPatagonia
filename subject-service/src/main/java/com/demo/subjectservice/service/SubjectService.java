package com.demo.subjectservice.service;

import com.demo.subjectservice.entity.Subject;
import com.demo.subjectservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

//    public Subject getSubjectById(Long id) {
//        return subjectRepository.findById(id);
//    }

    public Subject save(Subject subject) {
        Subject subjectNew = subjectRepository.save(subject);
        return subjectNew;
    }

    public List<Subject> byStudentId(Long studentId) {
        return subjectRepository.findByStudentId(studentId);
    }
}
