package com.ltim.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.poc.entity.Enrollment;
import com.ltim.poc.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment enrollStudent(Enrollment enrollment)
    {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollmentsByCourseCode(String courseCode)
    {
        return enrollmentRepository.findByCourseCode(courseCode);
    }

    public List<Enrollment> getAllEnrollmentsByStudentId(Long studentId)
    {
        return enrollmentRepository.findByStudent(studentId);
    }

    public Integer noOfEnrollmentsByCourseId(Long courseId){
        List<Enrollment> list = enrollmentRepository.findByCourseId(courseId);
        return list.size();
    }
    
}
