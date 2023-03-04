package com.mohit.bookstore.repository;

import com.mohit.bookstore.models.Book;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImplementation implements SearchRepository{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Book> findByTitle(String text) {

        final List<Book> books=new ArrayList<>();

        MongoDatabase database = client.getDatabase("booksData");
        MongoCollection<Document> collection = database.getCollection("books");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", "title"))),
                new Document("$sort",
                        new Document("price", 1L))));


        result.forEach(doc->books.add(converter.read(Book.class,doc)));
        return books;
    }
}
