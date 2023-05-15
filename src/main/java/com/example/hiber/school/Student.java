package com.example.hiber.school;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@CheckPostProcessor
public class Student implements StudentTest {
    @CheckPostProcessorName
    private String name="dsa";

    private String surname;

@PostConstruct
  private void init(){
      this.surname="hellow";
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

                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
