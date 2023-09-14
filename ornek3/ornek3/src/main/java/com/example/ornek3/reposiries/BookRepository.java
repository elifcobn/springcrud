package com.example.ornek3.reposiries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ornek3.models.Book;


public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findBookById(Long id);    

}
