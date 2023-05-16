package com.example.hiber.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JPAEx {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void getReqwest(){
        Student student=new Student("dфывz","d");
        em.persist(student);
    }
    public EntityManager getEm() {
        return em;
    }
}
