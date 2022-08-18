package com.example.JPADemo.subject;

import com.example.JPADemo.student.Student;
import com.example.JPADemo.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    @ManyToMany
    @JoinTable(
            name = "student_enrolled",// Table name
            joinColumns = @JoinColumn(name = "subject_id"),// subject side
            inverseJoinColumns = @JoinColumn(name = "student_id")// student side

    )
    private Set<Student> enrolledStudents = new HashSet<>();



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
