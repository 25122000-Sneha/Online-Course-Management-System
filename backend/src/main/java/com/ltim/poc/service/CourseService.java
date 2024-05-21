package com.ltim.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.poc.entity.Course;
import com.ltim.poc.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course)
    {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long courseId)
    {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if(optionalCourse.isPresent())
        {
            return optionalCourse.get();
        }
        else 
        {
            return null;
        }
    }


    public List<Course> getAllCourses()
    {
        return courseRepository.findAll();
    }

    public Course deleteCourse(Long courseId)
    {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if(optionalCourse.isPresent())
        {
            courseRepository.deleteById(courseId);
            return optionalCourse.get();
        }
        else 
        {
            return null;
        }
    }


    public Course updateCourse(Long courseId, Course updatedCourse)
    {
        Optional<Course> opc = courseRepository.findById(courseId);
        if(opc.isPresent())
        {
            Course course = opc.get();
            course.setCourseCode(updatedCourse.getCourseCode());
            course.setCourseName(updatedCourse.getCourseName());
            course.setDescription(updatedCourse.getDescription());
            course.setCredits(updatedCourse.getCredits());
            return courseRepository.save(course);
        }
        else 
        {
            return null;
        }
    }
    

    
    
}
