package com.ltim.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.ltim.poc.entity.Instructor;
import com.ltim.poc.service.InstructorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/add-instructor")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor)
    {
        return new ResponseEntity<>(instructorService.addInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long instructorId) {
        return new ResponseEntity<>(instructorService.getInstructorById(instructorId), HttpStatus.OK);
    }
    
    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors()
    {
        return new ResponseEntity<>(instructorService.getAllInstructors(), HttpStatus.OK);
    }

    @PutMapping("/update-instructor/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor)
    {
        return new ResponseEntity<>(instructorService.updateInstructor(id, instructor), HttpStatus.OK);
    }

    @DeleteMapping("/delete-instructor/{insId}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long insId)
    {
        Instructor ins = instructorService.deleteInstructor(insId);
        if(ins != null)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/instructors/course/{courseId}")
    public ResponseEntity<List<Instructor>> getAllInstructorsByCourse(@PathVariable Long courseId)
    {
        return new ResponseEntity<>(instructorService.getAllInstructorsByCourse(courseId), HttpStatus.OK);
    }


    
    
}
