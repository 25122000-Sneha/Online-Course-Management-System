package com.ltim.poc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltim.poc.entity.Enrollment;
import com.ltim.poc.service.EnrollmentService;


@RestController
public class EnrollmentController {

    @Autowired
    public EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody Enrollment enrollment)
    {
        return new ResponseEntity<>(enrollmentService.enrollStudent(enrollment), HttpStatus.CREATED);
    }

    @GetMapping("/enrollments/{courseCode}")
    public ResponseEntity<List<Enrollment>> getAllEnrollmentsByCourseCode(@PathVariable String courseCode)
    {
        
        return new ResponseEntity<>(enrollmentService.getAllEnrollmentsByCourseCode(courseCode), HttpStatus.OK);
    }

    

    @GetMapping("/enrollments/student/{id}")
    public ResponseEntity<List<Enrollment>> getAllEnrollmentsByStudentId(@PathVariable Long id)
    {
        return new ResponseEntity<>(enrollmentService.getAllEnrollmentsByStudentId(id), HttpStatus.OK);
    }

    @GetMapping("/no-of-enrollments/{id}")
    public ResponseEntity<Integer> noOfEnrollmentsByCourseId(@PathVariable Long id)
    {
        return new ResponseEntity<>(enrollmentService.noOfEnrollmentsByCourseId(id), HttpStatus.OK);
    }
    
}
