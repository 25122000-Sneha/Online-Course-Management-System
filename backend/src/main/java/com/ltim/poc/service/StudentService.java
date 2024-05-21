package com.ltim.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.poc.entity.Student;
import com.ltim.poc.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    


    
}
