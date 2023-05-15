package com.example.hiber;

import com.example.hiber.school.SchoolClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class DasApplication {

	public static void main(String[] args)  {
	//	SpringApplication.run(DasApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(DasApplication.class, args);

		SchoolClass dependencyOwner = ctx.getBean(SchoolClass.class);
		System.out.println(dependencyOwner.getStudent().getName());
	}

}
