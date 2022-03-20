package com.example.webfluxdemo.web.handler;

import com.example.webfluxdemo.domain.Book;
import com.example.webfluxdemo.service.BookService;
import com.example.webfluxdemo.web.apipayload.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @author raychong
 */
@Component
public class BookHandler {
    @Autowired
    BookService bookService;

    public Mono<ServerResponse> get(ServerRequest request) {
        Mono<Book> bookMono = bookService.get(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(bookMono, Book.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<Book> bookFlux = bookService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(bookFlux, Book.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(CreateBookRequest.class)
                      .flatMap(book -> bookService.create(book.name, book.author))
                      .flatMap(newBook -> ServerResponse.created(URI.create("/api/v2/book/" + newBook.getId()))
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .build()
                      );
    }
}
