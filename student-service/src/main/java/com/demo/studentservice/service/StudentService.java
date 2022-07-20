package com.demo.studentservice.service;

import com.demo.studentservice.feignclients.SubjectFeignClient;
import com.demo.studentservice.repository.StudentRepository;
import com.demo.studentservice.entity.Student;
import com.demo.studentservice.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectFeignClient subjectFeignClient;


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Map<String, Object> getSubjectsByStudentId(Long studentId){
        Map<String, Object> subjectsById = new HashMap<>();
        Student student = studentRepository.findById(studentId).orElse(null);
        subjectsById.put("Student", student);
        List<Subject> subjects = subjectFeignClient.getSubjects(studentId);
        subjectsById.put("Subjects", subjects);
        return subjectsById;
    }

}
