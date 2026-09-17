package com.example.Sam.services;

import org.springframework.stereotype.Service;
import com.example.Sam.repository.Authorrepo;
import com.example.Sam.model.Author;
import java.util.List;


@Service 
public class Authorser {
    private final Authorrepo authorrepo;

    public Authorser(Authorrepo authorrepo) {
        this.authorrepo = authorrepo;
    }
    public Author addAuthor(Author author) {
        return authorrepo.save(author);
    }
    public List<Author> getAllAuthors() {
        return authorrepo.findAll();
    }
    public Author getAuthorById(Long id) {
        return authorrepo.findById(id).orElseThrow(() -> new RuntimeException("Author not found "));
    }
    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = authorrepo.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        existingAuthor.setCountry(updatedAuthor.getCountry());
        existingAuthor.setName(updatedAuthor.getName());
        return authorrepo.save(existingAuthor);
    }
    public void deleteAuthor(Long id) {
        authorrepo.deleteById(id);
    }
    

}
