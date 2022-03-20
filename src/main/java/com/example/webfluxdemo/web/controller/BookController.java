package com.example.webfluxdemo.web.controller;

import com.example.webfluxdemo.domain.Book;
import com.example.webfluxdemo.service.BookService;
import com.example.webfluxdemo.web.apipayload.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author raychong
 */
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/v1/book/{id}")
    public Mono<Book> get(@PathVariable String id) {
        return bookService.get(id);
    }

    @GetMapping("/api/v1/book")
    public Flux<Book> getAll() {
        return bookService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/book")
    public void create(@Valid @RequestBody CreateBookRequest request) {
        bookService.create(request.name, request.author).subscribe();
    }
}
