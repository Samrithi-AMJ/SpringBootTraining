package com.example.Sam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sam.model.Book;
import com.example.Sam.services.Bookservices;

@RestController
@RequestMapping("/books")
public class Bookcontroller {

    private final Bookservices services;

    public Bookcontroller(Bookservices services) {
        this.services = services;
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return services.getAllBooks();
    }

    // Get book by ID
    @GetMapping("/id")
    public Book getBook(@RequestParam Long id) {
        return services.getBookById(id);
    }

    // Add book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return services.addBook(book);
    }
    // Update book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        return services.updateBook(id, book);
    }

    // Delete book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        services.deleteBook(id);
        return "Book with ID " + id + " has been deleted.";
    }
}