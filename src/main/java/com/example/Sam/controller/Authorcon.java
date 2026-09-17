package com.example.Sam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Sam.model.Author;
import com.example.Sam.services.Authorser;
import java.util.List;


@RestController 
@RequestMapping("/authors")
public class Authorcon {
    private final Authorser authorser;
    public Authorcon(Authorser authorser) {
        this.authorser = authorser;
    }
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorser.getAllAuthors();
    }
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorser.getAuthorById(id);
    }
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorser.addAuthor(author);
    }
    
    @PutMapping
    public Author updateAuthor(@RequestParam Long id, @RequestBody Author updatedAuthor) {
        return authorser.updateAuthor(id, updatedAuthor);
    }
    @DeleteMapping
    public String deleteAuthor(@RequestParam Long id) {
        authorser.deleteAuthor(id);
        return "Author with ID " + id + " has been deleted.";
    }
}
