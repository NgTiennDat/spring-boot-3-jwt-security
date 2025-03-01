package com.datien.jwtsecurity.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public ResponseEntity<?> createBook(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPublisher(request.getPublisher());
        book.setSynopsis(request.getSynopsis());
        book.setAuthorName(request.getAuthorName());
        book.setAuthorEmail(request.getAuthorEmail());
        book.setAvailable(true);
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }
}
