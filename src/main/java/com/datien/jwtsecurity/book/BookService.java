package com.datien.jwtsecurity.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void savedBook(BookRequest request) {
        var newBook = new Book();
        newBook.setTitle(request.getTitle());
        newBook.setAuthorName(request.getAuthorName());
        newBook.setPublisher(request.getPublisher());
        newBook.setSynopsis(request.getSynopsis());
        newBook.setAvailable(request.isAvailable());
        bookRepository.save(newBook);
    }
}
