package com.datien.jwtsecurity.book;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequest request) {
        var book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthorName(request.getAuthorName());
        book.setPublisher(request.getPublisher());
        book.setSynopsis(request.getSynopsis());
        book.setAvailable(request.isAvailable());
        return book;
    }

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
