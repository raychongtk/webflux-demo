package com.example.webfluxdemo.web.apipayload;

import javax.validation.constraints.NotBlank;

/**
 * @author raychong
 */
public class CreateBookRequest {
    @NotBlank
    public String name;

    @NotBlank
    public String author;
}
