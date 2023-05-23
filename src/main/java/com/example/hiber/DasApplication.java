package com.example.hiber;

import com.example.hiber.aop_ex.entity.Book;
import com.example.hiber.aop_ex.repository.BookRepository;
import com.example.hiber.school.JPAEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication

public class DasApplication implements CommandLineRunner {

	@Autowired
	private final BookRepository bookRepository;

	public DasApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args)  {

		ConfigurableApplicationContext ctx= SpringApplication.run(DasApplication.class, args);


		//Реализация через анотацию
		JPAEx dependencyOwner = ctx.getBean(JPAEx.class);
		dependencyOwner.getReqwest();

	}

	@Override
	public void run(String... args) throws Exception {
		Book book1= new Book("Война и Мир","Толстой");
		Book book2= new Book("Война и Мир22","Толстой22");
		Book book3= new Book("Война и Мир33","Толстой22");
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
	}
}
