package com.example.bookapp.service;

import com.example.bookapp.model.Book;
import com.example.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Book addBook(Book book) {
        return repo.save(book);
    }

    // READ
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // UPDATE
    public Book updateBook(Long id, Book book) {
        Book b = repo.findById(id).orElseThrow();
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        return repo.save(b);
    }

    // DELETE
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
