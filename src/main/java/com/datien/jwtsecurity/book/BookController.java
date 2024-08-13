package com.datien.jwtsecurity.book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> savedBook(
            @RequestBody @Valid BookRequest request,
            Authentication connectedUser
    ) {
        bookService.savedBook(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> getAllBooks(
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(bookService.getAllBooks(connectedUser));
    }
}
