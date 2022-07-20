package com.demo.studentservice.service;

import com.demo.studentservice.feignclients.SubjectFeignClient;
import com.demo.studentservice.repository.StudentRepository;
import com.demo.studentservice.entity.Student;
import com.demo.studentservice.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        Student studentNew = studentRepository.save(student);
        return studentNew;
    }

}
