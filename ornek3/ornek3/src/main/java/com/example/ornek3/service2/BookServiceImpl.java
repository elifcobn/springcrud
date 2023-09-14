package com.example.ornek3.service2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ornek3.models.Book;
import com.example.ornek3.reposiries.BookRepository;
import com.example.ornek3.services.BookService;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findBookById(book.getId()).get();
        existingBook.setAuthor(book.getAuthor());
        existingBook.setBookname(book.getBookname());
        existingBook.setId(book.getId());
        existingBook.setPrice(book.getPrice());
        Book updatedBook = bookRepository.save(existingBook);
        return updatedBook;
    }
    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);

    }
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long bookId) {
        return bookRepository.findBookById(bookId);
    } 
}
