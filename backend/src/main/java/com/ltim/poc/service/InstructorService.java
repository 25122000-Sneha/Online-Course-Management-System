package com.ltim.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.poc.entity.Instructor;
import com.ltim.poc.repository.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor addInstructor(Instructor instructor)
    {
        return instructorRepository.save(instructor);
    }
    

    public Instructor getInstructorById(Long instructorId)
    {
        Optional<Instructor> optionalIns = instructorRepository.findById(instructorId);
        if(optionalIns.isPresent())
        {
            return optionalIns.get();
        }
        else 
        {
            return null;
        }
    }

    public List<Instructor> getAllInstructors()
    {
        return instructorRepository.findAll();
    }

    public Instructor updateInstructor(Long instructorId, Instructor updatedInstructor)
    {
        Optional<Instructor> optionalIns = instructorRepository.findById(instructorId);
        if(optionalIns.isPresent())
        {
            Instructor ins = optionalIns.get();
            ins.setInstructorName(updatedInstructor.getInstructorName());
            ins.setEmailId(updatedInstructor.getEmailId());
            ins.setSpecialization(updatedInstructor.getSpecialization());
            ins.setCourse(updatedInstructor.getCourse());
            return instructorRepository.save(ins);
        }
        else 
        {
            return null;
        }
    }

    public Instructor deleteInstructor(Long instructorId)
    {
        Optional<Instructor> optionalIns = instructorRepository.findById(instructorId);
        if(optionalIns.isPresent())
        {
            instructorRepository.deleteById(instructorId);
            return optionalIns.get();
        }
        else 
        {
            return null;
        }
    }


    public List<Instructor> getAllInstructorsByCourse(Long courseId)
    {
        return instructorRepository.getAllInstructorsByCourse(courseId);
    }
}
