package com.mohit.bookstore.repository;

import com.mohit.bookstore.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BooksRepository extends MongoRepository<Book,String>
{
}
