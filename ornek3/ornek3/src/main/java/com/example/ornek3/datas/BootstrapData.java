package com.example.ornek3.datas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ornek3.models.Book;
import com.example.ornek3.reposiries.BookRepository;
import com.example.ornek3.services.BookService;

@Component
public class BootstrapData implements CommandLineRunner {
    @Autowired
    BookService bookookService;
    private final BookRepository bookRepository;

    public BootstrapData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Book book = new Book();
        book.setAuthor("Osamu Dazai");
        book.setBookname("İnsanliğimi Yitirirken");
        book.setPrice(100);
        bookRepository.save(book);    
    }
}
