package com.example.JPADemo.subject;

import com.example.JPADemo.student.Student;
import com.example.JPADemo.student.StudentRepository;
import com.example.JPADemo.teacher.Teacher;
import com.example.JPADemo.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;



    @GetMapping
    List<Subject> getSubjects(){
        return  subjectRepository.findAll();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }



}
