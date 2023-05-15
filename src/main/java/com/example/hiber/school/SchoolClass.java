package com.example.hiber.school;


import org.springframework.stereotype.Component;

@Component
public class SchoolClass {
    private int id;
    private String name;
    Student student;

    public SchoolClass(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
