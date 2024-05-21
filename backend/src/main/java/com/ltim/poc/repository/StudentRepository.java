package com.ltim.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltim.poc.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
