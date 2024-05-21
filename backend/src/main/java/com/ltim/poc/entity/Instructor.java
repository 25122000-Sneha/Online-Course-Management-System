package com.ltim.poc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long instructorId;
    private String instructorName;
    private String emailId;
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    
    public Instructor() {
    }
    public Instructor(long instructorId, String instructorName, String emailId, String specialization, Course course) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.emailId = emailId;
        this.specialization = specialization;
        this.course = course;
    }
    public long getInstructorId() {
        return instructorId;
    }
    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }
    public String getInstructorName() {
        return instructorName;
    }
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    


    
    
}
