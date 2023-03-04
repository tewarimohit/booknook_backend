package com.mohit.bookstore.repository;

import com.mohit.bookstore.models.Book;

import java.util.List;

public interface SearchRepository {

    List<Book> findByTitle(String text);
}
