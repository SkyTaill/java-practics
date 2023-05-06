package com.example.hiber;

import com.example.hiber.school.Student;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

@SpringBootApplication
public class DasApplication {
	
	public static void main(String[] args) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

		EntityManagerFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		EntityManager em = factory.createEntityManager();
		Student student=new Student("dц","d");

		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();


		//классический вариант
//	EntityManagerFactory emf= Persistence.createEntityManagerFactory("db");
//	EntityManager em=emf.createEntityManager();


	}

}
