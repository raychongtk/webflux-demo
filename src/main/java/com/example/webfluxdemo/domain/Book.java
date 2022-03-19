package com.example.webfluxdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author raychong
 */
@Table
public class Book implements Persistable<String> {
    @Id
    public String id;

    public String name;

    public String author;

    @Transient
    @JsonIgnore
    public boolean newBook;

    @Override
    public String getId() {
        return id;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return newBook;
    }
}
