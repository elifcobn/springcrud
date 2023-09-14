package com.example.ornek3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ornek3.models.Book;


@Service("seviceBook")
public interface BookService {
    void createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long bookId);
    List<Book> getAllBooks();
    Optional<Book> findBookById(Long bookId);

 /*    @Autowired  
    BookRepository bookRepository;  
  
    public List<Book> getAllBook()   
    {  
    List<Book> book = new ArrayList<Book>();  
    bookRepository.findAll().forEach(book1 -> book.add(book1));  
        return book;  
    }  
    
    public Book getBookById(int id)   
    {  
        return bookRepository.findById(id).get();  
    }  
    
    public void saveOrUpdate(Book book)   
    {  
        bookRepository.save(book);  
    }    
    public void delete(int id)   
    {  
        bookRepository.deleteById(id);  
    }  
      
    public void update(Book book, int bookid) 
    {  
        bookRepository.save(book);  
    }  shift alt a */
}
