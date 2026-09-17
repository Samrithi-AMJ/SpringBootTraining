package com.example.Sam.services;

import org.springframework.stereotype.Service;
import com.example.Sam.model.Book;
import com.example.Sam.repository.Bookrepo;
import java.util.List;

@Service 
public class Bookservices {
  /*   public Book getBook() {
        // Logic to retrieve a book from the database or any other source
        return new Book("Java", "James Gosling", 599.0);
    }
    public Book addBook(Book book) {
        // Logic to add a book to the database or any other source
        return book; // Return the added book (in a real application, you would save it to the database)
    }*/

    private final Bookrepo bookrepo;

    public Bookservices(Bookrepo bookrepo) {
        this.bookrepo = bookrepo;
    }
    public Book addBook(Book book) {
        return bookrepo.save(book);
    }
    
    public List<Book> getAllBooks() {
        return bookrepo.findAll();
    }
    public Book getBookById(Long id) {
        return bookrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found "));
    }
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        return bookrepo.save(existingBook);
    }
    public void deleteBook(Long id) {
        if (!bookrepo.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookrepo.deleteById(id);
    }
}
