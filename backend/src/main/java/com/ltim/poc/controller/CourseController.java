package com.ltim.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltim.poc.entity.Course;
import com.ltim.poc.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add-course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course)
    {
        Course createdCourse = courseService.addCourse(course);
        if(createdCourse != null){
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId)
    {
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses()
    {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id)
    {
        Course deletedCourse = courseService.deleteCourse(id);
        if(deletedCourse!=null)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update-course/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Long id, @RequestBody Course course)
    {
        return new ResponseEntity<>(courseService.updateCourse(id, course), HttpStatus.OK);
    }
    
    

}
