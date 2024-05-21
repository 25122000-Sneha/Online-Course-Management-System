package com.ltim.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ltim.poc.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

    @Query("SELECT E from Enrollment E where E.course.courseCode = :courseCode")
    public List<Enrollment> findByCourseCode(String courseCode);

    @Query("SELECT E from Enrollment E where E.course.courseId = :courseId")
    public List<Enrollment> findByCourseId(Long courseId);

    @Query("SELECT E from Enrollment E where E.student.studentId = :studentId")
    public List<Enrollment> findByStudent(Long studentId);
}
