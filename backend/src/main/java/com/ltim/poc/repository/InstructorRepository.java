package com.ltim.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ltim.poc.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
    @Query("SELECT i from Instructor i WHERE i.course.courseId = :courseId")
    List<Instructor> getAllInstructorsByCourse(@Param("courseId") Long courseId);
}
