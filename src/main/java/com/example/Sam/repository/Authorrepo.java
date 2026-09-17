package com.example.Sam.repository;

import com.example.Sam.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Authorrepo extends JpaRepository<Author, Long> {
    
}
