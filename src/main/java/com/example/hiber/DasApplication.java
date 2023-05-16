package com.example.hiber;

import com.example.hiber.school.JPAEx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication

public class DasApplication {



	public static void main(String[] args)  {

		ConfigurableApplicationContext ctx= SpringApplication.run(DasApplication.class, args);


		//Реализация через анотацию
		JPAEx dependencyOwner = ctx.getBean(JPAEx.class);
		dependencyOwner.getReqwest();





	}

}
