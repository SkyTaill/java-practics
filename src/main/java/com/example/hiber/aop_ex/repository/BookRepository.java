package com.example.hiber.aop_ex.repository;

import com.example.hiber.aop_ex.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findBookByTitle(String title);
}