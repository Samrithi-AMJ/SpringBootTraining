package com.example.Sam.repository;

import com.example.Sam.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Memberrepo extends JpaRepository<Member, Long> {
    
}
