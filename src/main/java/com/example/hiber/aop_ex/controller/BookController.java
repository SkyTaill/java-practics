package com.example.hiber.aop_ex.controller;

import com.example.hiber.aop_ex.entity.Book;
import com.example.hiber.aop_ex.service.BookService;
import com.example.hiber.aop_ex.util.CustomResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public CustomResponse<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{title}")
    public CustomResponse<Book> getBookByTitle(@PathVariable("title") String title) {
        return null;
    }

    @PostMapping("/books")
    public CustomResponse<Book> addBook(@RequestBody Book book) {
        return null;
    }
}
