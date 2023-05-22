package com.example.hiber.aop_ex.service;

import com.example.hiber.aop_ex.entity.Book;
import com.example.hiber.aop_ex.repository.BookRepository;
import com.example.hiber.aop_ex.util.CustomResponse;
import com.example.hiber.aop_ex.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        log.info("all book is take");
        return new CustomResponse<>(books, CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> getBookByTitle(String title){
        Book book;
        try {
            log.info("Пытаемся получить книгу с названием {}",title);
             book=bookRepository.findBookByTitle(title).orElseThrow();
        }catch (NoSuchElementException e){
            log.error(e.getMessage(),e);
            return new CustomResponse<>(null,CustomStatus.NOT_FOUND);
        }catch (Exception e){
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("Книга с названием {} получена",title);
        return new CustomResponse<>(Stream.of(book).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> addBook(Book book){
        Book newBook;
        try{
            log.info("Добавляем книгу {}",book.getTitle());
             newBook=bookRepository.save(book);

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new CustomResponse<>(null,CustomStatus.NOT_FOUND);
        }

        log.info("Книга с названием {} добавлена",book.getTitle());
        return new CustomResponse<>(Stream.of(newBook).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }
}
