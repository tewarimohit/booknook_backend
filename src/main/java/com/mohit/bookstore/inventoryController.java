package com.mohit.bookstore;

import com.mohit.bookstore.models.Book;
import com.mohit.bookstore.repository.BooksRepository;
import com.mohit.bookstore.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class inventoryController {

    @Autowired
    BooksRepository repo;

    @Autowired
    SearchRepository searchRepo;
    @ApiIgnore
    @RequestMapping(value="/")
    @CrossOrigin
    public void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("swagger-ui.html");
    }

    @GetMapping("/all-books")
    @CrossOrigin
    public List<Book>getAllBooks(){
return repo.findAll();
    }

    @GetMapping("/all-books/{text}")
    @CrossOrigin
    public List<Book> search(@PathVariable String text){
        return searchRepo.findByTitle(text);
    }

    @PostMapping("/post-books")
    @CrossOrigin
    public Book addPost(@RequestBody Book post){
        return repo.save(post);
    }
}
