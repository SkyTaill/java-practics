package com.example.hiber.school;

import javax.persistence.*;

@Entity
@Table(name="STUDENT1")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;


    public Student( String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
