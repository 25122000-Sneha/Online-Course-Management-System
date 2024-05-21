package com.ltim.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltim.poc.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
    
}
