package com.datien.jwtsecurity.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {
    private final BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<?> createBook(
            @RequestBody BookRequest request
    ) {
        return this.bookService.createBook(request);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return this.bookService.getAll();
    }
}
