package com.example.hiber.aop_ex.service;

import com.example.hiber.aop_ex.entity.Book;
import com.example.hiber.aop_ex.repository.BookRepository;
import com.example.hiber.aop_ex.util.CustomResponse;
import com.example.hiber.aop_ex.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {


    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public CustomResponse<Book> getAll() {
        List<Book> books;
        try {
            log.info("Попытка получить все книги");
            books = bookRepository.findAll();

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new CustomResponse<>(null,CustomStatus.EXCEPTION);
        }
        return new CustomResponse<>(books, CustomStatus.SUCCESS);
    }
}
