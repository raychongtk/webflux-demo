package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.domain.Book;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveSortingRepository<Book, String> {
}
