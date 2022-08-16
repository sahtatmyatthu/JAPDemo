package com.example.JPADemo.teacher;

import com.example.JPADemo.subject.Subject;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
