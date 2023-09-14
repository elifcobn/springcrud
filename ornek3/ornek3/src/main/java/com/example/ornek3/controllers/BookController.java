package com.example.ornek3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ornek3.models.Book;
import com.example.ornek3.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;
 
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findBookById(@PathVariable("id") Long bookId){
        Optional<Book> book = bookService.findBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List <Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
       
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id")Long bookId, @RequestBody Book book){ 
        book.setId(bookId);
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id")Long bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book successfully deleted", HttpStatus.OK);    
        
    } 
}
