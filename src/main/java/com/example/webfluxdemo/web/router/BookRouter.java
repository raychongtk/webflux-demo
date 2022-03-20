package com.example.webfluxdemo.web.router;

import com.example.webfluxdemo.web.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author raychong
 */
@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> bookRoutes(BookHandler bookHandler) {
        return route().GET("/api/v2/book", bookHandler::getAll)
                      .GET("/api/v2/book/{id}", bookHandler::get)
                      .POST("/api/v2/book", bookHandler::create)
                      .build();
    }
}
