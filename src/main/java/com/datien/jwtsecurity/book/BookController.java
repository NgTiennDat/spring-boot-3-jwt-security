package com.datien.jwtsecurity.book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookResponse> savedBook(
            @RequestBody @Valid BookRequest request
    ) {
        bookService.savedBook(request);
        return ResponseEntity.ok().build();
    }
}
