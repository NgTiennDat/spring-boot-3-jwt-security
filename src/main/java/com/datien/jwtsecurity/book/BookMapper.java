package com.datien.jwtsecurity.book;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookResponse toBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthorName(book.getAuthorName());
        bookResponse.setPublisher(book.getPublisher());
        bookResponse.setSynopsis(book.getSynopsis());
        bookResponse.setAvailable(book.isAvailable());
        return bookResponse;
    }
}
