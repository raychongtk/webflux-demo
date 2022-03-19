package com.example.webfluxdemo.service;

import com.example.webfluxdemo.domain.Book;
import com.example.webfluxdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author raychong
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void create(String name, String author) {
        var book = new Book();
        book.id = UUID.randomUUID().toString();
        book.name = name;
        book.author = author;
        book.newBook = true;
        bookRepository.save(book).subscribe();
    }

    public Mono<Book> get(String id) {
        return bookRepository.findById(id);
    }

    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }
}
