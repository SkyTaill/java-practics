package com.example.hiber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class DasApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DasApplication.class, args);
	}

}
