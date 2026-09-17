package com.example.Sam.repository;

import com.example.Sam.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Book, Long> {
    
}
